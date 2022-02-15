package com.mindia.carmind.evaluacion.persistence;

import com.mindia.carmind.entities.LogEvaluacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEvaluacionRepository extends JpaRepository<LogEvaluacion, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM log_evaluacion WHERE evaluacion_id = ?1 ORDER BY fecha DESC LIMIT 1")
    public LogEvaluacion getLastLogById(Integer id);

    LogEvaluacion findByVehiculoIdOrderByFechaDesc(Integer vehiculoId);
}
