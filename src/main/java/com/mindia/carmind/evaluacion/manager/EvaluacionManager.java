package com.mindia.carmind.evaluacion.manager;

import java.util.List;
import java.util.stream.Collectors;

import com.mindia.carmind.entities.Evaluacion;
import com.mindia.carmind.entities.Vehiculo;
import com.mindia.carmind.evaluacion.persistence.EvaluacionRepository;
import com.mindia.carmind.evaluacion.persistence.LogEvaluacionRepository;
import com.mindia.carmind.evaluacion.pojo.AltaEvaluacionPojo;
import com.mindia.carmind.evaluacion.pojo.AltaPojo;
import com.mindia.carmind.evaluacion.pojo.EvaluacionView;
import com.mindia.carmind.evaluacion.pojo.RealizarEvaluacionPojo;
import com.mindia.carmind.pregunta.persistence.LogPreguntaRepository;
import com.mindia.carmind.seccion.manager.SeccionManager;
import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.usuario.pojo.UsuarioView;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EvaluacionManager {
    @Autowired
    EvaluacionRepository repository;

    @Autowired
    VehiculosRepository vehiculosRepository;

    @Autowired
    LogEvaluacionRepository logEvaluacionRepository;

    @Autowired
    LogPreguntaRepository logPreguntaRepository;

    @Autowired
    UsuariosManager usuariosManager;

    @Autowired
    SeccionManager seccionManager;

    public Evaluacion getEvaluacionById(String id){
        int intId = Integer.parseInt(id);

        return repository.getById(intId);
    }

    public EvaluacionView getEvaluacionViewById(int id){
        // Evaluacion e = repository.getById(id);
        
        // List<Pregunta> preguntas = e.getListOfEvaluacionPregunta().stream().map(x -> x.getPregunta2()).collect(Collectors.toList());
        
        // List<Seccion> secciones = preguntas.stream().map(x -> x.getSeccion2()).distinct().collect(Collectors.toList());
        
        // EvaluacionView evaluacion = new EvaluacionView(e, preguntas, secciones);

        // return evaluacion;
        return null;
    }

    @Transactional
    public void altaEvaluacion(AltaPojo alta){
        
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setNombre(alta.getTitulo());

        evaluacion = repository.save(evaluacion);

        seccionManager.createSeccion(evaluacion.getId(), alta.getSecciones());

        
        // Evaluacion evaluacion = new Evaluacion();
        // evaluacion.setNombre(alta.getNombre());

        // evaluacion = repository.save(evaluacion);

        // List<EvaluacionPregunta> lstPreguntas = new ArrayList<EvaluacionPregunta>();
        
        // for (Integer idPregunta : alta.getIdsPreguntas()) {
        //     EvaluacionPregunta manyToMany = new EvaluacionPregunta();
        //     manyToMany.setEvaluacion(evaluacion.getId());
        //     manyToMany.setPregunta(idPregunta);
        //     lstPreguntas.add(manyToMany);
        // }

        // evaluacionPreguntaRepository.saveAll(lstPreguntas);
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
        // Evaluacion evaluacion = repository.getById(id);
        
        // List<EvaluacionPregunta> preguntasViejas = evaluacion.getListOfEvaluacionPregunta();

        // List<Integer> preguntasNuevas = alta.getIdsPreguntas();

        // for (EvaluacionPregunta pregunta : preguntasViejas) {

        //     if(!preguntasNuevas.contains(pregunta.getPregunta())){
        //         evaluacionPreguntaRepository.delete(pregunta);
        //     }else{
        //         preguntasNuevas.remove(pregunta.getPregunta());
        //     }
        // }

        // for (Integer idPregunta : preguntasNuevas) {
        //     EvaluacionPregunta manyToMany = new EvaluacionPregunta();
        //     manyToMany.setEvaluacion(evaluacion.getId());
        //     manyToMany.setPregunta(idPregunta);

        //     evaluacionPreguntaRepository.save(manyToMany);
        // }
    }

    @Transactional
    public void realizarEvaluacion(int id, RealizarEvaluacionPojo respuestas){
        //Validamos el pojo
        respuestas.validate();

        //Obtenemos la evaluacion
        Evaluacion evaluacion = repository.getById(id);

        //Obtenemos el usuario
        UsuarioView loggedUser = usuariosManager.getLoggeduser();

        //Obtenemos el vehiculo
        Vehiculo vehiculo = vehiculosRepository.getById(respuestas.getVehiculoId());

        //Obtenemos todas las evaluaciones del vehiculo
        List<Integer> idEvaluacionesVehiculo = vehiculo.getListOfVehiculoEvaluacion().stream().map(x -> x.getEvaluacionId()).collect(Collectors.toList());

        //Nos aseguramos que la evaluacion que se quiere hacer, la tenga el vehiculo
        if(idEvaluacionesVehiculo.contains(evaluacion.getId())){

            //Nos aseguramos que la cantidad de respuestas, sea la misma cantidad de preguntas
            // if(evaluacion.getListOfEvaluacionPregunta().size() == respuestas.getRespuestas().size()){

            //     List<Integer> idsPreguntasEvaluacion = evaluacion.getListOfEvaluacionPregunta().stream().map(x -> x.getPregunta()).collect(Collectors.toList());

            //     List<Integer> idsPreguntasRespuestas = respuestas.getRespuestas().stream().map(x -> x.getPreguntaId()).collect(Collectors.toList());

            //     //Nos aseguramos que las preguntas respondidas, sean igual a las preguntas de la evaluacion
            //     if(!idsPreguntasEvaluacion.retainAll(idsPreguntasRespuestas)){
            //         //OK
                    
            //         LogEvaluacion log = new LogEvaluacion();
            //         log.setEvaluacionId(id);
            //         log.setFecha(LocalDate.now());
            //         log.setVehiculoId(vehiculo.getId());
            //         log.setObservaciones(respuestas.getObservaciones());
            //         log.setUsuarioId(loggedUser.getId());

            //         logEvaluacionRepository.save(log);
                    
            //         List<LogPregunta> logsPreguntas = new ArrayList<LogPregunta>();
            //         for (RespuestaPojo res : respuestas.getRespuestas()) {
            //             logsPreguntas.add(res.parseToLogPregunta(log.getId()));
            //         }

            //         logPreguntaRepository.saveAll(logsPreguntas);
                    
            //         return;
            //     }else{
            //         //Error
            //         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Las preguntas respondidas no concuerdan con la evaluacion.");
            //     }

            // }else{
            //     //Error
            //     throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La cantidad de preguntas respondidas no concuerdan con la evaluacion.");
            // }

        }else{
            //Error
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La evaluacion a realizar, no la tiene asignada el vehiculo seleccionado.");
        }

    }

}
