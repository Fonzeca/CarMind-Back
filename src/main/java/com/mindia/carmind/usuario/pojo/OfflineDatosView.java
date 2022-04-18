package com.mindia.carmind.usuario.pojo;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.evaluacion.pojo.LogEvaluacionView;
import com.mindia.carmind.evaluacion.pojo.view.EvaluacionView;
import com.mindia.carmind.vehiculo.pojo.VehiculoView;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idVehiculoActual",
        "loggedUser",
        "vehiculos",
        "evaluaciones",
        "logEvaluacion"
})
@Generated("jsonschema2pojo")
public class OfflineDatosView {

    @JsonProperty("loggedUser")
    private UsuarioView loggedUser;
    @JsonProperty("vehiculos")
    private List<VehiculoView> vehiculos = null;
    @JsonProperty("evaluaciones")
    private List<EvaluacionView> evaluaciones = null;
    @JsonProperty("logEvaluacion")
    private List<LogEvaluacionView> logEvaluacion = null;
    @JsonProperty("idVehiculoActual")
    private int idVehiculoActual;

    /**
     * No args constructor for use in serialization
     *
     */
    public OfflineDatosView() {
    }

    /**
     *
     * @param logEvaluacion
     * @param loggedUser
     * @param vehiculos
     * @param evaluaciones
     */
    public OfflineDatosView(UsuarioView loggedUser, List<VehiculoView> vehiculos, List<EvaluacionView> evaluaciones,
            List<LogEvaluacionView> logEvaluacion) {
        super();
        this.loggedUser = loggedUser;
        this.vehiculos = vehiculos;
        this.evaluaciones = evaluaciones;
        this.logEvaluacion = logEvaluacion;
    }

    @JsonProperty("loggedUser")
    public UsuarioView getLoggedUser() {
        return loggedUser;
    }

    @JsonProperty("loggedUser")
    public void setLoggedUser(UsuarioView loggedUser) {
        this.loggedUser = loggedUser;
    }

    @JsonProperty("vehiculos")
    public List<VehiculoView> getVehiculos() {
        return vehiculos;
    }

    @JsonProperty("vehiculos")
    public void setVehiculos(List<VehiculoView> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @JsonProperty("evaluaciones")
    public List<EvaluacionView> getEvaluaciones() {
        return evaluaciones;
    }

    @JsonProperty("evaluaciones")
    public void setEvaluaciones(List<EvaluacionView> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    @JsonProperty("logEvaluacion")
    public List<LogEvaluacionView> getLogEvaluacion() {
        return logEvaluacion;
    }

    @JsonProperty("logEvaluacion")
    public void setLogEvaluacion(List<LogEvaluacionView> logEvaluacion) {
        this.logEvaluacion = logEvaluacion;
    }

    public int getIdVehiculoActual() {
        return this.idVehiculoActual;
    }

    public void setIdVehiculoActual(int idVehiculoActual) {
        this.idVehiculoActual = idVehiculoActual;
    }

}