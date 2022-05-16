package com.mindia.carmind.usuario.manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mindia.carmind.entities.Usuario;
import com.mindia.carmind.entities.Vehiculo;
import com.mindia.carmind.entities.interfaces.IUsuario;
import com.mindia.carmind.evaluacion.manager.EvaluacionManager;
import com.mindia.carmind.usuario.persistence.UsuariosRepository;
import com.mindia.carmind.usuario.pojo.AltaPojo;
import com.mindia.carmind.usuario.pojo.ModificarPojo;
import com.mindia.carmind.usuario.pojo.OfflineDatosView;
import com.mindia.carmind.usuario.pojo.RecuperacionPojo;
import com.mindia.carmind.usuario.pojo.UsuarioView;
import com.mindia.carmind.usuario.pojo.sync.LogUsoView;
import com.mindia.carmind.usuario.pojo.sync.SyncView;
import com.mindia.carmind.usuario.pojo.userHub.LoggedView;
import com.mindia.carmind.usuario.pojo.userHub.TokenView;
import com.mindia.carmind.utils.exception.custom.UserHubException;
import com.mindia.carmind.vehiculo.manager.VehiculoManager;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuariosManager implements IUsuario {
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

    public TokenView login(String username, String password) {
        Usuario u = repository.findByUsernameAndActiveTrue(username);
        if (u == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario inexistente.");
        }
        return userHubManager.login(username, password);
    }

    @Override
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

        // Le damos de alta en nuestra base de datos
        Usuario usuario = new Usuario();

        if (repository.findByUsernameAndActiveTrue(pojo.getUsername()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Usuario duplicado");
        }

        usuario.setAdministrador(pojo.getAdministrador());

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

    @Override
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

        userHubManager.modifyUsuario(pojo);

        usuario.setNombre(pojo.getNombre());
        usuario.setApellido(pojo.getApellido());
        usuario.setDni(pojo.getDni());

        usuario.setAdministrador(pojo.getAdministrador());

        repository.save(usuario);
    }

    @Override
    @Transactional
    public void bajaConductor(Integer id) {
        UsuarioView logged = getLoggeduser();
        
        if(logged.getId().equals(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No podes eliminar tu usuario.");
        }

        Usuario user = repository.getById(id);
        user.setActive(false);
        for (Vehiculo vehiculo : user.getListOfVehiculo()) {
            vehiculo.setUsuarioIdUsando(null);

            vehiculosRepository.save(vehiculo);
        }

        repository.save(user);
    }

    @Override
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
        UsuarioView user = obtenerUsuarioByUsername(email);
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
        data.setLogEvaluacion(evaluacionManager.historialDeEvaluacionesByLoggedUser());
        data.setVehiculos(vehiculoManager.getAllVehiculosWithPendientes());

        try {
            var current = vehiculoManager.getCurrentVehiculo();

            data.setIdVehiculoActual(current.getId());
        } catch (Exception e) {
        }        
        return data;
    }

    public void sincronizarDatos(SyncView sync){
        //Ordeno los datos para que quede primero el ultimo log
        var format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        var optLog = sync.getLogUso().stream().sorted(new Comparator<LogUsoView>() {

            @Override
            public int compare(LogUsoView o1, LogUsoView o2) {
                LocalDateTime date1 = LocalDateTime.parse(o1.getFecha(), format);
                LocalDateTime date2 = LocalDateTime.parse(o2.getFecha(), format);
                return date2.compareTo(date1);
            }
        }).findFirst();

        //Verifico que exista el primero
        if(optLog.isPresent()){
            var log = optLog.get();
            //Si fue un "en uso" llamo a la manager para que inicie el uso
            if(log.getEnUso()){
                vehiculoManager.iniciarUso(log.getVehiculoId());
            }
        }

        //----------

        sync.getEvaluacionesRealizadas().stream().forEach(x -> {
            LocalDateTime date = LocalDateTime.parse(x.getFecha(), format);

            evaluacionManager.realizarEvaluacion(x.getEvaluacionId(), x.getRespuesta(), date);
        });

    }

}
