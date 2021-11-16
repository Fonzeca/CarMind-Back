
package com.mindia.carmind.vehiculo.pojo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**
     * Funcion para buscar entre las base de datos, un modelo.
     * Si no existe, devuelve null.
     * 
     * @param modelos
     * @param modelo el modelo a buscar
     * @return El objeto ModelPojo
     */
    public static ModeloPojo buscarModelo(Stream<ModeloPojo> modelos, String modelo){
        if(modelo != null && !modelo.isBlank()){

            //Busca y lo encapsulamos en a
            List<ModeloPojo> a = modelos.filter(
                x -> x.getModelo().trim().toLowerCase().equals(modelo.trim().toLowerCase())
            ).collect(Collectors.toList());

            //Me duvuelve el primero o null
            return a.size() > 0 ? a.get(0) : null;
        }else{
            return null;
        }
    }

}
