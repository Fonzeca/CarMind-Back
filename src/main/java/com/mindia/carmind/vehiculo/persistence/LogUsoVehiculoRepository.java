package com.mindia.carmind.vehiculo.persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.mindia.carmind.entities.LogUsoVehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogUsoVehiculoRepository  extends JpaRepository<LogUsoVehiculo, Integer>{

    List<LogUsoVehiculo> findAllByVehiculoId(Integer vehiculoId);

    LogUsoVehiculo findByVehiculoIdAndUsuarioIdAndFechaFin(Integer vehiculoId, Integer usuarioId, LocalDate fechaFin);

    LogUsoVehiculo findByUsuarioIdAndFechaFin(Integer usuarioId,  LocalDateTime fechaFin);
    
}


