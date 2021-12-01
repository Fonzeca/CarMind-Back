package com.mindia.carmind.entities.interfaces;

import com.mindia.carmind.usuario.pojo.AltaPojo;
import com.mindia.carmind.usuario.pojo.ModificarPojo;
import com.mindia.carmind.usuario.pojo.UsuarioView;
import com.mindia.carmind.usuario.pojo.userHub.TokenView;

public interface IUsuario {

    TokenView login(String username, String password);

    void altaUsuario(AltaPojo pojo);

    void modificarConductor(ModificarPojo pojo);

    void bajaConductor(String id);

    UsuarioView obtenerUsuarioById(String id);
}
