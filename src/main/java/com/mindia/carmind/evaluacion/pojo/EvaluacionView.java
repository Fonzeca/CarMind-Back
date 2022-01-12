package com.mindia.carmind.evaluacion.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Evaluacion;
import com.mindia.carmind.entities.Pregunta;
import com.mindia.carmind.entities.Seccion;
import com.mindia.carmind.seccion.pojo.SeccionView;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "nombre"
})
@Generated("jsonschema2pojo")
public class EvaluacionView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("secciones")
    private List<SeccionView> secciones;

    @JsonProperty("secciones")
    public List<SeccionView> getSecciones() {
        return this.secciones;
    }

    @JsonProperty("secciones")
    public void setSecciones(List<SeccionView> secciones) {
        this.secciones = secciones;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EvaluacionView(Evaluacion e){
        this.id = e.getId();
        this.nombre = e.getNombre();
    }

    public EvaluacionView(Evaluacion e, List<Pregunta> preguntas, List<Seccion> secciones){
        this.id = e.getId();
        this.nombre = e.getNombre();
        this.secciones = new ArrayList<SeccionView>();

        for (Seccion seccion : secciones) {
            List<Pregunta> preguntasxSeccion = preguntas.stream().filter(x -> x.getSeccion() == seccion.getId()).collect(Collectors.toList());

            this.secciones.add(new SeccionView(seccion, preguntasxSeccion));
        }

    }

}