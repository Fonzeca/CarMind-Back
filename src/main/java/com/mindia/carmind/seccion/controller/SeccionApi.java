package com.mindia.carmind.seccion.controller;

import java.util.List;

import com.mindia.carmind.seccion.manager.SeccionManager;
import com.mindia.carmind.seccion.pojo.AltaSeccionPojo;
import com.mindia.carmind.seccion.pojo.SeccionView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeccionApi {


    @Autowired
    SeccionManager manager;


    @PostMapping("/seccion")
    @PreAuthorize("hasRole('admin_empresa')")
    public void createSeccion(@RequestBody AltaSeccionPojo alta){
        manager.createSeccion(alta);
    }

    @PutMapping("/seccion/{id}/desactivate")
    @PreAuthorize("hasRole('admin_empresa')")
    public void desactivateSeccion(@PathVariable String id){
        manager.desactivateSeccion(id);
    }

    @GetMapping("/seccion")
    @PreAuthorize("hasRole('admin_empresa')")
    public List<SeccionView> getAll(){
        return manager.getAll();
    }

    


}
