package com.mindia.carmind.notificacion.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.mindia.carmind.entities.Usuario;
import com.mindia.carmind.notificacion.manager.NotificacionManager;
import com.mindia.carmind.notificacion.pojo.NotificacionFailureEvaluacionView;
import com.mindia.carmind.notificacion.pojo.TestRabbitMessage;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationRabbitMq {

    @Autowired
    NotificacionManager manager;

    @RabbitListener(queues = "spring-boot")
    public void receiveMessage(TestRabbitMessage message) {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario user = new Usuario();
        user.setNombre(message.getNombre());
        user.setApellido(message.getApellido());
        user.setUsername(message.getEmail());
        usuarios.add(user);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = LocalDateTime.now().format(formatter);
        NotificacionFailureEvaluacionView notif = new NotificacionFailureEvaluacionView(
                message.getNombre(),
                message.getApellido(),
                message.getVehiculoNombre(),
                message.getLogId(),
                message.getVehiculoId(),
                currentDateTime);

        System.out.println("Mandando email a :" + message.getEmail());
        System.out.println(message.toString());
        NotificacionManager.sendEmailNotificationFailure(usuarios, notif, manager.fastEmailUrl);
    }
}
