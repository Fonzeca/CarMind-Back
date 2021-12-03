package com.mindia.carmind.pregunta.persistence;

import com.mindia.carmind.entities.Seccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Integer> {

}
