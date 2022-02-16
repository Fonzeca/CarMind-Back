
package com.mindia.carmind.evaluacion.pojo.respuesta;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "opcion_id",
    "tick_correcto"
})
@Generated("jsonschema2pojo")
public class RespuestaOpcionPojo {

    @JsonProperty("opcion_id")
    private Integer opcionId;
    @JsonProperty("tick_correcto")
    private Boolean tickCorrecto;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RespuestaOpcionPojo() {
    }

    /**
     * 
     * @param opcionId
     * @param tickCorrecto
     */
    public RespuestaOpcionPojo(Integer opcionId, Boolean tickCorrecto) {
        super();
        this.opcionId = opcionId;
        this.tickCorrecto = tickCorrecto;
    }

    @JsonProperty("opcion_id")
    public Integer getOpcionId() {
        return opcionId;
    }

    @JsonProperty("opcion_id")
    public void setOpcionId(Integer opcionId) {
        this.opcionId = opcionId;
    }

    @JsonProperty("tick_correcto")
    public Boolean getTickCorrecto() {
        return tickCorrecto;
    }

    @JsonProperty("tick_correcto")
    public void setTickCorrecto(Boolean tickCorrecto) {
        this.tickCorrecto = tickCorrecto;
    }

}
