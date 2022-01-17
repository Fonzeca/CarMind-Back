package com.mindia.carmind.pregunta.persistence;

import com.mindia.carmind.entities.LogPregunta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogPreguntaRepository extends JpaRepository<LogPregunta, Integer> {

}
