package com.mindia.carmind.usuario.persistence;


import java.util.List;
import java.util.Optional;

import com.mindia.carmind.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsernameAndActiveTrue(String username);

    //Se usa para dar de alta un usuario que se dio de baja
    Usuario findByUsernameAndActiveFalse(String username);

    Optional<Usuario> findByIdAndActiveTrue(Integer id);

    Usuario findByUsernameAndEmpresaAndActiveTrue(String username, Integer empresa);

    Usuario findByIdAndEmpresaAndActiveTrue(Integer id, Integer empresa);

    List<Usuario> findByEmpresaAndActiveTrue(Integer empresa);

    List<Usuario> findByEmpresaAndAdministradorTrueAndActiveTrue(Integer empresa);

}
