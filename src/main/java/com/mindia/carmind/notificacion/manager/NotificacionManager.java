package com.mindia.carmind.notificacion.manager;


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
import com.mindia.carmind.notificacion.pojo.ZoneNotification;
import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.usuario.persistence.UsuariosRepository;
import com.mindia.carmind.vehiculo.persistence.DocumentoRepository;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


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

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${fastemail.url}")
    public String fastEmailUrl;


    public List<NotificacionPojo> getAllNotificaciones(){
        List<Notificaciones> notificaciones = notificacionRepository.findTop10ByEmpresaId(usuariosManager.getLoggeduser().getEmpresa());
        return notificaciones.stream().map(NotificacionPojo::new).collect(Collectors.toList());
    }

    public void sendEmailNotificationFailure( List<Usuario> usuarios, NotificacionFailureEvaluacionView notificacion, String fastEmailUrl){
        for(Usuario usuario : usuarios){

            //Por cada usuario adminitrador, se setea el email y nombre
            notificacion.setEmail(usuario.getUsername());
            notificacion.setNombre(usuario.getNombre());

            rabbitTemplate.convertAndSend("carmind", "notification.failure.ready", notificacion);
        }
    }

    public void prepareZoneNotification(ZoneNotification notification){
        var vehiculos = vehiculosRepository.findByImei(notification.getImei());
        if(vehiculos == null || vehiculos.isEmpty()){
            return;
        }
        var vehiculo = vehiculos.get(0);

        var empresaId = vehiculo.getEmpresaId();

        var usuarios = usuariosManager.getAllUsuario(empresaId);
        var usuariosAdmin = usuarios.stream().filter(o -> o.getAdministrador()).collect(Collectors.toList());
        var emailsAdmin = usuariosAdmin.stream().map(o -> o.getUsername()).collect(Collectors.toList());

        notification.setVehiculoId(vehiculo.getId());
        notification.setVehiculoName(vehiculo.getNombre());
        notification.setEmails(emailsAdmin);

        rabbitTemplate.convertAndSend("carmind", "notification.zone.userhub.preparing", notification);
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
            List<Usuario> usuarios = usuariosRepository.findByEmpresaAndActiveTrue(empresa.getId());
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
        NotificacionDocumentacionView notificacion = new NotificacionDocumentacionView(email, nombre, vencimientos);
        rabbitTemplate.convertAndSend("carmind", "notification.weekly.email.ready", notificacion);
    }
}