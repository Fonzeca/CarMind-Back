package com.mindia.carmind.usuario.manager;

import com.mindia.carmind.entities.Usuario;
import com.mindia.carmind.entities.interfaces.IUsuario;
import com.mindia.carmind.usuario.persistence.UsuariosRepository;
import com.mindia.carmind.usuario.pojo.AltaPojo;
import com.mindia.carmind.usuario.pojo.ModificarPojo;
import com.mindia.carmind.usuario.pojo.UsuarioView;
import com.mindia.carmind.usuario.pojo.userHub.TokenView;
import com.mindia.carmind.utils.Convertions;
import com.mindia.carmind.utils.exception.custom.UserHubException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuariosManager implements IUsuario {
    Convertions c;

    @Autowired
    UsuariosRepository repository;

    @Autowired
    UserHubManager userHubManager;


    public TokenView login(String username, String password) {
        return userHubManager.login(username, password);
    }

    @Override
    public void altaUsuario(AltaPojo pojo) {
        //Le damos de alta al usuario en userHub
        try {
            userHubManager.altaUsuario(pojo);
        } catch (UserHubException e) {
            //Si el error es un duplicado, significa que ya existia en UserHub
            if(e.getMessage().contains("duplicate key error")){
            }else{
                throw e;
            }
        }

        //Le damos de alta en nuestra base de datos
        Usuario usuario = new Usuario();

        if(repository.findByUsername(pojo.getUsername()) != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Usuario duplicado");
        }

        usuario.setAdministrador(pojo.getAdministrador());

        usuario.setUsername(pojo.getUsername());
        usuario.setDni(pojo.getDni());
        usuario.setApellido(pojo.getApellido());
        usuario.setNombre(pojo.getNombre());
        usuario.setEmpresa(1);

        repository.save(usuario);
    }

    @Override
    public void modificarConductor(ModificarPojo pojo) {
        //Modificamos el usuario en UserHub
        userHubManager.modifyUsuario(pojo);

        Usuario usuario = repository.findByUsername(pojo.getUsername());

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
        Usuario u = repository.getById(Integer.parseInt(id));
        UsuarioView usuario = new UsuarioView(u);

        return usuario;
    }

}
