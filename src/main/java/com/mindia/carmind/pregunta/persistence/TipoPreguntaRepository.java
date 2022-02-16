package com.mindia.carmind.pregunta.persistence;

import com.mindia.carmind.entities.TipoPregunta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPreguntaRepository extends JpaRepository<TipoPregunta, String> {
    
}
