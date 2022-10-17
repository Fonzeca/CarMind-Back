package com.mindia.carmind.defecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.mindia.carmind.defecto.manager.DefectoManager;
import com.mindia.carmind.entities.Defecto;

@Service
public class DefectoApi {

    
    @Autowired
    DefectoManager manager;


    @GetMapping("/defectos")
    public List<Defecto> getAllDefectos(){
        return manager.getAllDefectos();
    }
}
