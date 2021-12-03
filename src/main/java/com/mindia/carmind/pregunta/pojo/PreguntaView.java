
package com.mindia.carmind.pregunta.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Pregunta;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "descripcion",
    "seccion_id",
    "activo"
})
@Generated("jsonschema2pojo")
public class PreguntaView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("seccion_id")
    private Integer seccionId;
    @JsonProperty("activo")
    private Boolean activo;


    public PreguntaView(Pregunta pregunta) {
        super();
        this.id = pregunta.getId();
        this.descripcion = pregunta.getDescripcion();
        this.seccionId = pregunta.getSeccion();
        this.activo = pregunta.getActivo();
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    @JsonProperty("descripcion")
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonProperty("seccion_id")
    public Integer getSeccionId() {
        return seccionId;
    }

    @JsonProperty("seccion_id")
    public void setSeccionId(Integer seccionId) {
        this.seccionId = seccionId;
    }

    @JsonProperty("activo")
    public Boolean getActivo() {
        return activo;
    }

    @JsonProperty("activo")
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
