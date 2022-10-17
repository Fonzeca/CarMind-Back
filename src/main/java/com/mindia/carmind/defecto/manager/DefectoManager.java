package com.mindia.carmind.defecto.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindia.carmind.defecto.persistence.DefectoRepository;
import com.mindia.carmind.entities.Defecto;
import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.usuario.persistence.UsuariosRepository;

public class DefectoManager {

    
    @Autowired
    UsuariosManager usuariosManager;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    DefectoRepository defectoRepository;


    public List<Defecto> getAllDefectos() {
        int empresaId = usuariosManager.getLoggeduser().getEmpresa();
       
        Iterable<Integer> userIds = usuariosRepository.findByEmpresaAndActiveTrue(empresaId).stream().map(x -> x.getId()).collect(Collectors.toList());

        List<Defecto> defectos = defectoRepository.findAllById(userIds);

        return defectos;
    }
    
}
