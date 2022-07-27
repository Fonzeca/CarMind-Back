package com.mindia.carmind.notificacion.pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "email",
    "nombre",
    "preguntas",
    "respuestas"
})

public class NotificacionFailureEvaluacionView {
    @JsonProperty("email")
    private String email;
    @JsonProperty("evaluacionDateTime")
    private LocalDateTime evaluacionDateTime;
    @JsonProperty("nombreUsuario")
    private String nombre;
    @JsonProperty("apellidoUsuario")
    private String apellido;
    @JsonProperty("nombreVehiculo")
    private  String nombreVehiculo;
    @JsonProperty("idLog")
    private  int idLog;
    @JsonProperty("idVehiculo")
    private  int idVehiculo;


    public NotificacionFailureEvaluacionView() {
    }

    public NotificacionFailureEvaluacionView(String nombre,  String apellido, String nombreVehiculo, int idLog, int idVehiculo) {
        super();
        this.nombre = nombre;
        this.evaluacionDateTime = LocalDateTime.now();
        this.apellido = apellido;
        this.nombreVehiculo = nombreVehiculo;
        this.idLog = idLog;
        this.idVehiculo = idVehiculo;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }
}
