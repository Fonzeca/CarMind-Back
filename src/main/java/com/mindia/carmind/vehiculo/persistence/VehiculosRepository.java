package com.mindia.carmind.vehiculo.persistence;


import java.util.List;

import com.mindia.carmind.entities.Vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculosRepository extends JpaRepository<Vehiculo, Integer> {
    List<Vehiculo> findByEmpresaIdOrderByUsuarioIdUsandoDesc(Integer empresaId);

    List<Vehiculo> findByEmpresaId(Integer empresaId);

    @Query(nativeQuery = true, value ="SELECT v.id FROM vehiculo v where v.empresa_id = ?1") 
    List<Integer> findIdsByEmpresaId(Integer empresaId);

    List<Vehiculo> findByusuarioIdUsando(Integer usuarioId);

    Vehiculo findByPatente(String patente);

}