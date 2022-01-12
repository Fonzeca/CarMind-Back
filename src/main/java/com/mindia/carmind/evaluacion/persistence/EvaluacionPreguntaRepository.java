package com.mindia.carmind.evaluacion.persistence;

import com.mindia.carmind.entities.EvaluacionPregunta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionPreguntaRepository extends JpaRepository<EvaluacionPregunta, Integer> {

}
