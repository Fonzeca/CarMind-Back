package com.mindia.carmind.usuario.persistence;

import com.mindia.carmind.entities.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

}
