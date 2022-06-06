package com.mindia.carmind.usuario.controller;

import java.util.List;

import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.usuario.pojo.AltaPojo;
import com.mindia.carmind.usuario.pojo.ModificarPojo;
import com.mindia.carmind.usuario.pojo.OfflineDatosView;
import com.mindia.carmind.usuario.pojo.RecuperacionPojo;
import com.mindia.carmind.usuario.pojo.UsuarioView;
import com.mindia.carmind.usuario.pojo.sync.SyncView;
import com.mindia.carmind.usuario.pojo.userHub.TokenView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/loggedUser")
    public UsuarioView getLoggedUser() {
        return manager.getLoggeduser();
    }

    @GetMapping("/validate")
    public void validateToken(){
        return;
    }

    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }

    @GetMapping("/usuario/{id}")
    public UsuarioView getUsuarioById(@PathVariable String id) {
        return manager.obtenerUsuarioById(id);
    }

    @GetMapping("/usuario")
    public List<UsuarioView> getAllUsuarios() {
        return manager.getAllUsuario();
    }

    @PostMapping("/usuario")
    public void altaUsuario(@RequestBody AltaPojo pojo) {
        manager.altaUsuario(pojo, null);
    }

    @PutMapping("/usuario")
    public void editarUsuario(@RequestBody ModificarPojo pojo) {
        manager.modificarConductor(pojo);
    }

    @DeleteMapping("/usuario/{id}")
    public void borrarUsuario(@PathVariable Integer id) {
        manager.bajaConductor(id);
    }

    @GetMapping("/usuario/modo-offline")
    public OfflineDatosView pasarModoOffline(){
        return manager.obtenerBaseDeDatosOffline();
    }

    @PostMapping("/usuario/sync")
    public void sincronizarDatos(@RequestBody SyncView pojo){
        manager.sincronizarDatos(pojo);
    }

    @PostMapping("/usuario/newPassword")
    public void nuevaContraseñaFirstLogin(@RequestParam("password") String password){
        manager.cambiarContraseñaFirstLogin(password);
    }

    @PostMapping("/public/usuario/recuperar")
    public void enviarTokenRecuperacionPassword(@RequestParam("email") String email){
        manager.enviarTokenRecuperacionPassword(email);
    }

    @PostMapping("/public/usuario/validateRecoverToken")
    public void validateRecoverToken(@RequestBody RecuperacionPojo pojo){
        manager.validateRecoverToken(pojo);
    }

    @PostMapping("/public/usuario/resetPassword")
    public void resetPassword(@RequestBody RecuperacionPojo pojo){
        manager.resetPassword(pojo);
    }
    

}
