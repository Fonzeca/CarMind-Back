package com.mindia.carmind.defecto.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindia.carmind.entities.Defecto;

@Repository
public interface DefectoRepository extends JpaRepository<Defecto, Integer> {

}
