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
import com.mindia.carmind.notificacion.pojo.NotificacionPojo;
import com.mindia.carmind.notificacion.pojo.VencimientoView;
import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.usuario.persistence.UsuariosRepository;
import com.mindia.carmind.utils.Convertions;
import com.mindia.carmind.vehiculo.persistence.DocumentoRepository;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class NotificacionManager {

    private Environment env;

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

    @Scheduled(cron = "0 0 0 * * MON")
    @Transactional
    private void everyMondayTask(){
        
        int daysInterval = 14;
        log.info("Perform weeklyTask, the time is now {}", dateFormat.format(new Date()));

        LocalDate dateNow = LocalDate.now();

        List<Empresa> empresas = empresaRepository.findAll();

        for(Empresa empresa : empresas){

            List<Vehiculo> vehiculos = vehiculosRepository.findByEmpresaId(empresa.getId());
            List<VencimientoView> vencimientos = new ArrayList<VencimientoView>();

            for(Vehiculo vehiculo : vehiculos){
                List<Documento> docsVencidos = documentoRepository.findByVehiculoIdAndVencimientoBetweenAndActiveTrue(vehiculo.getId(), dateNow, dateNow.plusDays(daysInterval));
                IntStream.range(0, docsVencidos.size()).forEach(i ->    
                    vencimientos.add(
                        new VencimientoView( 
                        docsVencidos.get(i).getTipoDocumento(), 
                        vehiculo.getNombre(),
                        differenceInDays(dateNow, docsVencidos.get(i).getVencimiento())
                    ))
                );
            }
            List<Usuario> usuarios = usuariosRepository.findByEmpresaAndActiveTrue(empresa.getId());
            usuarios.stream().forEach(usuario -> {sendEmail(usuario.getUsername(), usuario.getNombre(), vencimientos);});
        }
    }
    
    private Integer differenceInDays(LocalDate from, LocalDate to){
        Period period = Period.between(from, to);
        return Math.abs(period.getDays());
    }

    private void sendEmail(String email, String nombre, List<VencimientoView> vencimientos){
        
        String url = env.getProperty("fastemail.url");
        String path = "/sendDocsCloseToExpire";
        final OkHttpClient client = new OkHttpClient();
        
        NotificacionDocumentacionView notificacion = new NotificacionDocumentacionView(email, nombre, vencimientos);
        RequestBody body = RequestBody.create(Convertions.toJson(notificacion),
        MediaType.get("application/json; charset=utf-8"));

        if(vencimientos.isEmpty()) path =  "/sendNoneDocsCloseToExpire";

        Request fastEmailRequest = new Request.Builder().url(url + path)
        .addHeader("Content-Type", "application/json").post(body).build();
    
        try (Response fastEmailResponse = client.newCall(fastEmailRequest).execute()) {
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        } 
    }
}