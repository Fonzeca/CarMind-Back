package com.mindia.carmind.revision.manager;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.mindia.carmind.entities.LogEvaluacion;
import com.mindia.carmind.entities.Revision;
import com.mindia.carmind.entities.Vehiculo;
import com.mindia.carmind.evaluacion.manager.EvaluacionManager;
import com.mindia.carmind.evaluacion.persistence.LogEvaluacionRepository;
import com.mindia.carmind.evaluacion.pojo.LogEvaluacionView;
import com.mindia.carmind.revision.persistence.RevisionRepository;
import com.mindia.carmind.revision.pojo.AltaRevision;
import com.mindia.carmind.revision.pojo.RevisionView;
import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RevisionManager {

    @Autowired
    RevisionRepository repository;

    @Autowired
    UsuariosManager usuariosManager;

    @Autowired
    EvaluacionManager evaluacionManager;

    @Autowired
    VehiculosRepository vehiculosRepository;
    
    @Autowired
    LogEvaluacionRepository logEvaluacionRepository;

    @Transactional
    public void altaRevision(AltaRevision alta){
        Revision revision = new Revision();
        
        if(alta.getVehiculoId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe indicar el vehiculo a revisar.");
        }

        revision.setVehiculoId(alta.getVehiculoId());

        revision.setFecha(LocalDate.now());
        revision.setNota(alta.getNota());
        revision.setUsuarioId(usuariosManager.getLoggeduser().getId());

        revision = repository.save(revision);

        Vehiculo vehiculo = vehiculosRepository.getById(alta.getVehiculoId());
        vehiculo.setAveriado(false);
        vehiculosRepository.save(vehiculo);

        setFalseRevisarLogEvaluacion(alta.getVehiculoId(), revision.getId());
    }

    public List<RevisionView> getRevisionOfVehiculo(Integer vehiculoId){
        return repository.findByVehiculoId(vehiculoId).stream().map(RevisionView::new).collect(Collectors.toList());
    }

    public List<LogEvaluacionView> getLogsParaRevisar(Integer vehiculoId){
        return logEvaluacionRepository.findByVehiculoIdAndParaRevisarTrue(vehiculoId).stream().map(LogEvaluacionView::new).collect(Collectors.toList());
    }

    //---------------------------------------PRIVATE-----------------------------------------------------

    private void setFalseRevisarLogEvaluacion(Integer vehiculoId, Integer revisionId){
        var logs = logEvaluacionRepository.findByVehiculoIdAndParaRevisarTrue(vehiculoId);
        for(LogEvaluacion log : logs){
            log.setParaRevisar(false);
            log.setRevisionId(revisionId);
            logEvaluacionRepository.save(log);
        }
    }

}
