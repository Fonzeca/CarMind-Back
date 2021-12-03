package com.mindia.carmind.seccion.persistence;

import java.util.List;

import com.mindia.carmind.entities.Seccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Integer> {

    Seccion findByIdAndActivoTrue(Integer id);

    List<Seccion> findByActivoTrue();
}
