
package com.mindia.carmind.vehiculo.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id_evaluacion",
    "intervalo_dias",
    "fecha_inicio"
})
@Generated("jsonschema2pojo")
public class AsignacionPojo {

    @JsonProperty("id_evaluacion")
    private Integer idEvaluacion;
    @JsonProperty("intervalo_dias")
    private Integer intervalo_dias;
    @JsonProperty("fecha_inicio")
    private String fecha_inicio;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AsignacionPojo() {
    }

    /**
     * 
     * @param idEvaluacion
     * @param intervalo_dias
     */
    public AsignacionPojo(Integer idEvaluacion, Integer intervalo_dias) {
        super();
        this.idEvaluacion = idEvaluacion;
        this.intervalo_dias = intervalo_dias;
    }

    @JsonProperty("id_evaluacion")
    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    @JsonProperty("id_evaluacion")
    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    @JsonProperty("intervalo_dias")
    public Integer getIntervalo_dias() {
        return this.intervalo_dias;
    }

    @JsonProperty("intervalo_dias")
    public void setIntervalo_dias(Integer intervalo_dias) {
        this.intervalo_dias = intervalo_dias;
    }

    @JsonProperty("fecha_inicio")
    public String getFecha_inicio() {
        return this.fecha_inicio;
    }
    
    @JsonProperty("fecha_inicio")
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }


}
