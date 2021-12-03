package com.mindia.carmind.evaluacion.controller;

import com.mindia.carmind.usuario.pojo.userHub.UserHubConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluacionApi {


    @Autowired
    UserHubConfig userHubConfig;


    @GetMapping("/test2")
    @PreAuthorize("hasRole('admin')")
    public String test(){
        return "Hello World";
    }


}
