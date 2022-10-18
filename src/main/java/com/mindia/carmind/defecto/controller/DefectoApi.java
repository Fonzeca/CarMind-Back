package com.mindia.carmind.defecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.carmind.defecto.manager.DefectoManager;
import com.mindia.carmind.entities.Defecto;

@RestController
public class DefectoApi {

    @Autowired
    DefectoManager manager;

    @GetMapping("/defectos")
    public List<Defecto> getAllDefectos(){
        return manager.getAllDefectos();
    }

    @PutMapping("/defectos/{id}/changePriority")
    public void changeName(@PathVariable int id, @RequestParam Integer newPriority){
        manager.changePriorityOfDefecto(id, newPriority);
    }
}
