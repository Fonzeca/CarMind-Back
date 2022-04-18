
package com.mindia.carmind.usuario.pojo.sync;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.evaluacion.pojo.respuesta.AltaEvaluacionTerminadaPojo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fecha",
    "evaluacionId",
    "respuesta"
})
@Generated("jsonschema2pojo")
public class LogEvaluacionRealizada {

    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("evaluacionId")
    private Integer evaluacionId;
    @JsonProperty("respuesta")
    private AltaEvaluacionTerminadaPojo respuesta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LogEvaluacionRealizada() {
    }

    /**
     * 
     * @param fecha
     * @param respuesta
     * @param evaluacionId
     */
    public LogEvaluacionRealizada(String fecha, Integer evaluacionId, AltaEvaluacionTerminadaPojo respuesta) {
        super();
        this.fecha = fecha;
        this.evaluacionId = evaluacionId;
        this.respuesta = respuesta;
    }

    @JsonProperty("fecha")
    public String getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @JsonProperty("evaluacionId")
    public Integer getEvaluacionId() {
        return evaluacionId;
    }

    @JsonProperty("evaluacionId")
    public void setEvaluacionId(Integer evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    @JsonProperty("respuesta")
    public AltaEvaluacionTerminadaPojo getRespuesta() {
        return respuesta;
    }

    @JsonProperty("respuesta")
    public void setRespuesta(AltaEvaluacionTerminadaPojo respuesta) {
        this.respuesta = respuesta;
    }

}
