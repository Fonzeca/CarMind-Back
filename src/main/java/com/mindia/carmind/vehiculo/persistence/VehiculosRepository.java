package com.mindia.carmind.vehiculo.persistence;


import java.util.List;

import com.mindia.carmind.entities.Vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculosRepository extends JpaRepository<Vehiculo, Integer> {
    List<Vehiculo> findByEmpresaId(Integer empresaId);

    List<Vehiculo> findByusuarioIdUsando(Integer usuarioId);

    Vehiculo findByPatente(String patente);
}