
package com.mindia.carmind.vehiculo.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id_evaluacion",
    "frecuencia"
})
@Generated("jsonschema2pojo")
public class AsignacionPojo {

    @JsonProperty("id_evaluacion")
    private Integer idEvaluacion;
    @JsonProperty("frecuencia")
    private Integer frecuencia;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AsignacionPojo() {
    }

    /**
     * 
     * @param idEvaluacion
     * @param frecuencia
     */
    public AsignacionPojo(Integer idEvaluacion, Integer frecuencia) {
        super();
        this.idEvaluacion = idEvaluacion;
        this.frecuencia = frecuencia;
    }

    @JsonProperty("id_evaluacion")
    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    @JsonProperty("id_evaluacion")
    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    @JsonProperty("frecuencia")
    public Integer getFrecuencia() {
        return frecuencia;
    }

    @JsonProperty("frecuencia")
    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

}
