package com.mindia.carmind.usuario.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Usuario;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "nombre","apellido","username","dni", "empresa", "administrador","fecha_alta" })
@Generated("jsonschema2pojo")
public class UsuarioView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("username")
    private String username;
    @JsonProperty("dni")
    private String dni;
    @JsonProperty("empresa")
    private Integer empresa;
    @JsonProperty("administrador")
    private boolean administrador;
    @JsonProperty("fecha_alta")
    private String fechaAlta;

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("empresa")
    public Integer getEmpresa() {
        return empresa;
    }

    @JsonProperty("empresa")
    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    @JsonProperty("administrador")
    public boolean isAdministrador() {
        return administrador;
    }

    @JsonProperty("administrador")
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @JsonProperty("id")
    public Integer getId() {
        return this.id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("administrador")
    public boolean getAdministrador() {
        return this.administrador;
    }

    @JsonProperty("apellido")
    public String getApellido() {
        return this.apellido;
    }

    @JsonProperty("apellido")
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @JsonProperty("username")
    public String getUsername() {
        return this.username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("dni")
    public String getDni() {
        return this.dni;
    }

    @JsonProperty("dni")
    public void setDni(String dni) {
        this.dni = dni;
    }

    @JsonProperty("fecha_alta")
    public String getFechaAlta() {
        return this.fechaAlta;
    }

    @JsonProperty("fecha_alta")
    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }





    public UsuarioView(Usuario u) {
        administrador = u.getAdministrador();
        nombre = u.getNombre();
        empresa = u.getEmpresa();
        id = u.getId();
        dni = u.getDni();
        username = u.getUsername();
        apellido = u.getApellido();
    }

}
