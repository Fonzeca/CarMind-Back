
package com.mindia.carmind.seccion.pojo;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Pregunta;
import com.mindia.carmind.entities.Seccion;
import com.mindia.carmind.pregunta.pojo.PreguntaView;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "nombre",
    "descripcion",
    "activo"
})
@Generated("jsonschema2pojo")
public class SeccionView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("activo")
    private Boolean activo;
    @JsonProperty("preguntas")
    private List<PreguntaView> preguntas;

    public SeccionView(Seccion seccion) {
        super();
        this.id = seccion.getId();
        this.nombre = seccion.getNombre();
        this.descripcion = seccion.getDescripcion();
        this.activo = seccion.getActivo();
    }

    public SeccionView(Seccion seccion, List<Pregunta> preguntas) {
        super();
        this.id = seccion.getId();
        this.nombre = seccion.getNombre();
        this.descripcion = seccion.getDescripcion();

        this.preguntas = preguntas.stream().map(x -> new PreguntaView(x, false)).collect(Collectors.toList());
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

    @JsonProperty("descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    @JsonProperty("descripcion")
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
