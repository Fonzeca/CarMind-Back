package com.mindia.carmind.defecto.manager;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindia.carmind.defecto.persistence.DefectoRepository;
import com.mindia.carmind.defecto.pojo.DefectoView;
import com.mindia.carmind.entities.Defecto;
import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.usuario.persistence.UsuariosRepository;

@Service
public class DefectoManager {

    
    @Autowired
    UsuariosManager usuariosManager;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    DefectoRepository defectoRepository;


    public List<DefectoView> getAllDefectos() {
        int empresaId = usuariosManager.getLoggeduser().getEmpresa();
       
        Iterable<Integer> userIds = usuariosRepository.findByEmpresaAndActiveTrue(empresaId).stream().map(x -> x.getId()).collect(Collectors.toList());

        List<Defecto> defectos = defectoRepository.findAllByIdUsuarioIn(userIds);

        return defectos.stream().map(defecto -> new DefectoView(defecto)).collect(Collectors.toList());
    }


    public void changePriorityOfDefecto(int id, Integer newPriority) {
        Optional<Defecto> defecto = defectoRepository.findById(id);

        if (defecto.isPresent()) {
            defecto.get().setPrioridad(newPriority);
            defectoRepository.save(defecto.get());
        }
    }
    
}
