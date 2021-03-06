
package com.mindia.carmind.pregunta.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.utils.exception.custom.EmptyFieldOnPojo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "descripcion",
    "seccion_id"
})
@Generated("jsonschema2pojo")
public class AltaPreguntaPojo {

    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("seccion_id")
    private Integer seccionId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AltaPreguntaPojo() {
    }

    /**
     * 
     * @param descripcion
     * @param seccionId
     */
    public AltaPreguntaPojo(String descripcion, Integer seccionId) {
        super();
        this.descripcion = descripcion;
        this.seccionId = seccionId;
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

    public void validate(){
        if(descripcion == null || descripcion.isEmpty()){
            throw new EmptyFieldOnPojo("descripcion");
        }

        if(seccionId == null || seccionId < 0){
            throw new EmptyFieldOnPojo("seccion_id");
        }
    }

}
