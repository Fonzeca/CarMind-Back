
package com.mindia.carmind.evaluacion.pojo.view;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Seccion;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "nombre",
    "preguntas"
})
@Generated("jsonschema2pojo")
public class SeccionView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("preguntas")
    private List<PreguntaView> preguntas = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SeccionView() {
    }

    /**
     * 
     * @param preguntas
     * @param id
     * @param nombre
     */
    public SeccionView(Integer id, String nombre, List<PreguntaView> preguntas) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.preguntas = preguntas;
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


    @JsonProperty("preguntas")
    public List<PreguntaView> getPreguntas() {
        return preguntas;
    }

    @JsonProperty("preguntas")
    public void setPreguntas(List<PreguntaView> preguntas) {
        this.preguntas = preguntas;
    }

    public SeccionView(Seccion s){
        this.id = s.getId();
        this.nombre = s.getNombre();


        this.preguntas = s.getListOfPregunta().stream().filter(x -> x.getActivo()).map(PreguntaView::new).collect(Collectors.toList());
    }

}
