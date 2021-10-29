package com.mindia.carmind.usuario.pojo;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Usuarios;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nombre", "empresa", "administrador" })
@Generated("jsonschema2pojo")
public class UsuarioView {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("empresa")
    private String empresa;
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
    public String getEmpresa() {
        return empresa;
    }

    @JsonProperty("empresa")
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public UsuarioView withEmpresa(String empresa) {
        this.empresa = empresa;
        return this;
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

    public UsuarioView(Usuarios u) {
        administrador = u.getAdministrador();
        nombre = u.getNombre();
        empresa = u.getEmpresas().getNombre();
    }

}
