package com.mindia.carmind.vehiculo.persistence;


import com.mindia.carmind.entities.Documento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
    
}