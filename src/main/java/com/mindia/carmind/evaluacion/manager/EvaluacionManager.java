package com.mindia.carmind.evaluacion.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mindia.carmind.entities.Evaluacion;
import com.mindia.carmind.entities.EvaluacionPregunta;
import com.mindia.carmind.entities.Pregunta;
import com.mindia.carmind.entities.Seccion;
import com.mindia.carmind.evaluacion.persistence.EvaluacionPreguntaRepository;
import com.mindia.carmind.evaluacion.persistence.EvaluacionRepository;
import com.mindia.carmind.evaluacion.pojo.AltaEvaluacionPojo;
import com.mindia.carmind.evaluacion.pojo.EvaluacionView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EvaluacionManager {
    @Autowired
    EvaluacionRepository repository;

    @Autowired
    EvaluacionPreguntaRepository evaluacionPreguntaRepository;

    public Evaluacion getEvaluacionById(String id){
        int intId = Integer.parseInt(id);

        return repository.getById(intId);
    }

    public EvaluacionView getEvaluacionViewById(int id){
        Evaluacion e = repository.getById(id);
        
        List<Pregunta> preguntas = e.getListOfEvaluacionPregunta().stream().map(x -> x.getPregunta2()).collect(Collectors.toList());
        
        List<Seccion> secciones = preguntas.stream().map(x -> x.getSeccion2()).distinct().collect(Collectors.toList());
        
        EvaluacionView evaluacion = new EvaluacionView(e, preguntas, secciones);

        return evaluacion;
    }

    @Transactional
    public void altaEvaluacion(AltaEvaluacionPojo alta){
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setNombre(alta.getNombre());

        evaluacion = repository.save(evaluacion);

        List<EvaluacionPregunta> lstPreguntas = new ArrayList<EvaluacionPregunta>();
        
        for (Integer idPregunta : alta.getIdsPreguntas()) {
            EvaluacionPregunta manyToMany = new EvaluacionPregunta();
            manyToMany.setEvaluacion(evaluacion.getId());
            manyToMany.setPregunta(idPregunta);
            lstPreguntas.add(manyToMany);
        }

        evaluacionPreguntaRepository.saveAll(lstPreguntas);
    }

    public List<EvaluacionView> getAllEvaluaciones(){
        List<Evaluacion> evaluaciones = repository.findAll();

        return evaluaciones.stream().map(EvaluacionView::new).collect(Collectors.toList());
    }

    public void changeNameOfEvaluacion(int id, String newName){
        Evaluacion e = repository.getById(id);
        e.setNombre(newName);
        repository.save(e);
    }

    public void changePreguntasOfEvaluacion(int id, AltaEvaluacionPojo alta) {
        Evaluacion evaluacion = repository.getById(id);
        
        List<EvaluacionPregunta> preguntasViejas = evaluacion.getListOfEvaluacionPregunta();

        List<Integer> preguntasNuevas = alta.getIdsPreguntas();

        for (EvaluacionPregunta pregunta : preguntasViejas) {

            if(!preguntasNuevas.contains(pregunta.getPregunta())){
                evaluacionPreguntaRepository.delete(pregunta);
            }else{
                preguntasNuevas.remove(pregunta.getPregunta());
            }
        }

        for (Integer idPregunta : preguntasNuevas) {
            EvaluacionPregunta manyToMany = new EvaluacionPregunta();
            manyToMany.setEvaluacion(evaluacion.getId());
            manyToMany.setPregunta(idPregunta);

            evaluacionPreguntaRepository.save(manyToMany);
        }
    }

}
