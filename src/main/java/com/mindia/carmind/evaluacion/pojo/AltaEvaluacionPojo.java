package com.mindia.carmind.evaluacion.pojo;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nombre",
        "ids_preguntas"
})
@Generated("jsonschema2pojo")
public class AltaEvaluacionPojo {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("ids_preguntas")
    private List<Integer> idsPreguntas = null;

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("ids_preguntas")
    public List<Integer> getIdsPreguntas() {
        return idsPreguntas;
    }

    @JsonProperty("ids_preguntas")
    public void setIdsPreguntas(List<Integer> idsPreguntas) {
        this.idsPreguntas = idsPreguntas;
    }

}