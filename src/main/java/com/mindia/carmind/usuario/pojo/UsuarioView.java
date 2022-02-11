package com.mindia.carmind.usuario.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Usuario;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "nombre", "empresa", "administrador" })
@Generated("jsonschema2pojo")
public class UsuarioView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("empresa")
    private Integer empresa;
    @JsonProperty("administrador")
    private boolean administrador;

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioView withNombre(String nombre) {
        this.nombre = nombre;
        return this;
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

    public UsuarioView withAdministrador(boolean administrador) {
        this.administrador = administrador;
        return this;
    }

    @JsonProperty("id")
    public Integer getId() {
        return this.id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getAdministrador() {
        return this.administrador;
    }



    public UsuarioView(Usuario u) {
        administrador = u.getAdministrador();
        nombre = u.getNombre();
        empresa = u.getEmpresa();
        id = u.getId();
    }

}
