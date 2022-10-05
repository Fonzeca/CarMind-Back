package com.mindia.carmind.notificacion.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "email",
        "nombre",
        "apellido",
        "vehiculo_nombre",
        "log_id",
        "vehiculo_id"
})
@Generated("jsonschema2pojo")
public class TestRabbitMessage {

    @JsonProperty("email")
    private String email;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("vehiculo_nombre")
    private String vehiculoNombre;
    @JsonProperty("log_id")
    private Integer logId;
    @JsonProperty("vehiculo_id")
    private Integer vehiculoId;

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("apellido")
    public String getApellido() {
        return apellido;
    }

    @JsonProperty("apellido")
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @JsonProperty("vehiculo_nombre")
    public String getVehiculoNombre() {
        return vehiculoNombre;
    }

    @JsonProperty("vehiculo_nombre")
    public void setVehiculoNombre(String vehiculoNombre) {
        this.vehiculoNombre = vehiculoNombre;
    }

    @JsonProperty("log_id")
    public Integer getLogId() {
        return logId;
    }

    @JsonProperty("log_id")
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    @JsonProperty("vehiculo_id")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculo_id")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TestRabbitMessage.class.getName()).append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null) ? "<null>" : this.email));
        sb.append(',');
        sb.append("nombre");
        sb.append('=');
        sb.append(((this.nombre == null) ? "<null>" : this.nombre));
        sb.append(',');
        sb.append("apellido");
        sb.append('=');
        sb.append(((this.apellido == null) ? "<null>" : this.apellido));
        sb.append(',');
        sb.append("vehiculoNombre");
        sb.append('=');
        sb.append(((this.vehiculoNombre == null) ? "<null>" : this.vehiculoNombre));
        sb.append(',');
        sb.append("logId");
        sb.append('=');
        sb.append(((this.logId == null) ? "<null>" : this.logId));
        sb.append(',');
        sb.append("vehiculoId");
        sb.append('=');
        sb.append(((this.vehiculoId == null) ? "<null>" : this.vehiculoId));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}