package com.mindia.carmind.evaluacion.manager;

import com.mindia.carmind.usuario.persistence.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionManager {
    @Autowired
    UsuariosRepository repository;



}
