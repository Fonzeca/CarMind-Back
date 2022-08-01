package com.mindia.carmind.notificacion.manager;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import com.mindia.carmind.empresa.persistence.EmpresaRepository;
import com.mindia.carmind.entities.Documento;
import com.mindia.carmind.entities.Empresa;
import com.mindia.carmind.entities.Notificaciones;
import com.mindia.carmind.entities.Usuario;
import com.mindia.carmind.entities.Vehiculo;
import com.mindia.carmind.notificacion.persistence.NotificacionRepository;
import com.mindia.carmind.notificacion.pojo.NotificacionDocumentacionView;
import com.mindia.carmind.notificacion.pojo.NotificacionFailureEvaluacionView;
import com.mindia.carmind.notificacion.pojo.NotificacionPojo;
import com.mindia.carmind.notificacion.pojo.VencimientoView;
import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.usuario.persistence.UsuariosRepository;
import com.mindia.carmind.utils.Convertions;
import com.mindia.carmind.vehiculo.persistence.DocumentoRepository;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


@Service
public class NotificacionManager {

    private static final Logger log = LoggerFactory.getLogger(NotificacionManager.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(" HH:mm:ss");

    @Autowired
    NotificacionRepository repository;

    @Autowired
    DocumentoRepository documentoRepository;

    @Autowired
    VehiculosRepository vehiculosRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    NotificacionRepository notificacionRepository;

    @Autowired
    UsuariosManager usuariosManager;

    @Value("${fastemail.url}")
    private String fastEmailUrl;


    public List<NotificacionPojo> getAllNotificaciones(){
        List<Notificaciones> notificaciones = notificacionRepository.findTop10ByEmpresaId(usuariosManager.getLoggeduser().getEmpresa());
        return notificaciones.stream().map(NotificacionPojo::new).collect(Collectors.toList());
    }


    @Scheduled(cron = "0 0 0 1/1 * ?")
    @Transactional
    private void dailyTask(){
        int daysInterval = 7;
        log.info("Perform dailyTask, the time is now {}", dateFormat.format(new Date()));

        List<Documento> docs = documentoRepository.findByVencimientoAndActiveTrue(LocalDate.now().plusDays(daysInterval));
        for (Documento documento : docs) {

            Vehiculo vehiculo = documento.getVehiculo();

            Notificaciones notificacion = new Notificaciones();
            notificacion.setEmpresaId(vehiculo.getEmpresaId());
            notificacion.setFechaCreacion(LocalDate.now());
            notificacion.setTitulo("Vencimiento");
            notificacion.setTexto("El documento " + documento.getTipoDocumento() + " del vehiculo " + vehiculo.getNombre() + " vence en " + daysInterval + " dias.");

            notificacionRepository.save(notificacion);
        }

        log.info("Finish dailyTask, the time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 0 9 * * MON")
    @Transactional
    private void everyMondayTask(){
        
        int daysInterval = 14;
        log.info("Perform weeklyTask, the time is now {}", dateFormat.format(new Date()));

        LocalDate dateNow = LocalDate.now();

        List<Empresa> empresas = empresaRepository.findAll();

        if(empresas.isEmpty()) log.info("El repositorio de empresas no encontró ninguna empresa");

        for(Empresa empresa : empresas){
            log.info("------------------------------------------------------------");
            log.info("Realizando acciones sobre la empresa " + empresa.getNombre());

            List<Vehiculo> vehiculos = vehiculosRepository.findByEmpresaId(empresa.getId());
            List<VencimientoView> vencimientos = new ArrayList<VencimientoView>();

            if(vehiculos.isEmpty()) log.info("Esta empresa no tiene ningún vehiculo");

            for(Vehiculo vehiculo : vehiculos){
                log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                log.info("Obteniendo documentos vencidos para el auto con id: " + vehiculo.getId());
                List<Documento> docsVencidos = documentoRepository.findByVehiculoIdAndVencimientoBetweenAndActiveTrue(vehiculo.getId(), dateNow, dateNow.plusDays(daysInterval));
                
                
                IntStream.range(0, docsVencidos.size()).forEach(i ->    
                vencimientos.add(
                    new VencimientoView( 
                        docsVencidos.get(i).getTipoDocumento(), 
                        vehiculo.getNombre(),
                        differenceInDays(dateNow, docsVencidos.get(i).getVencimiento())
                        ))
                        );
                if(docsVencidos.isEmpty()){ 
                    log.info("No se encontraron documentos vencidos");
                }else{
                    log.info("Se encontraron documentos vencidos " + vencimientos.toString());
                }
                log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
            List<Usuario> usuarios = usuariosRepository.findByEmpresa(empresa.getId());
            usuarios = usuarios.stream().filter(o -> o.isAdministrador()).collect(Collectors.toList());
            if(usuarios.isEmpty()) log.info("Esta empresa no tiene usuarios, imposible enviar el email via FastEmail, vuelvas prontos");
            usuarios.stream().forEach(usuario -> {sendEmail(usuario.getUsername(), usuario.getNombre(), vencimientos);});
            log.info("------------------------------------------------------------");
        }
    }
    
    private Integer differenceInDays(LocalDate from, LocalDate to){
        Period period = Period.between(from, to);
        return Math.abs(period.getDays());
    }

    private void sendEmail(String email, String nombre, List<VencimientoView> vencimientos){

        log.info("MandandoEmailMandandoEmailMandandoEmailMandandoEmailMandandoEmailMandandoEmail");
        
        String path = "/sendDocsCloseToExpire";
        final OkHttpClient client = new OkHttpClient();
        
        NotificacionDocumentacionView notificacion = new NotificacionDocumentacionView(email, nombre, vencimientos);
        RequestBody body = RequestBody.create(Convertions.toJson(notificacion),
        MediaType.get("application/json; charset=utf-8"));

        if(vencimientos.isEmpty()) path =  "/sendNoneDocsCloseToExpire";

        Request fastEmailRequest = new Request.Builder().url(fastEmailUrl + path)
        .addHeader("Content-Type", "application/json").post(body).build();
    
        try{
            Response fastEmailResponse = client.newCall(fastEmailRequest).execute();
            log.info("Email envíado con exito a " + nombre + " con email " + email);
            log.info("Repuesta de FastEmail: " + fastEmailResponse.toString());

        } catch (IOException ex) {
            log.info("ocurrió un error");
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }

        log.info("MandandoEmailMandandoEmailMandandoEmailMandandoEmailMandandoEmailMandandoEmail");
    }

    static public void sendEmailNotificationFailure( List<Usuario> usuarios, NotificacionFailureEvaluacionView notificacion, String fastEmailUrl){
        
        String path = "/sendFailureEvaluacion";

        for(Usuario usuario : usuarios){

            //Por cada usuario adminitrador, se setea el email y nombre
            notificacion.setEmail(usuario.getUsername());
            notificacion.setNombre(usuario.getNombre());

            final OkHttpClient client = new OkHttpClient();
            
            RequestBody body = RequestBody.create(Convertions.toJson(notificacion), MediaType.get("application/json; charset=utf-8"));
    
            Request fastEmailRequest = new Request.Builder().url(fastEmailUrl + path)
            .addHeader("Content-Type", "application/json").post(body).build();
        
            try{
                Response fastEmailResponse = client.newCall(fastEmailRequest).execute();
                log.info("Email envíado con exito a " + usuario.getUsername());
                log.info("Repuesta de FastEmail: " + fastEmailResponse.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
            }
        }
    }
}