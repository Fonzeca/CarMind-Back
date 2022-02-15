package com.mindia.carmind.pregunta.controller;

import java.util.List;

import com.mindia.carmind.pregunta.manager.PreguntaManager;
import com.mindia.carmind.pregunta.pojo.AltaPreguntaPojo;
import com.mindia.carmind.pregunta.pojo.PreguntaView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreguntaApi {


    @Autowired
    PreguntaManager manager;


    @PreAuthorize("hasRole('admin_empresa')")
    @PostMapping("/pregunta")
    public void createPregunta(@RequestBody AltaPreguntaPojo alta){
        manager.createPregunta(alta);
    }

    @PreAuthorize("hasRole('admin_empresa')")
    @GetMapping("/pregunta")
    public List<PreguntaView> getAll(){
        return manager.getAllActivos();
    }

    @PreAuthorize("hasRole('admin_empresa')")
    @PutMapping("/pregunta/{id}/desactivate")
    public void desactivatePreguntaById(@PathVariable String id){
        manager.desactivatePregunta(id);
    }
    


}
