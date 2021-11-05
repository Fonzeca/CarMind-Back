package com.mindia.carmind.usuario.controller;

import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.usuario.pojo.AltaPojo;
import com.mindia.carmind.usuario.pojo.ModificarPojo;
import com.mindia.carmind.usuario.pojo.UsuarioView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosApi {

    @Autowired
    UsuariosManager manager;

    @GetMapping("/usuarios")
    public UsuarioView getUsuario(@RequestParam("id") String id) {

        return manager.obtenerUsuarioById(id);
    }

    @PostMapping("/usuarios/alta")
    public void altaUsuario(@RequestAttribute("pojo") AltaPojo pojo) {
        manager.altaConductor(pojo);
    }

    @PutMapping("/usuarios/editar")
    public void editarUsuario(@RequestAttribute("pojo") ModificarPojo pojo) {

        manager.modificarConductor(pojo);
    }

    @DeleteMapping("/usuarios/borrar")
    public void borrarUsuario(@RequestAttribute("id") String id) {

        manager.bajaConductor(id);
    }

}
