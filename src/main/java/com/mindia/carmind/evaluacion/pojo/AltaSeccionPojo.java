
package com.mindia.carmind.evaluacion.pojo;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nombre",
    "index",
    "preguntas"
})
@Generated("jsonschema2pojo")
public class AltaSeccionPojo {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("index")
    private Integer index;
    @JsonProperty("preguntas")
    private List<AltaPreguntaPojo> preguntas = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AltaSeccionPojo() {
    }

    /**
     * 
     * @param index
     * @param preguntas
     * @param nombre
     */
    public AltaSeccionPojo(String nombre, Integer index, List<AltaPreguntaPojo> preguntas) {
        super();
        this.nombre = nombre;
        this.index = index;
        this.preguntas = preguntas;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    @JsonProperty("preguntas")
    public List<AltaPreguntaPojo> getPreguntas() {
        return preguntas;
    }

    @JsonProperty("preguntas")
    public void setPreguntas(List<AltaPreguntaPojo> preguntas) {
        this.preguntas = preguntas;
    }

}
