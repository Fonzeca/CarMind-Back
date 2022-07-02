package com.mindia.carmind.vehiculo.persistence;


import java.time.LocalDate;
import java.util.List;

import com.mindia.carmind.entities.Documento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
    
    //buscar todos los que esten a 7 dias mas
    List<Documento> findByVencimientoAndActiveTrue(LocalDate vencimiento);

    //buscar los que esten entre hoy y 14 dias mas
    List<Documento> findByVencimientoBetweenAndActiveTrue(LocalDate fechaDesde, LocalDate fehcaHasta);

    List<Documento> findByVehiculoIdAndVencimientoBetweenAndActiveTrue(Integer vehiculoId, LocalDate fechaDesde, LocalDate fehcaHasta);
    
    List<Documento> findByVehiculoIdAndActiveTrue(Integer vehiculoId);
}