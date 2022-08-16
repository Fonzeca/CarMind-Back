
package com.mindia.carmind.usuario.pojo.sync;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.evaluacion.pojo.respuesta.AltaRespuestaPojo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fecha",
    "evaluacionId",
    "vehiculoId",
    "usuarioId",
    "respuestas"
})
@Generated("jsonschema2pojo")
public class LogEvaluacionRealizada {

    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("evaluacionId")
    private Integer evaluacionId;
    @JsonProperty("vehiculoId")
    private Integer vehiculoId;
    @JsonProperty("usuarioId")
    private Integer usuarioId;
    @JsonProperty("respuestas")
    private List<AltaRespuestaPojo> respuestas;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LogEvaluacionRealizada() {
    }

    /**
     * 
     * @param fecha
     * @param evaluacionId
     * @param vehiculoId
     * @param usuarioId
     * @param respuestas
     */
    public LogEvaluacionRealizada(String fecha, Integer evaluacionId, Integer vehiculoId, Integer usuarioId, List<AltaRespuestaPojo> respuestas) {
        super();
        this.fecha = fecha;
        this.evaluacionId = evaluacionId;
        this.vehiculoId = vehiculoId;
        this.usuarioId = usuarioId;
        this.respuestas = respuestas;
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

    @JsonProperty("vehiculoId")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculoId")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @JsonProperty("usuarioId")
    public Integer getUsuarioId() {
        return usuarioId;
    }

    @JsonProperty("usuarioId")
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @JsonProperty("respuestas")
    public List<AltaRespuestaPojo> getRespuestas() {
        return respuestas;
    }

    @JsonProperty("respuestas")
    public void setRespuestas(List<AltaRespuestaPojo> respuestas) {
        this.respuestas = respuestas;
    }

}
