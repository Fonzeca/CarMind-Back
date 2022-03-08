package com.mindia.carmind.usuario.persistence;


import java.util.List;

import com.mindia.carmind.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsernameAndActiveTrue(String username);

    Usuario findByUsernameAndEmpresaAndActiveTrue(String username, Integer empresa);

    Usuario findByIdAndEmpresaAndActiveTrue(Integer id, Integer empresa);

    List<Usuario> findByEmpresaAndActiveTrue(Integer empresa);

}
