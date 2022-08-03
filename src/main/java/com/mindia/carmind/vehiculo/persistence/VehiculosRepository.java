package com.mindia.carmind.vehiculo.persistence;


import java.util.List;

import com.mindia.carmind.entities.Vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculosRepository extends JpaRepository<Vehiculo, Integer> {
    List<Vehiculo> findByEmpresaIdOrderByUsuarioIdUsandoDesc(Integer empresaId);

    List<Vehiculo> findByEmpresaId(Integer empresaId);

    @Query("SELECT v.id FROM vehiculo v where v.empresa_id = :empresaId") 
    List<Integer> findIdsByEmpresaId(@Param("empresaId") Integer empresaId);

    List<Vehiculo> findByusuarioIdUsando(Integer usuarioId);

    Vehiculo findByPatente(String patente);

}