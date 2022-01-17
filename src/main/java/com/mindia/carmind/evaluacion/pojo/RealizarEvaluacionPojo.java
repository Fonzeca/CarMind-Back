package com.mindia.carmind.evaluacion.pojo;

import java.util.List;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "vehiculo_id",
        "observaciones",
        "respuestas"
})
@Generated("jsonschema2pojo")
public class RealizarEvaluacionPojo {
    @JsonProperty("vehiculo_id")
    private Integer vehiculoId;
    @JsonProperty("respuestas")
    private List<RespuestaPojo> respuestas = null;
    @JsonProperty("observaciones")
    private String observaciones;

    /**
     * No args constructor for use in serialization
     *
     */
    public RealizarEvaluacionPojo() {
    }

    /**
     *
     * @param respuestas
     * @param vehiculoId
     */
    public RealizarEvaluacionPojo(Integer vehiculoId, List<RespuestaPojo> respuestas) {
        super();
        this.vehiculoId = vehiculoId;
        this.respuestas = respuestas;
    }

    @JsonProperty("vehiculo_id")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculo_id")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @JsonProperty("respuestas")
    public List<RespuestaPojo> getRespuestas() {
        return respuestas;
    }

    @JsonProperty("respuestas")
    public void setRespuestas(List<RespuestaPojo> respuestas) {
        this.respuestas = respuestas;
    }

    @JsonProperty("observaciones")
    public String getObservaciones() {
        return this.observaciones;
    }

    @JsonProperty("observaciones")
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void validate(){
        if(this.vehiculoId == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe tener vehiculo_id");
        }

        if(this.respuestas == null || this.respuestas.size() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe tener respuestas");
        }

    }


}
