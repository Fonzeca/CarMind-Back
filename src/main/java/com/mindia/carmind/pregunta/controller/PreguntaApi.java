package com.mindia.carmind.pregunta.controller;

import com.mindia.carmind.pregunta.manager.PreguntaManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreguntaApi {


    @Autowired
    PreguntaManager manager;


    // @PreAuthorize("hasRole('admin_empresa')")
    // @PostMapping("/pregunta")
    // public void createPregunta(@RequestBody AltaPreguntaPojo alta){
    //     manager.createPregunta(alta);
    // }

    // @PreAuthorize("hasRole('admin_empresa')")
    // @GetMapping("/pregunta")
    // public List<PreguntaView> getAll(){
    //     return manager.getAllActivos();
    // }

    // @PreAuthorize("hasRole('admin_empresa')")
    // @PutMapping("/pregunta/{id}/desactivate")
    // public void desactivatePreguntaById(@PathVariable String id){
    //     manager.desactivatePregunta(id);
    // }

    


}
