
package com.mindia.carmind.seccion.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "descripcion",
    "nombre"
})
@Generated("jsonschema2pojo")
public class AltaSeccionPojo {

    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("nombre")
    private String nombre;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AltaSeccionPojo() {
    }

    /**
     * 
     * @param descripcion
     * @param nombre
     */
    public AltaSeccionPojo(String descripcion, String nombre) {
        super();
        this.descripcion = descripcion;
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

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
