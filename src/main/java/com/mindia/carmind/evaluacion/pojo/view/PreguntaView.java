
package com.mindia.carmind.evaluacion.pojo.view;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Pregunta;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "descripcion",
    "tipo",
    "opciones"
})
@Generated("jsonschema2pojo")
public class PreguntaView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("opciones")
    private List<OpcionView> opciones = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PreguntaView() {
    }

    /**
     * 
     * @param descripcion
     * @param tipo
     * @param opciones
     * @param id
     */
    public PreguntaView(Integer id, String descripcion, String tipo, List<OpcionView> opciones) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.opciones = opciones;
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

    @JsonProperty("tipo")
    public String getTipo() {
        return tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonProperty("opciones")
    public List<OpcionView> getOpciones() {
        return opciones;
    }

    @JsonProperty("opciones")
    public void setOpciones(List<OpcionView> opciones) {
        this.opciones = opciones;
    }

    public PreguntaView(Pregunta p){
        this.id = p.getId();
        this.descripcion = p.getDescripcion();
        this.tipo = p.getTipoPregunta().getCodigo();

        this.opciones = p.getListOfPreguntaOpcion().stream().map(OpcionView::new).collect(Collectors.toList());
    }

}
