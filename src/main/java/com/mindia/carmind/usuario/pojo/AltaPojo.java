package com.mindia.carmind.usuario.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Empresa;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nombre", "empresa", "administrador" })
@Generated("jsonschema2pojo")
public class AltaPojo {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("empresa")
    private Empresa empresa;
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

    public AltaPojo withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    @JsonProperty("empresa")
    public Empresa getEmpresa() {
        return empresa;
    }

    @JsonProperty("empresa")
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public AltaPojo withEmpresa(Empresa empresa) {
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

    public AltaPojo withAdministrador(boolean administrador) {
        this.administrador = administrador;
        return this;
    }

}
