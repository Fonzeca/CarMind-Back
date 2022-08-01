package com.mindia.carmind.usuario.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nombre", "apellido", "username", "password", "dni", "administrador" })
@Generated("jsonschema2pojo")
public class ModificarPojo {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("username")
    private String username;
    @JsonProperty("dni")
    private String dni;
    @JsonProperty("administrador")
    private Boolean administrador;

    /**
     * No args constructor for use in serialization
     *
     */
    public ModificarPojo() {
    }

    /**
     *
     * @param password
     * @param administrador
     * @param nombre
     * @param dni
     * @param username
     */
    public ModificarPojo(String nombre, String apellido, String username, String password, String dni,
            Boolean administrador) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.dni = dni;
        this.administrador = administrador;
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

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("dni")
    public String getDni() {
        return dni;
    }

    @JsonProperty("dni")
    public void setDni(String dni) {
        this.dni = dni;
    }

    @JsonProperty("administrador")
    public Boolean getAdministrador() {
        return administrador;
    }

    @JsonProperty("administrador")
    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

}