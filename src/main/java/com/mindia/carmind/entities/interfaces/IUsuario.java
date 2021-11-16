package com.mindia.carmind.entities.interfaces;

import com.mindia.carmind.usuario.pojo.AltaPojo;
import com.mindia.carmind.usuario.pojo.ModificarPojo;
import com.mindia.carmind.usuario.pojo.UsuarioView;

public interface IUsuario {

    void altaConductor(AltaPojo pojo);

    void modificarConductor(ModificarPojo pojo);

    void bajaConductor(String id);

    UsuarioView obtenerUsuarioById(String id);
}
