package com.mindia.carmind.pregunta.manager;

import java.util.List;
import java.util.stream.Collectors;

import com.mindia.carmind.entities.Pregunta;
import com.mindia.carmind.pregunta.persistence.PreguntaRepository;
import com.mindia.carmind.pregunta.pojo.AltaPreguntaPojo;
import com.mindia.carmind.pregunta.pojo.PreguntaView;
import com.mindia.carmind.seccion.manager.SeccionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PreguntaManager {
    @Autowired
    PreguntaRepository repository;

    @Autowired
    SeccionManager seccionManager;

    public void createPregunta(AltaPreguntaPojo alta){
        alta.validate();

        Pregunta pregunta = new Pregunta();

        pregunta.setActivo(true);
        pregunta.setDescripcion(alta.getDescripcion());

        //Buscamos la seccion, y si no exite o esta desactivado, la misma funcion larga la exception
        seccionManager.getSeccionActivaById(alta.getSeccionId() + "");
        
        pregunta.setSeccion(alta.getSeccionId());

        repository.save(pregunta);
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