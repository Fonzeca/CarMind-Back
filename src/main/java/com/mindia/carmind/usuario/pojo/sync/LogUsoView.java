
package com.mindia.carmind.usuario.pojo.sync;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vehiculoId",
    "usuarioId",
    "fechaInicio",
    "fechaFin"
})
@Generated("jsonschema2pojo")
public class LogUsoView {

    @JsonProperty("vehiculoId")
    private Integer vehiculoId;
    @JsonProperty("usuarioId")
    private Integer usuarioId;
    @JsonProperty("fechaInicio")
    private String fechaInicio;
    @JsonProperty("fechaFin")
    private String fechaFin;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LogUsoView() {
    }

    /**
     * 
     * @param vehiculoId
     * @param usuarioId
     * @param fechaInicio
     * @param fechaFin
     */
    public LogUsoView(Integer vehiculoId, Integer usuarioId, String fechaInicio,String fechaFin) {
        super();
        this.vehiculoId = vehiculoId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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


    @JsonProperty("fechaInicio")
    public String getFechaInicio() {
        return fechaInicio;
    }

    @JsonProperty("fechaInicio")
    public void setfechaFin(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @JsonProperty("fechaFin")
    public String getFechaFin() {
        return fechaFin;
    }

    @JsonProperty("fechaFin")
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

}
