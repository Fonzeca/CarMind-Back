
package com.mindia.carmind.evaluacion.pojo.alta;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nombre",
    "preguntas"
})
@Generated("jsonschema2pojo")
public class AltaSeccionPojo {

    @JsonProperty("nombre")
    private String nombre;
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
     * @param preguntas
     * @param nombre
     */
    public AltaSeccionPojo(String nombre, List<AltaPreguntaPojo> preguntas) {
        super();
        this.nombre = nombre;
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

    @JsonProperty("preguntas")
    public List<AltaPreguntaPojo> getPreguntas() {
        return preguntas;
    }

    @JsonProperty("preguntas")
    public void setPreguntas(List<AltaPreguntaPojo> preguntas) {
        this.preguntas = preguntas;
    }

}
