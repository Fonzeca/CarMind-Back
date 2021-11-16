package com.mindia.carmind.usuario.manager;

import com.mindia.carmind.entities.Usuario;
import com.mindia.carmind.entities.interfaces.IUsuario;
import com.mindia.carmind.usuario.persistence.UsuariosRepository;
import com.mindia.carmind.usuario.pojo.AltaPojo;
import com.mindia.carmind.usuario.pojo.ModificarPojo;
import com.mindia.carmind.usuario.pojo.UsuarioView;
import com.mindia.carmind.utils.Convertions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosManager implements IUsuario {
    Convertions c;

    @Autowired
    UsuariosRepository repository;

    @Override
    public void altaConductor(AltaPojo pojo) {

        Usuario usuario = new Usuario();
        usuario.setAdministrador(pojo.isAdministrador());
        usuario.setEmpresa(pojo.getEmpresa().getId());
        usuario.setNombre(pojo.getNombre());

        repository.save(usuario);
    }

    @Override
    public void modificarConductor(ModificarPojo pojo) {
        Usuario usuario = repository.getById(pojo.getId());
        usuario.setAdministrador(pojo.isAdministrador());
        usuario.setEmpresa(pojo.getEmpresa().getId());
        usuario.setNombre(pojo.getNombre());

        repository.save(usuario);
    }

    @Override
    public void bajaConductor(String id) {
        repository.deleteById(Integer.parseInt(id));
        ;
    }

    @Override
    public UsuarioView obtenerUsuarioById(String id) {
        Usuario u = repository.getById(Integer.parseInt(id));
        UsuarioView usuario = new UsuarioView(u);

        return usuario;
    }

}
