package com.mindia.carmind.vehiculo.persistence;


import com.mindia.carmind.entities.TipoDocumento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
    
}