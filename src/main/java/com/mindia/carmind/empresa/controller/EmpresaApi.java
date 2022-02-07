package com.mindia.carmind.empresa.controller;

import com.mindia.carmind.empresa.manager.EmpresaManager;
import com.mindia.carmind.empresa.pojo.AltaPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaApi {

    @Autowired
    EmpresaManager manager;

    @PostMapping("/empresa")
    public void altaEmpresa(@RequestBody AltaPojo alta){
        manager.crearEmpresa(alta);
    }

}
