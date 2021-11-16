package com.mindia.carmind.vehiculo.persistence;


import com.mindia.carmind.entities.Vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculosRepository extends JpaRepository<Vehiculo, Integer> {
}