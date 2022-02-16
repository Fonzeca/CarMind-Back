
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
    "index",
    "tipo",
    "opciones"
})
@Generated("jsonschema2pojo")
public class PreguntaView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("index")
    private Integer index;
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
     * @param index
     * @param id
     */
    public PreguntaView(Integer id, String descripcion, Integer index, String tipo, List<OpcionView> opciones) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.index = index;
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

    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
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
        this.index = p.getIndexOrden();
        this.tipo = p.getTipo();

        this.opciones = p.getListOfPreguntaOpcion().stream().map(OpcionView::new).collect(Collectors.toList());
    }

}
