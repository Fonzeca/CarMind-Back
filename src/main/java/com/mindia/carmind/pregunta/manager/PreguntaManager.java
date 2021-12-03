package com.mindia.carmind.pregunta.manager;

import com.mindia.carmind.pregunta.persistence.PreguntaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntaManager {
    @Autowired
    PreguntaRepository repository;



}
