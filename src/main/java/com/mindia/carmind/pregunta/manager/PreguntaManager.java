package com.mindia.carmind.pregunta.manager;

import java.util.List;

import com.mindia.carmind.entities.Pregunta;
import com.mindia.carmind.entities.PreguntaOpcion;
import com.mindia.carmind.evaluacion.pojo.alta.AltaOpcionPojo;
import com.mindia.carmind.evaluacion.pojo.alta.AltaPreguntaPojo;
import com.mindia.carmind.evaluacion.pojo.view.PreguntaView;
import com.mindia.carmind.pregunta.persistence.PreguntaOpcionRepository;
import com.mindia.carmind.pregunta.persistence.PreguntaRepository;

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
    PreguntaOpcionRepository preguntaOpcionRepository;

    @Transactional
    public void createPreguntas( int evaluacionId, List<AltaPreguntaPojo> altaPreguntaPojo){
        if(altaPreguntaPojo == null || altaPreguntaPojo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay preguntas.");
        }
        for (AltaPreguntaPojo alta : altaPreguntaPojo) {
            Pregunta pregunta = new Pregunta();

            pregunta.setEvaluacionId(evaluacionId);
            pregunta.setDescripcion(alta.getDescripcion());
            pregunta.setTipo(alta.getTipo());
            pregunta.setCrucial(alta.getCrucial() != null ? alta.getCrucial() : false);

            pregunta = repository.save(pregunta);
            if(alta.getOpciones() != null){
                for (AltaOpcionPojo opcion : alta.getOpciones()) {
                    PreguntaOpcion opcionDb = new PreguntaOpcion();
                    opcionDb.setOpcion(opcion.getOpcion());
                    opcionDb.setCrucial(opcion.getCrucial() != null ? opcion.getCrucial() : false);
                    opcionDb.setIdPregunta(pregunta.getId());
    
                    preguntaOpcionRepository.save(opcionDb);
                }
            }
        }
    }

    public PreguntaView getPreguntaById(Integer id){
        return new PreguntaView(repository.getById(id));
    }

}
