package com.mindia.carmind.notificacion.controller;

import java.util.List;

import com.mindia.carmind.notificacion.manager.NotificacionManager;
import com.mindia.carmind.notificacion.pojo.NotificacionPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificacionApi {

    @Autowired
    NotificacionManager manager;

    @GetMapping("/notificaciones")
    public List<NotificacionPojo> getNotificaciones(){
        return manager.getAllNotificaciones();
    }

    @PostMapping("/runEveryMondayTask")
    public void runEveryMondayTask(){
        manager.runMondayTask();
    }

}
