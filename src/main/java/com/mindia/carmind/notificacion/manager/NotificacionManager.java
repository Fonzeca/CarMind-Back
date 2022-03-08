package com.mindia.carmind.notificacion.manager;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.mindia.carmind.entities.Documento;
import com.mindia.carmind.entities.Notificaciones;
import com.mindia.carmind.entities.Vehiculo;
import com.mindia.carmind.notificacion.persistence.NotificacionRepository;
import com.mindia.carmind.notificacion.pojo.NotificacionPojo;
import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.vehiculo.persistence.DocumentoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    NotificacionRepository notificacionRepository;

    @Autowired
    UsuariosManager usuariosManager;

    public List<NotificacionPojo> getAllNotificaciones(){
        List<Notificaciones> notificaciones = notificacionRepository.findByEmpresaId(usuariosManager.getLoggeduser().getEmpresa());
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

    private void weeklyTask(){
        log.info("Perform weeklyTask, the time is now {}", dateFormat.format(new Date()));

        List<Documento> docs = documentoRepository.findByVencimientoBetweenAndActiveTrue(LocalDate.now(), LocalDate.now().plusDays(14));

        for (Documento documento : docs) {
            log.info(documento.getVehiculoId() + " " + documento.getTipoDocumento());   
        }


        log.info("Finish weeklyTask, the time is now {}", dateFormat.format(new Date()));
    }
}
