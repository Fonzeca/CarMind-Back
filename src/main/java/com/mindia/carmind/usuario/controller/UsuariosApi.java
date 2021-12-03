package com.mindia.carmind.usuario.controller;

import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.usuario.pojo.AltaPojo;
import com.mindia.carmind.usuario.pojo.ModificarPojo;
import com.mindia.carmind.usuario.pojo.UsuarioView;
import com.mindia.carmind.usuario.pojo.userHub.TokenView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosApi {

    @Autowired
    UsuariosManager manager;

    @PostMapping("/login")
    public TokenView getVehiculo(@RequestParam("username") String userName, @RequestParam("password") String password) {
        return manager.login(userName, password);
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('admin')")
    public String test(){
        return "Hello World";
    }

    @GetMapping("/usuario/{id}")
    public UsuarioView getUsuarioById(@PathVariable String id) {
        return manager.obtenerUsuarioById(id);
    }

    @GetMapping("/usuario")
    public UsuarioView getAllUsuarios() {

        return null;
    }

    @PostMapping("/usuario")
    public void altaUsuario(@RequestBody AltaPojo pojo) {
        manager.altaUsuario(pojo);
    }

    @PutMapping("/usuario")
    public void editarUsuario(@RequestBody ModificarPojo pojo) {
        manager.modificarConductor(pojo);
    }

    //Funcionalidad no terminada
    public void borrarUsuario(@PathVariable String id) {

        manager.bajaConductor(id);
    }

}
