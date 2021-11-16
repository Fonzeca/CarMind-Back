
package com.mindia.carmind.vehiculo.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "IdModelo",
    "Modelo"
})
@Generated("jsonschema2pojo")
public class ModeloPojo {

    @JsonProperty("IdModelo")
    private Integer idModelo;
    @JsonProperty("Modelo")
    private String modelo;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ModeloPojo() {
    }

    /**
     * 
     * @param idModelo
     * @param modelo
     */
    public ModeloPojo(Integer idModelo, String modelo) {
        super();
        this.idModelo = idModelo;
        this.modelo = modelo;
    }

    @JsonProperty("IdModelo")
    public Integer getIdModelo() {
        return idModelo;
    }

    @JsonProperty("IdModelo")
    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    @JsonProperty("Modelo")
    public String getModelo() {
        return modelo;
    }

    @JsonProperty("Modelo")
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
