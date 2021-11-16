package com.mindia.carmind.entities.interfaces;

import com.mindia.carmind.vehiculo.pojo.AltaPojo;
import com.mindia.carmind.vehiculo.pojo.ModificarPojo;
import com.mindia.carmind.vehiculo.pojo.VehiculoView;

public interface IVehiculo {

    void altaVehiculo(AltaPojo pojo);

    void modificarVehiculo(ModificarPojo pojo);

    void bajaVehiculo(String id);

    VehiculoView obtenerVehiculoById(String id);
}
