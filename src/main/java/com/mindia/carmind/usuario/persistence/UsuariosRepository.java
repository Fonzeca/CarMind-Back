package com.mindia.carmind.usuario.persistence;


import java.util.List;

import com.mindia.carmind.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsername(String username);

    Usuario findByUsernameAndEmpresa(String username, Integer empresa);

    Usuario findByIdAndEmpresa(Integer id, Integer empresa);

    List<Usuario> findByEmpresa(Integer empresa);

}
