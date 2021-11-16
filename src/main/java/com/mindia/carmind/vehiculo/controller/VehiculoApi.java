package com.mindia.carmind.vehiculo.controller;

import java.util.List;

import com.mindia.carmind.vehiculo.manager.VehiculoManager;
import com.mindia.carmind.vehiculo.pojo.AltaPojo;
import com.mindia.carmind.vehiculo.pojo.ModificarPojo;
import com.mindia.carmind.vehiculo.pojo.VehiculoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculoApi {

    @Autowired
    VehiculoManager manager;

    @GetMapping("/vehiculo")
    public List<VehiculoView> getAllVehiculo() {
        return manager.getAllVehiculos();
    }

    @GetMapping("/vehiculo/{id}")
    public VehiculoView getVehiculo(@PathVariable String id) {
        return manager.obtenerVehiculoById(id);
    }

    @PostMapping("/vehiculo")
    public void altaVehiculo(@RequestBody AltaPojo pojo) {
        manager.altaVehiculo(pojo);
    }

    @PutMapping("/vehiculo")
    public void editarVehiculo(@RequestBody ModificarPojo pojo) {
        manager.modificarVehiculo(pojo);
    }

    @DeleteMapping("/vehiculo")
    public void borrarVehiculo(@RequestAttribute("id") String id) {

        manager.bajaVehiculo(id);
    }
}
