package com.mindia.carmind.defecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.carmind.defecto.manager.DefectoManager;
import com.mindia.carmind.defecto.pojo.DefectoView;

@RestController
public class DefectoApi {

    @Autowired
    DefectoManager manager;

    @GetMapping("/defectos")
    @PreAuthorize("hasRole('admin_empresa')")
    public List<DefectoView> getAllDefectos(){
        return manager.getAllDefectos();
    }

    @PutMapping("/defectos/{id}/changePriority")
    @PreAuthorize("hasRole('admin_empresa')")
    public void changePriority(@PathVariable int id, @RequestParam Integer newPriority){
        manager.changePriorityOfDefecto(id, newPriority);
    }

    @PutMapping("/defectos/{id}/changeState")
    @PreAuthorize("hasRole('admin_empresa')")
    public void changeState(@PathVariable int id, @RequestParam String newState){
        manager.changeStateOfDefecto(id, newState);
    }
}
