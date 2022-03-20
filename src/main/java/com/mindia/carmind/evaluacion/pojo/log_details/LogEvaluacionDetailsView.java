
package com.mindia.carmind.evaluacion.pojo.log_details;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.LogEvaluacion;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evaluacion_id",
    "log_id",
    "evaluacion_nombre",
    "fecha_relizacion",
    "usuario_id",
    "usuario_nombre",
    "vehiculo_id",
    "vehiculo_nombre",
    "secciones"
})
@Generated("jsonschema2pojo")
public class LogEvaluacionDetailsView {

    @JsonProperty("evaluacion_id")
    private Integer evaluacionId;
    @JsonProperty("log_id")
    private Integer logId;
    @JsonProperty("evaluacion_nombre")
    private String evaluacionNombre;
    @JsonProperty("fecha_relizacion")
    private String fechaRelizacion;
    @JsonProperty("usuario_id")
    private Integer usuarioId;
    @JsonProperty("usuario_nombre")
    private String usuarioNombre;
    @JsonProperty("vehiculo_id")
    private Integer vehiculoId;
    @JsonProperty("vehiculo_nombre")
    private String vehiculoNombre;
    @JsonProperty("secciones")
    private List<LogSeccionDetailsView> secciones = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LogEvaluacionDetailsView() {
    }

    /**
     * 
     * @param vehiculoNombre
     * @param vehiculoId
     * @param logId
     * @param fechaRelizacion
     * @param evaluacionId
     * @param usuarioId
     * @param usuarioNombre
     * @param secciones
     * @param evaluacionNombre
     */
    public LogEvaluacionDetailsView(Integer evaluacionId, Integer logId, String evaluacionNombre, String fechaRelizacion, Integer usuarioId, String usuarioNombre, Integer vehiculoId, String vehiculoNombre, List<LogSeccionDetailsView> secciones) {
        super();
        this.evaluacionId = evaluacionId;
        this.logId = logId;
        this.evaluacionNombre = evaluacionNombre;
        this.fechaRelizacion = fechaRelizacion;
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.vehiculoId = vehiculoId;
        this.vehiculoNombre = vehiculoNombre;
        this.secciones = secciones;
    }

    public LogEvaluacionDetailsView(LogEvaluacion log) {
        super();
        this.evaluacionId = log.getEvaluacionId();
        this.logId = log.getId();
        this.evaluacionNombre = log.getEvaluacion().getNombre();
        this.fechaRelizacion = log.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/YYYY mm:HH"));
        this.usuarioId = log.getUsuarioId();
        this.usuarioNombre = log.getUsuario().getNombre() + log.getUsuario().getApellido();
        this.vehiculoId = log.getVehiculoId();
        this.vehiculoNombre = log.getVehiculo().getNombre();

        var seccionesEva = log.getEvaluacion().getListOfSeccion();
        var logsPregunta = log.getListOfLogPregunta();
        this.secciones = seccionesEva.stream().map(x -> new LogSeccionDetailsView(x, logsPregunta)).collect(Collectors.toList());
    }

    @JsonProperty("evaluacion_id")
    public Integer getEvaluacionId() {
        return evaluacionId;
    }

    @JsonProperty("evaluacion_id")
    public void setEvaluacionId(Integer evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    @JsonProperty("log_id")
    public Integer getLogId() {
        return logId;
    }

    @JsonProperty("log_id")
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    @JsonProperty("evaluacion_nombre")
    public String getEvaluacionNombre() {
        return evaluacionNombre;
    }

    @JsonProperty("evaluacion_nombre")
    public void setEvaluacionNombre(String evaluacionNombre) {
        this.evaluacionNombre = evaluacionNombre;
    }

    @JsonProperty("fecha_relizacion")
    public String getFechaRelizacion() {
        return fechaRelizacion;
    }

    @JsonProperty("fecha_relizacion")
    public void setFechaRelizacion(String fechaRelizacion) {
        this.fechaRelizacion = fechaRelizacion;
    }

    @JsonProperty("usuario_id")
    public Integer getUsuarioId() {
        return usuarioId;
    }

    @JsonProperty("usuario_id")
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @JsonProperty("usuario_nombre")
    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    @JsonProperty("usuario_nombre")
    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    @JsonProperty("vehiculo_id")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculo_id")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @JsonProperty("vehiculo_nombre")
    public String getVehiculoNombre() {
        return vehiculoNombre;
    }

    @JsonProperty("vehiculo_nombre")
    public void setVehiculoNombre(String vehiculoNombre) {
        this.vehiculoNombre = vehiculoNombre;
    }

    @JsonProperty("secciones")
    public List<LogSeccionDetailsView> getSecciones() {
        return secciones;
    }

    @JsonProperty("secciones")
    public void setSecciones(List<LogSeccionDetailsView> secciones) {
        this.secciones = secciones;
    }

}
