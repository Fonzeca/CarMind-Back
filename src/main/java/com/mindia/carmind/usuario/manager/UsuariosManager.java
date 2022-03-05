package com.mindia.carmind.usuario.manager;

import java.util.List;
import java.util.stream.Collectors;

import com.mindia.carmind.entities.Usuario;
import com.mindia.carmind.entities.interfaces.IUsuario;
import com.mindia.carmind.usuario.persistence.UsuariosRepository;
import com.mindia.carmind.usuario.pojo.AltaPojo;
import com.mindia.carmind.usuario.pojo.ModificarPojo;
import com.mindia.carmind.usuario.pojo.RecuperacionPojo;
import com.mindia.carmind.usuario.pojo.UsuarioView;
import com.mindia.carmind.usuario.pojo.userHub.LoggedView;
import com.mindia.carmind.usuario.pojo.userHub.TokenView;
import com.mindia.carmind.utils.exception.custom.UserHubException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuariosManager implements IUsuario {
    @Autowired

    UsuariosRepository repository;
    @Autowired
    UserHubManager userHubManager;

    public TokenView login(String username, String password) {
        Usuario u = repository.findByUsername(username);
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

        if (repository.findByUsername(pojo.getUsername()) != null) {
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
        Usuario usuario = repository.findByUsernameAndEmpresa(pojo.getUsername(), getLoggeduser().getEmpresa());

        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }

        pojo.setAdministrador(usuario.getAdministrador());

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
    public void bajaConductor(String id) {

        repository.deleteById(Integer.parseInt(id));
    }

    @Override
    public UsuarioView obtenerUsuarioById(String id) {
        Usuario u = repository.findByIdAndEmpresa(Integer.parseInt(id), getLoggeduser().getEmpresa());
        UsuarioView usuario = new UsuarioView(u);

        return usuario;
    }

    public UsuarioView obtenerUsuarioByUsername(String username) {
        Usuario u = repository.findByUsernameAndEmpresa(username, getLoggeduser().getEmpresa());
        UsuarioView usuario = new UsuarioView(u);

        return usuario;
    }

    public UsuarioView getLoggeduser() {
        LoggedView logged = (LoggedView) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario u = repository.findByUsername(logged.getUserName());
        return new UsuarioView(u);
    }

    public List<UsuarioView> getAllUsuario() {
        List<Usuario> usuarios = repository.findByEmpresa(getLoggeduser().getEmpresa());
        return usuarios.stream().map(UsuarioView::new).collect(Collectors.toList());
    }

    public void enviarTokenRecuperacionPassword(String email) {
        userHubManager.enviarTokenRecuperacionPassword(email);
    }

    public void validateRecoverToken(RecuperacionPojo pojo) {
        userHubManager.validateRecoverToken(pojo);
    }

    public void resetPassword(RecuperacionPojo pojo) {
        userHubManager.resetPassword(pojo);
    }

}
