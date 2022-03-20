package com.mindia.carmind.evaluacion.controller;

import java.util.List;

import com.mindia.carmind.evaluacion.manager.EvaluacionManager;
import com.mindia.carmind.evaluacion.pojo.LogEvaluacionView;
import com.mindia.carmind.evaluacion.pojo.alta.AltaPojo;
import com.mindia.carmind.evaluacion.pojo.log_details.LogEvaluacionDetailsView;
import com.mindia.carmind.evaluacion.pojo.respuesta.AltaEvaluacionTerminadaPojo;
import com.mindia.carmind.evaluacion.pojo.view.EvaluacionView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluacionApi {


    @Autowired
    EvaluacionManager manager;

    @PostMapping("/evaluacion")
    @PreAuthorize("hasRole('admin_empresa')")
    public void altaEvaluacion(@RequestBody AltaPojo alta){
        manager.altaEvaluacion(alta);
    }

    @GetMapping("/evaluacion")
    @PreAuthorize("hasRole('admin_empresa')")
    public List<EvaluacionView> getAllEvaluacion(){
        return manager.getAllEvaluaciones();
    }

    @GetMapping("/evaluacion/{id}")
    public EvaluacionView getEvaluacionById(@PathVariable int id){
        return manager.getEvaluacionViewById(id);
    }

    @PutMapping("/evaluacion/{id}/changeName")
    @PreAuthorize("hasRole('admin_empresa')")
    public void changeName(@PathVariable int id, @RequestParam String newName){
        manager.changeNameOfEvaluacion(id, newName);
    }

    // @PutMapping("/evaluacion/{id}/changePreguntas")
    // @PreAuthorize("hasRole('admin_empresa')")
    // public void changePreguntas(@PathVariable int id, @RequestBody AltaEvaluacionPojo alta){
    //     manager.changePreguntasOfEvaluacion(id, alta);
    // }

    @PostMapping("/evaluacion/{id}/realizar")
    public void realizarEvaluacion(@PathVariable int id, @RequestBody AltaEvaluacionTerminadaPojo respuestas){
        manager.realizarEvaluacion(id, respuestas);
    }

    //---------------------------------LOGS-----------------------------------------

    @GetMapping("/evaluacion/historial")
    public List<LogEvaluacionView> getHistualLog(){
        return manager.historialDeEvaluaciones();
    }

    @GetMapping("/evaluacion/historial/loggedUser")
    public List<LogEvaluacionView> getHistualLogLoggedUser(){
        return manager.historialDeEvaluacionesByLoggedUser();
    }

    @GetMapping("/evaluacion/historial/{id}")
    public LogEvaluacionDetailsView getLogById(@PathVariable int id){
        return manager.getLogById(id);
    }




}
