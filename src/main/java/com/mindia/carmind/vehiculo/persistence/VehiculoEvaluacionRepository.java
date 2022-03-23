package com.mindia.carmind.vehiculo.persistence;


import java.util.List;

import com.mindia.carmind.entities.VehiculoEvaluacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoEvaluacionRepository extends JpaRepository<VehiculoEvaluacion, Integer> {

    List<VehiculoEvaluacion> findByVehiculoId(Integer vehiculoId);
}   