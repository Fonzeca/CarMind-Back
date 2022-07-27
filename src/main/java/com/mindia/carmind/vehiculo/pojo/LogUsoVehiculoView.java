package com.mindia.carmind.vehiculo.pojo;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.LogUsoVehiculo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "fecha_inico",
        "fecha_fin",
        "usuario_id",
        "vehiculo_id"       
})
public class LogUsoVehiculoView {

    @JsonProperty("id")
    private int        id ;
    @JsonProperty("fecha_inicio")
    private LocalDateTime  fechaInicio ;
    @JsonProperty("fecha_fin")
    private LocalDateTime  fechaFin ;
    @JsonProperty("usuario_id")
    private int        usuarioId ;
    @JsonProperty("vehiculo_id")
    private int        vehiculoId ;

    /**
     * No args constructor for use in serialization
     *
     */
    public LogUsoVehiculoView() {
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("fecha_inicio")
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    @JsonProperty("fecha_inicio")
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @JsonProperty("fecha_fin")
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    @JsonProperty("fecha_fin")
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    @JsonProperty("usuario_id")
    public Integer getUsuarioId() {
        return usuarioId;
    }

    @JsonProperty("usuario_id")
    public void setUsarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @JsonProperty("vehiculo_id")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculo_id")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public LogUsoVehiculoView(LogUsoVehiculo log){
        this.id = log.getId();
        this.fechaInicio = log.getFechaInicio();
        this.fechaFin = log.getFechaFin();
        this.usuarioId = log.getUsuarioId();
        this.vehiculoId = log.getVehiculoId();
    }

    
}
