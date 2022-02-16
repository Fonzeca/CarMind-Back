package com.mindia.carmind.evaluacion.pojo;

import java.time.format.DateTimeFormatter;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.LogEvaluacion;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "log_id",
        "evaluacion_id",
        "nombre_evaluacion",
        "fecha",
        "vehiculo_id",
        "nombre_vehiculo",
        "usuario_id",
        "nombre_usuario",
        "apellido_usuario"
})
@Generated("jsonschema2pojo")
public class LogEvaluacionView {

    @JsonProperty("log_id")
    private Integer logId;
    @JsonProperty("evaluacion_id")
    private Integer evaluacionId;
    @JsonProperty("nombre_evaluacion")
    private String nombreEvaluacion;
    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("vehiculo_id")
    private Integer vehiculoId;
    @JsonProperty("nombre_vehiculo")
    private String nombreVehiculo;
    @JsonProperty("usuario_id")
    private Integer usuarioId;
    @JsonProperty("nombre_usuario")
    private String nombreUsuario;
    @JsonProperty("apellido_usuario")
    private String apellidoUsuario;

    /**
     * No args constructor for use in serialization
     *
     */
    public LogEvaluacionView() {
    }

    /**
     *
     * @param fecha
     * @param nombreEvaluacion
     * @param apellidoUsuario
     * @param vehiculoId
     * @param nombreVehiculo
     * @param logId
     * @param nombreUsuario
     * @param evaluacionId
     * @param usuarioId
     */
    public LogEvaluacionView(Integer logId, Integer evaluacionId, String nombreEvaluacion, String fecha,
            Integer vehiculoId, String nombreVehiculo, Integer usuarioId, String nombreUsuario,
            String apellidoUsuario) {
        super();
        this.logId = logId;
        this.evaluacionId = evaluacionId;
        this.nombreEvaluacion = nombreEvaluacion;
        this.fecha = fecha;
        this.vehiculoId = vehiculoId;
        this.nombreVehiculo = nombreVehiculo;
        this.usuarioId = usuarioId;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
    }

    @JsonProperty("log_id")
    public Integer getLogId() {
        return logId;
    }

    @JsonProperty("log_id")
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    @JsonProperty("evaluacion_id")
    public Integer getEvaluacionId() {
        return evaluacionId;
    }

    @JsonProperty("evaluacion_id")
    public void setEvaluacionId(Integer evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    @JsonProperty("nombre_evaluacion")
    public String getNombreEvaluacion() {
        return nombreEvaluacion;
    }

    @JsonProperty("nombre_evaluacion")
    public void setNombreEvaluacion(String nombreEvaluacion) {
        this.nombreEvaluacion = nombreEvaluacion;
    }

    @JsonProperty("fecha")
    public String getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @JsonProperty("vehiculo_id")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculo_id")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @JsonProperty("nombre_vehiculo")
    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    @JsonProperty("nombre_vehiculo")
    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }

    @JsonProperty("usuario_id")
    public Integer getUsuarioId() {
        return usuarioId;
    }

    @JsonProperty("usuario_id")
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @JsonProperty("nombre_usuario")
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    @JsonProperty("nombre_usuario")
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @JsonProperty("apellido_usuario")
    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    @JsonProperty("apellido_usuario")
    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public LogEvaluacionView(LogEvaluacion log){
        this.logId = log.getId();
        this.evaluacionId = log.getEvaluacionId();
        this.nombreEvaluacion = log.getEvaluacion().getNombre();
        this.fecha = log.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss"));
        this.vehiculoId = log.getVehiculoId();
        this.nombreVehiculo = log.getVehiculo().getNombre();
        this.usuarioId = log.getUsuarioId();
        this.nombreUsuario = log.getUsuario().getNombre();
        this.apellidoUsuario = log.getUsuario().getApellido();
    }

}