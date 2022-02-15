package com.mindia.carmind.seccion.manager;

import java.util.List;

import com.mindia.carmind.entities.Seccion;
import com.mindia.carmind.evaluacion.pojo.AltaSeccionPojo;
import com.mindia.carmind.pregunta.manager.PreguntaManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SeccionManager {
    @Autowired
    com.mindia.carmind.seccion.persistence.SeccionRepository repository;

    @Autowired
    PreguntaManager preguntaManager;

    // public void createSeccion(AltaSeccionPojo alta){
    //     alta.validate();

    //     Seccion seccion = new Seccion();

    //     seccion.setDescripcion(alta.getDescripcion());
    //     seccion.setNombre(alta.getNombre());
    //     seccion.setActivo(true);

    //     repository.save(seccion);
    // }

    public void createSeccion(int evaluacionId, List<AltaSeccionPojo> altaSeccionPojo){
        for (AltaSeccionPojo alta : altaSeccionPojo) {
            Seccion seccion = new Seccion();
            seccion.setActivo(true);
            seccion.setNombre(alta.getNombre());
            seccion.setEvaluacionId(evaluacionId);
    
            seccion = repository.save(seccion);
    
            preguntaManager.createPreguntas(seccion.getId(), alta.getPreguntas());
        }
    }

    public void desactivateSeccion(String id){
        int intId = Integer.parseInt(id);

        Seccion seccion = repository.findByIdAndActivoTrue(intId);
        if(seccion == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seccion no encontrada");
        }
        seccion.setActivo(false);

        repository.save(seccion);
    }

    // public List<SeccionView> getAll(){
    //     return repository.findByActivoTrue().stream().map(SeccionView::new).collect(Collectors.toList());
    // }

    public Seccion getSeccionActivaById(String id){
        int intId = Integer.parseInt(id);

        Seccion seccion = repository.findByIdAndActivoTrue(intId);
        if(seccion == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seccion no encontrada");
        }
        return seccion;
    }


}
