package com.mindia.carmind.vehiculo.controller;

import com.mindia.carmind.vehiculo.manager.VehiculoManager;
import com.mindia.carmind.vehiculo.pojo.AltaPojo;
import com.mindia.carmind.vehiculo.pojo.ModificarPojo;
import com.mindia.carmind.vehiculo.pojo.VehiculoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculoApi {

    @Autowired
    VehiculoManager manager;

    @GetMapping("/vehiculos")
    public VehiculoView getVehiculo(@RequestParam("id") String id) {

        return manager.obtenerVehiculoById(id);
    }

    @GetMapping("/vehiculos/alta")
    public void altaVehiculo(@RequestParam("pojo") AltaPojo pojo) {

        manager.altaVehiculo(pojo);
    }

    @GetMapping("/vehiculos/editar")
    public void editarVehiculo(@RequestParam("pojo") ModificarPojo pojo) {

        manager.modificarVehiculo(pojo);
    }

    @GetMapping("/vehiculos/borrar")
    public void borrarVehiculo(@RequestParam("id") String id) {

        manager.bajaVehiculo(id);
    }
}
