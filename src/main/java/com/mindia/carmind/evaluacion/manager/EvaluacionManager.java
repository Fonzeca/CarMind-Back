package com.mindia.carmind.evaluacion.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import com.mindia.carmind.empresa.manager.EmpresaManager;
import com.mindia.carmind.entities.Evaluacion;
import com.mindia.carmind.entities.LogEvaluacion;
import com.mindia.carmind.entities.LogOption;
import com.mindia.carmind.entities.LogPregunta;
import com.mindia.carmind.entities.Pregunta;
import com.mindia.carmind.entities.Vehiculo;
import com.mindia.carmind.evaluacion.persistence.EvaluacionRepository;
import com.mindia.carmind.evaluacion.persistence.LogEvaluacionRepository;
import com.mindia.carmind.evaluacion.pojo.LogEvaluacionView;
import com.mindia.carmind.evaluacion.pojo.alta.AltaPojo;
import com.mindia.carmind.evaluacion.pojo.log_details.LogEvaluacionDetailsView;
import com.mindia.carmind.evaluacion.pojo.respuesta.AltaEvaluacionTerminadaPojo;
import com.mindia.carmind.evaluacion.pojo.respuesta.AltaRespuestaPojo;
import com.mindia.carmind.evaluacion.pojo.respuesta.RespuestaOpcionPojo;
import com.mindia.carmind.evaluacion.pojo.view.EvaluacionView;
import com.mindia.carmind.evaluacion.pojo.view.PreguntaView;
import com.mindia.carmind.pregunta.manager.PreguntaManager;
import com.mindia.carmind.pregunta.persistence.LogOptionRepository;
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

    @Autowired
    EmpresaManager empresaManager;

    @Autowired
    PreguntaManager preguntaManager;

    @Autowired
    LogOptionRepository logOptionRepository;

    public Evaluacion getEvaluacionById(String id){
        int intId = Integer.parseInt(id);

        return repository.getById(intId);
    }

    public EvaluacionView getEvaluacionViewById(int id){
        Evaluacion e = repository.getById(id);

        return EvaluacionView.getEvaluacionDetails(e);
    }

    @Transactional
    public void altaEvaluacion(AltaPojo alta){
        
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setNombre(alta.getTitulo());

        evaluacion = repository.save(evaluacion);

        seccionManager.createSeccion(evaluacion.getId(), alta.getSecciones());
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

    // public void changePreguntasOfEvaluacion(int id, AltaEvaluacionPojo alta) {
    //     // Evaluacion evaluacion = repository.getById(id);
        
    //     // List<EvaluacionPregunta> preguntasViejas = evaluacion.getListOfEvaluacionPregunta();

    //     // List<Integer> preguntasNuevas = alta.getIdsPreguntas();

    //     // for (EvaluacionPregunta pregunta : preguntasViejas) {

    //     //     if(!preguntasNuevas.contains(pregunta.getPregunta())){
    //     //         evaluacionPreguntaRepository.delete(pregunta);
    //     //     }else{
    //     //         preguntasNuevas.remove(pregunta.getPregunta());
    //     //     }
    //     // }

    //     // for (Integer idPregunta : preguntasNuevas) {
    //     //     EvaluacionPregunta manyToMany = new EvaluacionPregunta();
    //     //     manyToMany.setEvaluacion(evaluacion.getId());
    //     //     manyToMany.setPregunta(idPregunta);

    //     //     evaluacionPreguntaRepository.save(manyToMany);
    //     // }
    // }

    @Transactional
    public void realizarEvaluacion(int id, AltaEvaluacionTerminadaPojo respuestas){
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

            List<Integer> idsPreguntasEvaluacion = getIdsPreguntasOfEvaluacion(evaluacion);

            List<Integer> idsPreguntasRespuestas = respuestas.getRespuestas().stream().map(x -> x.getPreguntaId()).collect(Collectors.toList());

            //Nos aseguramos que las preguntas respondidas, sean igual a las preguntas de la evaluacion
            if(!idsPreguntasEvaluacion.retainAll(idsPreguntasRespuestas)){
                //OK

                //LogEvaluacion
                LogEvaluacion log = new LogEvaluacion();
                log.setEvaluacionId(id);
                log.setFecha(LocalDateTime.now());
                log.setVehiculoId(vehiculo.getId());
                log.setUsuarioId(loggedUser.getId());

                //Guardamos el log de la evaluacion
                log = logEvaluacionRepository.save(log);
                
                //Recorremos las respuestas del view
                for (AltaRespuestaPojo res : respuestas.getRespuestas()) {
                    //Creamos el log de la pregunta
                    LogPregunta logPregunta = new LogPregunta();
                    logPregunta.setIdPregunta(res.getPreguntaId());
                    logPregunta.setLogEvaluacion(log.getId());

                    //Obtenemos la pregunta a responder, para validar el tipo
                    PreguntaView pregunta = preguntaManager.getPreguntaById(res.getPreguntaId());

                    //depende del tipo de pregunta, cambia su comportamiento
                    switch(pregunta.getTipo()){
                        case "F":
                            //Si es foto, nos fijamos si esta en el json
                            if(res.getBase64Image() != null){
                                byte[] decodedImage = Base64.getDecoder().decode(res.getBase64Image());
                                logPregunta.setImage(decodedImage);
                            }else{
                                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "En una respuesta del tipo Foto, no se le encuentra la foto adjunta.");
                            }
                            break;
                        case "S1":
                        case "S2":
                            if(res.getOpciones() != null && res.getOpciones().size() > 0){
                                logPregunta.setNota(res.getTexto());
                                
                                //Guardamos antes el log, para que tengamos un id.
                                logPregunta = logPreguntaRepository.save(logPregunta);
                                for (RespuestaOpcionPojo optRes : res.getOpciones()) {
                                    LogOption log_opt = new LogOption();
                                    log_opt.setTickCheck(optRes.getTickCorrecto());
                                    log_opt.setIdOption(optRes.getOpcionId());
                                    log_opt.setIdLogPregunta(logPregunta.getId());

                                    //TODO: validar las ids  .constraint fails (`carmind`.`log_option`, CONSTRAINT `option_log_option` FOREIGN KEY (`id_option`) REFERENCES `pregunta_opcion` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT)
                                    logOptionRepository.save(log_opt);
                                }
                            }else{
                                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "En una respuesta del tipo con opciones, no se le encuentra las opciones.");
                            }
                            break;
                        case "S3":
                            logPregunta.setTickCorrecto(res.getTickCorrecto());
                            if(!res.getTickCorrecto()){
                                logPregunta.setNota(res.getTexto());
                            }
                            break;
                        case "TX":
                            logPregunta.setNota(res.getTexto());
                            break;
                    }
                    //Al final de todo guardamos el log (A no ser que ya lo hayamos gaurdado para obtener su id antes.)
                    if(logPregunta.getId() == null){
                        logPregunta = logPreguntaRepository.save(logPregunta);
                    }
                }
                
                return;
            }else{
                //Error
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Las preguntas respondidas no concuerdan con la evaluacion.");
            }

        }else{
            //Error
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La evaluacion a realizar, no la tiene asignada el vehiculo seleccionado.");
        }

    }

    public List<LogEvaluacionView> historialDeEvaluaciones(){
        List<LogEvaluacion> logs = logEvaluacionRepository.getAllFechaDesc();
        return logs.stream().map(LogEvaluacionView::new).collect(Collectors.toList());
    }

    public List<LogEvaluacionView> historialDeEvaluacionesByLoggedUser(){
        //Obtenemos el usuario
        UsuarioView loggedUser = usuariosManager.getLoggeduser();

        List<LogEvaluacion> logs = logEvaluacionRepository.getAllByUserIdFechaDesc(loggedUser.getId());

        return logs.stream().map(LogEvaluacionView::new).collect(Collectors.toList());
    }

    public LogEvaluacionDetailsView getLogById(int id){
        LogEvaluacion log = logEvaluacionRepository.getById(id);
        return new LogEvaluacionDetailsView(log);
    }


    public void setFalseRevisarLogEvaluacion(Integer vehiculoId, Integer revisionId){
        var logs = logEvaluacionRepository.findByVehiculoIdAndParaRevisarTrue(vehiculoId);
        for(LogEvaluacion log : logs){
            log.setParaRevisar(false);
            log.setRevisionId(revisionId);
            logEvaluacionRepository.save(log);
        }
    }

    //---------------------------------------PRIVATE-----------------------------------------------------

    private List<Integer> getIdsPreguntasOfEvaluacion(Evaluacion e){
        List<Pregunta> preguntasDb = new ArrayList<Pregunta>();

        e.getListOfSeccion().stream().forEach(x -> {
            preguntasDb.addAll(x.getListOfPregunta());
        });

        return preguntasDb.stream().map(x -> x.getId()).collect(Collectors.toList());
    }

}
