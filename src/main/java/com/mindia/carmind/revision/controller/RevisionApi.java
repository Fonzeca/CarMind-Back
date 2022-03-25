package com.mindia.carmind.revision.controller;

import java.util.List;

import com.mindia.carmind.evaluacion.pojo.LogEvaluacionView;
import com.mindia.carmind.revision.manager.RevisionManager;
import com.mindia.carmind.revision.pojo.AltaRevision;
import com.mindia.carmind.revision.pojo.RevisionView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RevisionApi {

    @Autowired
    RevisionManager manager;

    @PostMapping("/revision")
    public void insertRevision(@RequestBody AltaRevision alta){
        manager.altaRevision(alta);
    }

    @GetMapping("/vehiculo/{id}/revision")
    public List<RevisionView> getAllRevisionOfVehiculo(@PathVariable Integer id){
        return getAllRevisionOfVehiculo(id);
    }
    

    @GetMapping("/vehiculo/{id}/logsParaRevisar")
    public List<LogEvaluacionView> getLogsParaRevisar(@PathVariable Integer id){
        return manager.getLogsParaRevisar(id);
    }

}
