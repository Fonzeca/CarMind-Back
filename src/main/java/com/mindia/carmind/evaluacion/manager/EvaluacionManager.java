package com.mindia.carmind.evaluacion.manager;

import com.mindia.carmind.entities.Evaluacion;
import com.mindia.carmind.evaluacion.persistence.EvaluacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionManager {
    @Autowired
    EvaluacionRepository repository;

    public Evaluacion getEvaluacionById(String id){
        int intId = Integer.parseInt(id);

        return repository.getById(intId);
    }

}
