package com.mindia.carmind.notificacion.persistence;

import java.util.List;

import com.mindia.carmind.entities.Notificaciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificaciones, Integer> {

    List<Notificaciones> findByEmpresaId(Integer empresaId);
}
