package com.mindia.carmind.pregunta.manager;

import java.util.List;
import java.util.stream.Collectors;

import com.mindia.carmind.entities.Pregunta;
import com.mindia.carmind.entities.PreguntaOpcion;
import com.mindia.carmind.evaluacion.pojo.AltaPreguntaPojo;
import com.mindia.carmind.pregunta.persistence.PreguntaOpcionRepository;
import com.mindia.carmind.pregunta.persistence.PreguntaRepository;
import com.mindia.carmind.pregunta.pojo.PreguntaView;
import com.mindia.carmind.seccion.manager.SeccionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PreguntaManager {
    @Autowired
    PreguntaRepository repository;

    @Autowired
    SeccionManager seccionManager;

    @Autowired
    PreguntaOpcionRepository preguntaOpcionRepository;

    // public void createPregunta(AltaPreguntaPojo alta){
    //     alta.validate();

    //     Pregunta pregunta = new Pregunta();

    //     pregunta.setActivo(true);
    //     pregunta.setDescripcion(alta.getDescripcion());

    //     //Buscamos la seccion, y si no exite o esta desactivado, la misma funcion larga la exception
    //     seccionManager.getSeccionActivaById(alta.getSeccionId() + "");
        
    //     pregunta.setSeccion(alta.getSeccionId());

    //     repository.save(pregunta);
    // }
    
    @Transactional
    public void createPreguntas( int seccionId, List<AltaPreguntaPojo> altaPreguntaPojo){
        for (AltaPreguntaPojo alta : altaPreguntaPojo) {
            
            Pregunta pregunta = new Pregunta();
            pregunta.setActivo(true);
            pregunta.setDescripcion(alta.getDescripcion());
            pregunta.setIndexOrden(alta.getIndex());
            pregunta.setSeccion(seccionId);
            pregunta.setTipo(alta.getTipo());

            pregunta = repository.save(pregunta);
            if(alta.getOpciones() != null){
                for (String opcion : alta.getOpciones()) {
                    PreguntaOpcion opcionDb = new PreguntaOpcion();
                    opcionDb.setOpcion(opcion);
                    opcionDb.setIdPregunta(pregunta.getId());
    
                    preguntaOpcionRepository.save(opcionDb);
                }
            }
        }
    }

    public List<PreguntaView> getAllActivos(){
        return repository.findByActivoTrue().stream().map(PreguntaView::new).collect(Collectors.toList());
    }

    public void desactivatePregunta(String id){
        int intId = Integer.parseInt(id);

        Pregunta pregunta = repository.findByIdAndActivoTrue(intId);

        if(pregunta == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pregunta no encontrada");
        }

        pregunta.setActivo(false);

        repository.save(pregunta);
    }

}
