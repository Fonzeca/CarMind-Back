package com.mindia.carmind.entities.interfaces;

import java.util.List;

import com.mindia.carmind.version.pojo.AltaPojo;
import com.mindia.carmind.version.pojo.ModificarPojo;
import com.mindia.carmind.version.pojo.VersionView;

public interface IVersion {

    void altaVersion(AltaPojo pojo);

    void modificarVersion(ModificarPojo pojo);

    void bajaVersion(String version);

    VersionView obtenerVersionByVersion(String version);

    List<VersionView> getAllVersiones();
}
