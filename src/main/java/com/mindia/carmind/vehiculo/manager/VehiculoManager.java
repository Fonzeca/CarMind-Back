package com.mindia.carmind.vehiculo.manager;

import com.mindia.carmind.entities.Vehiculos;
import com.mindia.carmind.entities.interfaces.IVehiculos;
import com.mindia.carmind.utils.Convertions;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;
import com.mindia.carmind.vehiculo.pojo.AltaPojo;
import com.mindia.carmind.vehiculo.pojo.ModificarPojo;
import com.mindia.carmind.vehiculo.pojo.VehiculoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoManager implements IVehiculos {
    Convertions c;

    @Autowired
    VehiculosRepository repository;

    public void altaVehiculo(AltaPojo pojo) {

        Vehiculos vehiculo = new Vehiculos();
        vehiculo.setColor(pojo.getColor());
        vehiculo.setFechaService(pojo.getFechaService());
        vehiculo.setLinea(pojo.getLinea());
        vehiculo.setMarca(pojo.getMarca());
        vehiculo.setModelo(pojo.getModelo());
        vehiculo.setUltimaEvaluacion(pojo.getUltimaEvaluacion());

        repository.save(vehiculo);
    }

    public void modificarVehiculo(ModificarPojo pojo) {
        Vehiculos vehiculo = repository.getById(pojo.getId());
        vehiculo.setColor(pojo.getColor());
        vehiculo.setFechaService(pojo.getFechaService());
        vehiculo.setLinea(pojo.getLinea());
        vehiculo.setMarca(pojo.getMarca());
        vehiculo.setModelo(pojo.getModelo());
        vehiculo.setUltimaEvaluacion(pojo.getUltimaEvaluacion());

        repository.save(vehiculo);
    }

    public void bajaVehiculo(String id) {
        repository.deleteById(c.toInt(id));
    }

    public VehiculoView obtenerVehiculoById(String id) {
        Vehiculos v = repository.getById(c.toInt(id));
        VehiculoView vehiculo = new VehiculoView(v);
        return vehiculo;
    }

}