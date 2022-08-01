package com.mindia.carmind.notificacion.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "email",
    "nombre",
    "evaluacionDateTime",
    "nombreUsuario",
    "apellidoUsuario",
    "nombreVehiculo",
    "idLog",
    "idVehiculo"
})

public class NotificacionFailureEvaluacionView {
    @JsonProperty("email")
    private String email;
    @JsonProperty("nombre")
    private  String nombre;
    @JsonProperty("evaluacionDateTime")
    private String evaluacionDateTime;
    @JsonProperty("nombreUsuario")
    private String nombreUsuario;
    @JsonProperty("apellidoUsuario")
    private String apellidoUsuario;
    @JsonProperty("nombreVehiculo")
    private  String nombreVehiculo;
    @JsonProperty("idLog")
    private  int idLog;
    @JsonProperty("idVehiculo")
    private  int idVehiculo;


    public NotificacionFailureEvaluacionView() {
    }

    public NotificacionFailureEvaluacionView(String nombreUsuario,  String apellidoUsuario, String nombreVehiculo, int idLog, int idVehiculo, String evaluacionDateTime) {
        super();
        this.nombreUsuario = nombreUsuario;
        this.evaluacionDateTime = evaluacionDateTime;
        this.apellidoUsuario = apellidoUsuario;
        this.nombreVehiculo = nombreVehiculo;
        this.idLog = idLog;
        this.idVehiculo = idVehiculo;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
