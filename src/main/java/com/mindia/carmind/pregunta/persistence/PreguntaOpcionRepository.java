package com.mindia.carmind.pregunta.persistence;

import com.mindia.carmind.entities.PreguntaOpcion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaOpcionRepository extends JpaRepository<PreguntaOpcion, Integer> {
    
}
