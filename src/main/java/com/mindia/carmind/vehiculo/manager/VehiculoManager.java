package com.mindia.carmind.vehiculo.manager;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.mindia.carmind.entities.Vehiculo;
import com.mindia.carmind.entities.interfaces.IVehiculo;
import com.mindia.carmind.utils.Convertions;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;
import com.mindia.carmind.vehiculo.pojo.AltaPojo;
import com.mindia.carmind.vehiculo.pojo.ModificarPojo;
import com.mindia.carmind.vehiculo.pojo.VehiculoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VehiculoManager implements IVehiculo {
    Convertions c;

    @Autowired
    VehiculosRepository repository;

    public void altaVehiculo(AltaPojo pojo) {

        pojo.validate();

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setColor(pojo.getColor());
        vehiculo.setFechaService(pojo.getFechaService());
        vehiculo.setLinea(pojo.getLinea());
        vehiculo.setMarca(pojo.getMarca());
        vehiculo.setModelo(pojo.getModelo());
        vehiculo.setUltimaEvaluacion(pojo.getUltimaEvaluacion());

        repository.save(vehiculo);
    }

    public void modificarVehiculo(ModificarPojo pojo) {

        pojo.validate();

        Vehiculo vehiculo = repository.getById(pojo.getId());

        if(vehiculo == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id incorrecto");
        }

        vehiculo.setColor(pojo.getColor());
        vehiculo.setLinea(pojo.getLinea());
        vehiculo.setMarca(pojo.getMarca());
        vehiculo.setModelo(pojo.getModelo());

        repository.save(vehiculo);
    }

    public void bajaVehiculo(String id) {
        try {
            repository.deleteById(Integer.parseInt(id));
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("No se encontro la entidad Vehiculo con id " + id);
        }
    }

    public VehiculoView obtenerVehiculoById(String id) {
        Vehiculo v = repository.getById(Integer.parseInt(id));
        VehiculoView vehiculo = new VehiculoView(v);
        return vehiculo;
    }

    @Override
    public List<VehiculoView> getAllVehiculos() {
        List<Vehiculo> v = repository.findAll();
        return v.stream().map(VehiculoView::new).collect(Collectors.toList());
    }


}