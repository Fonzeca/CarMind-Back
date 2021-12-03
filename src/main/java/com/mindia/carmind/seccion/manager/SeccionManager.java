package com.mindia.carmind.seccion.manager;

import com.mindia.carmind.pregunta.persistence.SeccionRepository;
import com.mindia.carmind.seccion.pojo.AltaSeccionPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeccionManager {
    @Autowired
    SeccionRepository repository;

    public void createSeccion(AltaSeccionPojo alta){
        
    }


}
