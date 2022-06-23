
package com.mindia.carmind.evaluacion.pojo.log_details;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.LogOption;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "log_id",
    "opcion",
    "tick_correcto",
    "crucial"
})
@Generated("jsonschema2pojo")
public class LogOpcionDetailsView {

    @JsonProperty("log_id")
    private Integer logId;
    @JsonProperty("opcion")
    private String opcion;
    @JsonProperty("tick_correcto")
    private Boolean tickCorrecto;
    @JsonProperty("crucial")
    private Boolean crucial;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LogOpcionDetailsView() {
    }

    /**
     * 
     * @param opcion
     * @param crucial
     * @param logId
     * @param tickCorrecto
     */
    public LogOpcionDetailsView(Integer logId, String opcion, Boolean tickCorrecto, Boolean crucial) {
        super();
        this.logId = logId;
        this.opcion = opcion;
        this.tickCorrecto = tickCorrecto;
        this.crucial = crucial;
    }

    public LogOpcionDetailsView(LogOption log) {
        super();
        this.logId = log.getId();
        this.opcion = log.getDescripcion();
        this.crucial = log.isCrucial();
        this.tickCorrecto = log.isTickCheck();
    }

    @JsonProperty("log_id")
    public Integer getLogId() {
        return logId;
    }

    @JsonProperty("log_id")
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    @JsonProperty("opcion")
    public String getOpcion() {
        return opcion;
    }

    @JsonProperty("opcion")
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    @JsonProperty("tick_correcto")
    public Boolean getTickCorrecto() {
        return tickCorrecto;
    }

    @JsonProperty("tick_correcto")
    public void setTickCorrecto(Boolean tickCorrecto) {
        this.tickCorrecto = tickCorrecto;
    }

    @JsonProperty("crucial")
    public Boolean getCrucial() {
        return crucial;
    }

    @JsonProperty("crucial")
    public void setCrucial(Boolean crucial) {
        this.crucial = crucial;
    }

}
