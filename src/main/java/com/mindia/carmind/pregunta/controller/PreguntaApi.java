package com.mindia.carmind.pregunta.controller;

import com.mindia.carmind.pregunta.manager.PreguntaManager;
import com.mindia.carmind.pregunta.pojo.AltaPreguntaPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreguntaApi {


    @Autowired
    PreguntaManager manager;


    @PostMapping("/pregunta")
    @PreAuthorize("hasRole('admin_empresa')")
    public void createPregunta(@RequestBody AltaPreguntaPojo alta){

    }

    


}
