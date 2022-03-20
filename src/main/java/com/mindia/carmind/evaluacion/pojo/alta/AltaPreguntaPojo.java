
package com.mindia.carmind.evaluacion.pojo.alta;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "descripcion",
    "tipo",
    "opciones",
    "crucial"
})
@Generated("jsonschema2pojo")
public class AltaPreguntaPojo {

    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("opciones")
    private List<AltaOpcionPojo> opciones = null;
    @JsonProperty("crucial")
    private Boolean crucial;

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
     */
    public AltaPreguntaPojo(String descripcion, String tipo, List<AltaOpcionPojo> opciones) {
        super();
        this.descripcion = descripcion;
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

    @JsonProperty("tipo")
    public String getTipo() {
        return tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonProperty("opciones")
    public List<AltaOpcionPojo> getOpciones() {
        return opciones;
    }

    @JsonProperty("opciones")
    public void setOpciones(List<AltaOpcionPojo> opciones) {
        this.opciones = opciones;
    }

    @JsonProperty("crucial")
    public Boolean getCrucial() {
        return this.crucial;
    }

    @JsonProperty("crucial")
    public void setCrucial(Boolean crucial) {
        this.crucial = crucial;
    }
}
