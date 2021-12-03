package com.mindia.carmind.seccion.controller;

import com.mindia.carmind.seccion.manager.SeccionManager;
import com.mindia.carmind.seccion.pojo.AltaSeccionPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeccionApi {


    @Autowired
    SeccionManager manager;


    @PostMapping("/seccion")
    @PreAuthorize("hasRole('admin_empresa')")
    public void createPregunta(@RequestBody AltaSeccionPojo alta){

    }

    


}
