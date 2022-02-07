package com.mindia.carmind.empresa.persistence;

import com.mindia.carmind.entities.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    Empresa findByNombre(String nombre);

}
