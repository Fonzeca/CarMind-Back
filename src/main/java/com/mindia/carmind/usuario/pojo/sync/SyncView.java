
package com.mindia.carmind.usuario.pojo.sync;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "logUso",
    "evaluacionesRealizadas"
})
@Generated("jsonschema2pojo")
public class SyncView {

    @JsonProperty("logUso")
    private List<LogUsoView> logUso = null;
    @JsonProperty("evaluacionesRealizadas")
    private List<LogEvaluacionRealizada> evaluacionesRealizadas = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SyncView() {
    }

    /**
     * 
     * @param evaluacionesRealizadas
     * @param logUso
     */
    public SyncView(List<LogUsoView> logUso, List<LogEvaluacionRealizada> evaluacionesRealizadas) {
        super();
        this.logUso = logUso;
        this.evaluacionesRealizadas = evaluacionesRealizadas;
    }

    @JsonProperty("logUso")
    public List<LogUsoView> getLogUso() {
        return logUso;
    }

    @JsonProperty("logUso")
    public void setLogUso(List<LogUsoView> logUso) {
        this.logUso = logUso;
    }

    @JsonProperty("evaluacionesRealizadas")
    public List<LogEvaluacionRealizada> getEvaluacionesRealizadas() {
        return evaluacionesRealizadas;
    }

    @JsonProperty("evaluacionesRealizadas")
    public void setEvaluacionesRealizadas(List<LogEvaluacionRealizada> evaluacionesRealizadas) {
        this.evaluacionesRealizadas = evaluacionesRealizadas;
    }

}
