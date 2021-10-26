package com.mindia.carmind.entities.interfaces;

import com.mindia.carmind.vehiculo.pojo.*;

public interface IVehiculos {

    void altaVehiculo(AltaPojo pojo);

    void modificarVehiculo(ModificarPojo pojo);

    void bajaVehiculo(String id);

    VehiculoView obtenerVehiculoById(String id);
}
