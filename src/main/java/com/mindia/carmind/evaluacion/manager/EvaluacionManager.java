package com.mindia.carmind.evaluacion.manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import com.mindia.carmind.empresa.manager.EmpresaManager;
import com.mindia.carmind.entities.Evaluacion;
import com.mindia.carmind.entities.LogEvaluacion;
import com.mindia.carmind.entities.LogOption;
import com.mindia.carmind.entities.LogPregunta;
import com.mindia.carmind.entities.Pregunta;
import com.mindia.carmind.entities.PreguntaOpcion;
import com.mindia.carmind.entities.Usuario;
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
import com.mindia.carmind.notificacion.manager.NotificacionManager;
import com.mindia.carmind.notificacion.pojo.NotificacionFailureEvaluacionView;
import com.mindia.carmind.pregunta.manager.PreguntaManager;
import com.mindia.carmind.pregunta.persistence.LogOptionRepository;
import com.mindia.carmind.pregunta.persistence.LogPreguntaRepository;
import com.mindia.carmind.pregunta.persistence.PreguntaOpcionRepository;
import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.usuario.persistence.UsuariosRepository;
import com.mindia.carmind.usuario.pojo.UsuarioView;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    PreguntaOpcionRepository preguntaOpcionRepository;

    @Autowired
    UsuariosManager usuariosManager;

    @Autowired
    EmpresaManager empresaManager;

    @Autowired
    PreguntaManager preguntaManager;

    @Autowired
    LogOptionRepository logOptionRepository;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Value("${fastemail.url}")
    private String fastEmailUrl;


    public Evaluacion getEvaluacionById(String id){
        int intId = Integer.parseInt(id);

        int empresaId = usuariosManager.getLoggeduser().getEmpresa();

        return repository.findByIdAndEmpresaId(intId, empresaId);
    }

    public EvaluacionView getEvaluacionViewById(int id){
        int empresaId = usuariosManager.getLoggeduser().getEmpresa();

        Evaluacion e = repository.findByIdAndEmpresaId(id, empresaId);

        return EvaluacionView.getEvaluacionDetails(e);
    }

    @Transactional
    public void altaEvaluacion(AltaPojo alta){
        
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setNombre(alta.getTitulo());

        int empresaId = usuariosManager.getLoggeduser().getEmpresa();
        evaluacion.setEmpresaId(empresaId);

        evaluacion = repository.save(evaluacion);

        preguntaManager.createPreguntas(evaluacion.getId(), alta.getPreguntas());
    }

    public void deleteEvaluacion(int id){
        
        Evaluacion evaluacion = repository.getById(id);
        repository.delete(evaluacion);
    }

    public List<EvaluacionView> getAllEvaluaciones(){
        int empresaId = usuariosManager.getLoggeduser().getEmpresa();

        List<Evaluacion> evaluaciones = repository.findByEmpresaId(empresaId);

        return evaluaciones.stream().map(EvaluacionView::new).collect(Collectors.toList());
    }

    public List<EvaluacionView> getAllEvaluacionesWithDetails(){
        int empresaId = usuariosManager.getLoggeduser().getEmpresa();

        List<Evaluacion> evaluaciones = repository.findByEmpresaId(empresaId);

        return evaluaciones.stream().map(x -> EvaluacionView.getEvaluacionDetails(x)).collect(Collectors.toList());
    }

    public void changeNameOfEvaluacion(int id, String newName){
        Evaluacion e = repository.getById(id);
        e.setNombre(newName);
        repository.save(e);
    }

    public void modifyEvaluacion(int id, AltaPojo alta){
        Evaluacion e = repository.getById(id);
        UsuarioView logged = usuariosManager.getLoggeduser();

        if(!logged.getEmpresa().equals(e.getEmpresaId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Este formulario no pertenece a su empresa.");
        }

        if(!e.getNombre().equals(alta.getTitulo())){
            e.setNombre(alta.getTitulo());
            repository.save(e);
        }

        preguntaManager.modifyPreguntas(id, alta.getPreguntas());
    }

    /**
     * Funcion sobrecargada
     * @param id
     * @param respuestas
     */
    public void realizarEvaluacion(Integer id, AltaEvaluacionTerminadaPojo respuestas){
        realizarEvaluacion(id, respuestas, null);
    }

    
    @Transactional
    public void realizarEvaluacion(Integer id, AltaEvaluacionTerminadaPojo respuestas, LocalDateTime logFecha){
        //Validamos el pojo
        respuestas.validate();

        int empresaId = usuariosManager.getLoggeduser().getEmpresa();

        //Obtenemos la evaluacion
        Evaluacion evaluacion = repository.findByIdAndEmpresaId(id, empresaId);
        if(evaluacion == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluacion no encontrada.");
        }

        //Obtenemos el usuario
        UsuarioView loggedUser = usuariosManager.getLoggeduser();

        //Obtenemos el vehiculo
        Vehiculo vehiculo = vehiculosRepository.getById(respuestas.getVehiculoId());

        //Obtenemos todas las evaluaciones del vehiculo
        List<Integer> idEvaluacionesVehiculo = vehiculo.getVehiculoevaluacionList().stream().map(x -> x.getEvaluacionId()).collect(Collectors.toList());

        //Nos aseguramos que la evaluacion que se quiere hacer, la tenga el vehiculo
        if(idEvaluacionesVehiculo.contains(evaluacion.getId())){

            List<Integer> idsPreguntasEvaluacion = getIdsPreguntasOfEvaluacion(evaluacion);

            List<Integer> idsPreguntasRespuestas = respuestas.getRespuestas().stream().map(x -> x.getPreguntaId()).collect(Collectors.toList());

            //Nos aseguramos que las preguntas respondidas, sean igual a las preguntas de la evaluacion
            if(!idsPreguntasEvaluacion.retainAll(idsPreguntasRespuestas)){
                //OK

                //LogEvaluacion
                LogEvaluacion log = new LogEvaluacion();
                log.setNombreEvaluacion(evaluacion.getNombre());

                //Para cuando se hace offline
                if(logFecha != null){
                    log.setFecha(logFecha);
                }else{
                    log.setFecha(LocalDateTime.now());
                }

                log.setVehiculoId(vehiculo.getId());
                log.setUsuarioId(loggedUser.getId());

                //Guardamos el log de la evaluacion
                log = logEvaluacionRepository.save(log);

                //Chequea que si hay una respuesta que es crucial y seleccionada como sin tick, se debe mandar un email a los admins indicando la falla
                boolean hasFailure = false;
                
                //Recorremos las respuestas del view
                for (AltaRespuestaPojo res : respuestas.getRespuestas()) {
                    //Obtenemos la pregunta a responder, para validar el tipo
                    PreguntaView pregunta = preguntaManager.getPreguntaById(res.getPreguntaId());
                    
                    //Creamos el log de la pregunta
                    LogPregunta logPregunta = new LogPregunta();

                    logPregunta.setDescripcion(pregunta.getDescripcion());
                    logPregunta.setCrucial(pregunta.getCrucial());
                    logPregunta.setTipo(pregunta.getTipo());
                    logPregunta.setLogEvaluacion(log.getId());

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
                                    PreguntaOpcion opcion = preguntaOpcionRepository.getById(optRes.getOpcionId());

                                    LogOption log_opt = new LogOption();
                                    log_opt.setTickCheck(optRes.getTickCorrecto());

                                    if(pregunta.getTipo().equals("S1") && opcion.isCrucial() && !optRes.getTickCorrecto()){

                                        //se setea en true porque se debe mandar email ya que la respuesta es errónea y crucial
                                        hasFailure = true;

                                        //Se avisa que esta para revisar
                                        if(!log.isParaRevisar()){
                                            setEvaluacionParaRevisar(log, vehiculo);
                                        }
                                    }

                                    log_opt.setIdLogPregunta(logPregunta.getId());
                                    log_opt.setDescripcion(opcion.getOpcion());
                                    log_opt.setCrucial(opcion.isCrucial());

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

                                //Se avisa que esta para revisar
                                if(pregunta.getCrucial()){
                                    
                                     //se setea en true porque se debe mandar email ya que la respuesta es errónea y crucial
                                    hasFailure = true;
                                    if(!log.isParaRevisar()){
                                        setEvaluacionParaRevisar(log, vehiculo);
                                    }
                                }

                                logPregunta.setNota(res.getTexto());
                            }
                            break;
                        case "TX":
                            logPregunta.setNota(res.getTexto());
                            break;
                        case "KM":
                            logPregunta.setNota(res.getTexto());
                            vehiculo.setKilometraje(Integer.parseInt(res.getTexto()));
                            vehiculosRepository.save(vehiculo);
                            break;
                    }
                    //Al final de todo guardamos el log (A no ser que ya lo hayamos gaurdado para obtener su id antes.)
                    //if(logPregunta.getId() == null){    así estaba antes
                    if(logPregunta == null) logPregunta = logPreguntaRepository.save(logPregunta);
                }

                //Si el vehiculo tiene alguna falla (pregunta marcada como incorrecta y crucial) en la evaluación, entonces mandamos el mail via FastEmail
                if (hasFailure) {
                    hasFailure = false; 
                    //Se buscan todos los adminsitradores de la empresa de la persona que está realizando la evaluación
                    List<Usuario> usuarios = usuariosRepository.findByEmpresaAndAdministradorTrueAndActiveTrue(empresaId);
                    //Obtenemos la fecha actual en el formato necestiado
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String currentDateTime = LocalDateTime.now().format(formatter);
                     //Se setean todas las propiedades que le llegan a FastEmail
                    NotificacionFailureEvaluacionView notificacion = new NotificacionFailureEvaluacionView(
                        loggedUser.getNombre(), 
                        loggedUser.getApellido(), 
                        vehiculo.getNombre(), 
                        log.getId(), 
                        vehiculo.getId(),
                        currentDateTime
                    );
                    NotificacionManager.sendEmailNotificationFailure(usuarios, notificacion, fastEmailUrl);
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
        int empresaId = usuariosManager.getLoggeduser().getEmpresa();

        List<Integer> vehiculosIds = vehiculosRepository.findIdsByEmpresaId(empresaId);

        List<LogEvaluacion> logs = logEvaluacionRepository.findByVehiculoIdInOrderByFechaDesc(vehiculosIds);
        
        return logs.stream().map(LogEvaluacionView::new).collect(Collectors.toList());
    }

    public List<LogEvaluacionView> historialDeEvaluacionesByLoggedUser(int limit){
        //Obtenemos el usuario
        UsuarioView loggedUser = usuariosManager.getLoggeduser();

        List<LogEvaluacion> logs = logEvaluacionRepository.getAllByUserIdFechaDesc(loggedUser.getId(),limit);

        return logs.stream().map(LogEvaluacionView::new).collect(Collectors.toList());
    }

    public LogEvaluacionDetailsView getLogById(int id){
        LogEvaluacion log = logEvaluacionRepository.getById(id);
        return new LogEvaluacionDetailsView(log);
    }

    //---------------------------------------PRIVATE-----------------------------------------------------

    private List<Integer> getIdsPreguntasOfEvaluacion(Evaluacion e){
        List<Pregunta> preguntasDb = e.getPreguntaList();
        return preguntasDb.stream().map(x -> x.getId()).collect(Collectors.toList());
    }

    private void setEvaluacionParaRevisar(LogEvaluacion log, Vehiculo vehiculo){
        log.setParaRevisar(true);
        vehiculo.setAveriado(true);
        
        vehiculosRepository.save(vehiculo);
        logEvaluacionRepository.save(log);
    }

}
