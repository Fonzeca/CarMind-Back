package com.mindia.carmind.usuario.manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mindia.carmind.entities.LogEvaluacion;
import com.mindia.carmind.entities.LogUsoVehiculo;
import com.mindia.carmind.entities.Usuario;
import com.mindia.carmind.entities.Vehiculo;
import com.mindia.carmind.evaluacion.manager.EvaluacionManager;
import com.mindia.carmind.evaluacion.persistence.LogEvaluacionRepository;
import com.mindia.carmind.usuario.persistence.UsuariosRepository;
import com.mindia.carmind.usuario.pojo.AltaPojo;
import com.mindia.carmind.usuario.pojo.ModificarPojo;
import com.mindia.carmind.usuario.pojo.OfflineDatosView;
import com.mindia.carmind.usuario.pojo.RecuperacionPojo;
import com.mindia.carmind.usuario.pojo.UsuarioView;
import com.mindia.carmind.usuario.pojo.sync.LogEvaluacionRealizada;
import com.mindia.carmind.usuario.pojo.sync.LogUsoView;
import com.mindia.carmind.usuario.pojo.sync.SyncView;
import com.mindia.carmind.usuario.pojo.userHub.LoggedView;
import com.mindia.carmind.usuario.pojo.userHub.TokenView;
import com.mindia.carmind.utils.exception.custom.UserHubException;
import com.mindia.carmind.vehiculo.manager.VehiculoManager;
import com.mindia.carmind.vehiculo.persistence.LogUsoVehiculoRepository;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuariosManager {
    @Autowired
    UsuariosRepository repository;

    @Autowired
    UserHubManager userHubManager;

    @Autowired
    VehiculosRepository vehiculosRepository;

    @Autowired
    VehiculoManager vehiculoManager;

    @Autowired
    EvaluacionManager evaluacionManager;

    @Autowired
    LogUsoVehiculoRepository logUsoVehiculoRepository;

    @Autowired
    LogEvaluacionRepository logEvaluacionRepository;

    public TokenView login(String username, String password, String FCMToken) {
        Usuario u = repository.findByUsernameAndActiveTrue(username);
        if (u == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario inexistente.");
        }
        return userHubManager.login(username, password, FCMToken);
    }

    public void altaUsuario(AltaPojo pojo, Integer idEmpresa) {
        // Le damos de alta al usuario en userHub
        try {
            userHubManager.altaUsuario(pojo);
        } catch (UserHubException e) {
            // Si el error es un duplicado, significa que ya existia en UserHub
            if (e.getMessage().contains("duplicate key error")) {
            } else {
                throw e;
            }
        }

        
        if (repository.findByUsernameAndActiveTrue(pojo.getUsername()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Usuario duplicado");
        }

        //Si se dio de baja, lo damos de alta otra vez.
        //Buscamos por los active en falso, y si da ok, editamos el usuario.
        //Si no da ok, creamos un nuevo usuario
        Usuario usuario = repository.findByUsernameAndActiveFalse(pojo.getUsername());
        if(usuario == null) {
            usuario = new Usuario();
        }

        usuario.setAdministrador(pojo.getAdministrador());
        usuario.setActive(true);
        usuario.setUsername(pojo.getUsername());
        usuario.setDni(pojo.getDni());
        usuario.setApellido(pojo.getApellido());
        usuario.setNombre(pojo.getNombre());

        if (idEmpresa != null) {
            usuario.setEmpresa(idEmpresa);
        } else {
            usuario.setEmpresa(getLoggeduser().getEmpresa());
        }

        repository.save(usuario);
    }

    
    public void modificarConductor(ModificarPojo pojo) {
        // Modificamos el usuario en UserHub
        Usuario usuario = repository.findByUsernameAndEmpresaAndActiveTrue(pojo.getUsername(), getLoggeduser().getEmpresa());

        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }

        // pojo.setAdministrador(usuario.getAdministrador());

        if (pojo.getApellido() == null)
            pojo.setApellido(usuario.getApellido());

        if (pojo.getNombre() == null)
            pojo.setNombre(usuario.getNombre());

        if (pojo.getDni() == null)
            pojo.setDni(usuario.getDni());

        if(pojo.getAdministrador() == null)
            pojo.setAdministrador(usuario.isAdministrador());

        userHubManager.modifyUsuario(pojo);

        usuario.setNombre(pojo.getNombre());
        usuario.setApellido(pojo.getApellido());
        usuario.setDni(pojo.getDni());

        usuario.setAdministrador(pojo.getAdministrador());

        repository.save(usuario);
    }

    
    @Transactional
    public void bajaConductor(Integer id) {
        UsuarioView logged = getLoggeduser();
        Optional<Usuario> user = repository.findByIdAndActiveTrue(id);
        
        if(logged.getId().equals(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No podes eliminar tu usuario.");
        }

        if (user.isEmpty() || user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No podes eliminar tu usuario.");
        }

        Usuario userToDesactive = user.get();
        userToDesactive.setActive(false); 
        for (Vehiculo vehiculo : userToDesactive.getVehiculoList()) {
            vehiculo.setUsuarioIdUsando(null);
            vehiculosRepository.save(vehiculo);
        }

        LogUsoVehiculo log = logUsoVehiculoRepository.findByUsuarioIdAndFechaFin(id, null);
        if(log != null){
            log.setFechaFin(LocalDateTime.now());
            logUsoVehiculoRepository.save(log);
        }

        userHubManager.deleteUsuario(userToDesactive.getUsername());
    }

    
    public UsuarioView obtenerUsuarioById(String id) {
        Usuario u = repository.findByIdAndEmpresaAndActiveTrue(Integer.parseInt(id), getLoggeduser().getEmpresa());
        UsuarioView usuario = new UsuarioView(u);

        return usuario;
    }

    public UsuarioView obtenerUsuarioByUsername(String username) {
        Usuario u = repository.findByUsernameAndEmpresaAndActiveTrue(username, getLoggeduser().getEmpresa());
        UsuarioView usuario = new UsuarioView(u);

        return usuario;
    }

    public UsuarioView getLoggeduser() {
        LoggedView logged = (LoggedView) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario u = repository.findByUsernameAndActiveTrue(logged.getUserName());
        return new UsuarioView(u);
    }

    public List<UsuarioView> getAllUsuario() {
        List<Usuario> usuarios = repository.findByEmpresaAndActiveTrue(getLoggeduser().getEmpresa());
        return usuarios.stream().map(UsuarioView::new).collect(Collectors.toList());
    }

    public void enviarTokenRecuperacionPassword(String email) {
        Usuario user = repository.findByUsernameAndActiveTrue(email);
        if(user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no existe");
        }

        userHubManager.enviarTokenRecuperacionPassword(email, user.getNombre());
    }

    public void validateRecoverToken(RecuperacionPojo pojo) {
        userHubManager.validateRecoverToken(pojo);
    }

    public void resetPassword(RecuperacionPojo pojo) {
        userHubManager.resetPassword(pojo);
    }

    public OfflineDatosView obtenerBaseDeDatosOffline(){
        OfflineDatosView data = new OfflineDatosView();
        data.setLoggedUser(this.getLoggeduser());
        data.setEvaluaciones(evaluacionManager.getAllEvaluacionesWithDetails());
        data.setLogEvaluacion(evaluacionManager.historialDeEvaluacionesByLoggedUser(50));
        data.setVehiculos(vehiculoManager.getAllVehiculosWithPendientes());

        try {
            var current = vehiculoManager.getCurrentVehiculo();

            data.setIdVehiculoActual(current.getId());
        } catch (Exception e) {
        }        
        return data;
    }

    public void sincronizarDatos(SyncView sync){

        List<LogUsoView> newLogsUso = sync.getLogsUso();
        List<LogEvaluacionRealizada> newLogsEvaluacion = sync.getlogsEvaluaciones();
        
        if(!newLogsUso.isEmpty()){
            for(LogUsoView log: newLogsUso){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LogUsoVehiculo logUsoVehiculo = new LogUsoVehiculo();
                logUsoVehiculo.setFechaInicio(LocalDateTime.parse(log.getFechaInicio(), formatter));
                logUsoVehiculo.setFechaFin((log.getFechaFin() != null) ? LocalDateTime.parse(log.getFechaFin(), formatter) : null);
                logUsoVehiculo.setUsuarioId(log.getUsuarioId());
                logUsoVehiculo.setVehiculoId(log.getVehiculoId());
        
                logUsoVehiculoRepository.save(logUsoVehiculo);
            }
        }

        if(!newLogsEvaluacion.isEmpty()){
            int empresaId = getLoggeduser().getEmpresa();
            UsuarioView loggedUser = getLoggeduser();
            
            for(LogEvaluacionRealizada log: newLogsEvaluacion){
                Vehiculo vehiculo = vehiculosRepository.getById(log.getVehiculoId());
                                
                LogEvaluacion logEvaluacion = new LogEvaluacion();
                logEvaluacion.setEvaluacionId(log.getEvaluacionId());
                logEvaluacion.setVehiculoId(vehiculo.getId());
                logEvaluacion.setUsuarioId(loggedUser.getId());
    
                logEvaluacion = logEvaluacionRepository.save(logEvaluacion);
    
                evaluacionManager.saveLogsPregunta(logEvaluacion, loggedUser, vehiculo, log.getRespuestas(), empresaId);
            }
        }
    }


    public void cambiarContraseñaFirstLogin(String password){
        var user = getLoggeduser();
        userHubManager.newPasswordFirstLogin(user.getUsername(), password);
    }
}
