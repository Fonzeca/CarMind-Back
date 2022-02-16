
package com.mindia.carmind.evaluacion.pojo.alta;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "descripcion",
    "index",
    "tipo",
    "opciones"
})
@Generated("jsonschema2pojo")
public class AltaPreguntaPojo {

    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("index")
    private Integer index;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("opciones")
    private List<String> opciones = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AltaPreguntaPojo() {
    }

    /**
     * 
     * @param descripcion
     * @param tipo
     * @param opciones
     * @param index
     */
    public AltaPreguntaPojo(String descripcion, Integer index, String tipo, List<String> opciones) {
        super();
        this.descripcion = descripcion;
        this.index = index;
        this.tipo = tipo;
        this.opciones = opciones;
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
    public List<String> getOpciones() {
        return opciones;
    }

    @JsonProperty("opciones")
    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

}
