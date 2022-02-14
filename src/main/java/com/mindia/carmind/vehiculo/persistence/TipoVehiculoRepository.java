package com.mindia.carmind.vehiculo.persistence;


import com.mindia.carmind.entities.TipoVehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, Integer> {
    
}