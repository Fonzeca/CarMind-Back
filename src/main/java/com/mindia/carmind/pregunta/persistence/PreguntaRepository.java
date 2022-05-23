package com.mindia.carmind.pregunta.persistence;

import com.mindia.carmind.entities.Pregunta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
}
