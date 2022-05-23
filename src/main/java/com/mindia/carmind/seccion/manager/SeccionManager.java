package com.mindia.carmind.seccion.manager;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mindia.carmind.entities.Seccion;
import com.mindia.carmind.evaluacion.pojo.alta.AltaSeccionPojo;
import com.mindia.carmind.pregunta.manager.PreguntaManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeccionManager {
    @Autowired
    com.mindia.carmind.seccion.persistence.SeccionRepository repository;

    @Autowired
    PreguntaManager preguntaManager;

    // public void createSeccion(AltaSeccionPojo alta){
    //     alta.validate();

    //     Seccion seccion = new Seccion();

    //     seccion.setDescripcion(alta.getDescripcion());
    //     seccion.setNombre(alta.getNombre());
    //     seccion.setActivo(true);

    //     repository.save(seccion);
    // }

    public void createSeccion(int evaluacionId, List<AltaSeccionPojo> altaSeccionPojo){
        for (AltaSeccionPojo alta : altaSeccionPojo) {
            Seccion seccion = new Seccion();
            seccion.setActivo(true);
            seccion.setNombre(alta.getNombre());
            seccion.setEvaluacionId(evaluacionId);
    
            seccion = repository.save(seccion);
    
            preguntaManager.createPreguntas(seccion.getId(), alta.getPreguntas());
        }
    }

    // public void desacoplarSecciones(int idEvaluacion){
    //     var list = repository.findByEvaluacionId(idEvaluacion);

    //     list.stream().forEach(x -> x.setEvaluacionId(null));

    //     repository.saveAll(list);
    // }

    public void compararSecciones(int evaluacionId, List<AltaSeccionPojo> secciones){
        var list = repository.findByEvaluacionId(evaluacionId);

        var listNewIds = secciones.stream().map(x -> x.getId()).collect(Collectors.toList());
        var listOldIds = list.stream().map(x -> x.getId()).collect(Collectors.toList());

        //Lista de ids de secciones para sacar
        var quitarSecc = listOldIds.stream().dropWhile(x -> listNewIds.contains(x)).collect(Collectors.toList());

        //Recorremos y desacoplamos
        for (Integer idSacar : quitarSecc) {
            var optSecc = repository.findById(idSacar);
            if(optSecc.isPresent()){
                var seccionSacada = optSecc.get();
                seccionSacada.setEvaluacionId(null);
                repository.save(seccionSacada);

                //TODO: limpiar secciones colgadas
            }
        }
        
        

        for (AltaSeccionPojo seccion : secciones) {
            Optional<Seccion> secc = repository.findById(seccion.getId()!=null ? seccion.getId() : -1);
    
            if(secc.isPresent()){
                
            }else{
                //Se agrega
                createSeccion(evaluacionId, List.of(seccion));
            }
        }

    }

    // public void desactivateSeccion(String id){
    //     int intId = Integer.parseInt(id);

    //     Seccion seccion = repository.findByIdAndActivoTrue(intId);
    //     if(seccion == null){
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seccion no encontrada");
    //     }
    //     seccion.setActivo(false);

    //     repository.save(seccion);
    // }

    // public List<SeccionView> getAll(){
    //     return repository.findByActivoTrue().stream().map(SeccionView::new).collect(Collectors.toList());
    // }

    // public Seccion getSeccionActivaById(String id){
    //     int intId = Integer.parseInt(id);

    //     Seccion seccion = repository.findByIdAndActivoTrue(intId);
    //     if(seccion == null){
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seccion no encontrada");
    //     }
    //     return seccion;
    // }


}
