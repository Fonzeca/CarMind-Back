package com.mindia.carmind.evaluacion.persistence;

import java.util.List;

import com.mindia.carmind.entities.LogEvaluacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEvaluacionRepository extends JpaRepository<LogEvaluacion, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM log_evaluacion WHERE evaluacion_id = ?1 ORDER BY fecha DESC LIMIT 1")
    public LogEvaluacion getLastLogById(Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM log_evaluacion ORDER BY fecha DESC")
    List<LogEvaluacion> getAllFechaDesc();

    @Query(nativeQuery = true, value = "SELECT * FROM log_evaluacion WHERE usuario_id = ?1 ORDER BY fecha DESC")
    List<LogEvaluacion> getAllByUserIdFechaDesc(int userId);

    LogEvaluacion findByVehiculoIdOrderByFechaDesc(Integer vehiculoId);

    List<LogEvaluacion> findByVehiculoIdAndParaRevisarTrue(Integer vehiculoId);
}
