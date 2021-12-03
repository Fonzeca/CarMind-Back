package com.mindia.carmind.pregunta.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "descripcion",
        "seccion"
})
@Generated("jsonschema2pojo")
public class AltaPreguntaPojo {

    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("seccion")
    private Integer seccion;

    /**
     * No args constructor for use in serialization
     *
     */
    public AltaPreguntaPojo() {
    }

    /**
     *
     * @param descripcion
     * @param seccion
     */
    public AltaPreguntaPojo(String descripcion, Integer seccion) {
        super();
        this.descripcion = descripcion;
        this.seccion = seccion;
    }

    @JsonProperty("descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    @JsonProperty("descripcion")
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonProperty("seccion")
    public Integer getSeccion() {
        return seccion;
    }

    @JsonProperty("seccion")
    public void setSeccion(Integer seccion) {
        this.seccion = seccion;
    }

}