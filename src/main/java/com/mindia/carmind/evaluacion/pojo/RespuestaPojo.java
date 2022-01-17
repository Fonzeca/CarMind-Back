package com.mindia.carmind.evaluacion.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.LogPregunta;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "pregunta_id",
        "respuesta"
})
@Generated("jsonschema2pojo")
public class RespuestaPojo {

    @JsonProperty("pregunta_id")
    private Integer preguntaId;
    @JsonProperty("respuesta")
    private String respuesta;

    @JsonProperty("pregunta_id")
    public Integer getPreguntaId() {
        return preguntaId;
    }

    @JsonProperty("pregunta_id")
    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    @JsonProperty("respuesta")
    public String getRespuesta() {
        return respuesta;
    }

    @JsonProperty("respuesta")
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public LogPregunta parseToLogPregunta(Integer logEvaluacionId){
        LogPregunta log = new LogPregunta();
        log.setLogEvaluacion(logEvaluacionId);
        log.setPregunta(this.preguntaId);
        log.setRespuesta(this.respuesta);
        return log;
    }

}