package com.mindia.carmind.empresa.manager;

import com.mindia.carmind.empresa.persistence.EmpresaRepository;
import com.mindia.carmind.empresa.pojo.AltaPojo;
import com.mindia.carmind.entities.Empresa;
import com.mindia.carmind.usuario.manager.UsuariosManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmpresaManager {

    @Autowired
    UsuariosManager usuariosManager;

    @Autowired
    EmpresaRepository repository;

    @Transactional
    public void crearEmpresa(AltaPojo alta){

        if(repository.findByNombre(alta.getNombre()) != null ){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Empresa duplicada");
        }

        Empresa empresa = new Empresa();
        empresa.setNombre(alta.getNombre());
        empresa.setUnidadDistancia(alta.getUnidadDistancia());

        repository.save(empresa);

        usuariosManager.altaUsuario(alta.getUsuarioAdmin(), empresa.getId());

    }
}
