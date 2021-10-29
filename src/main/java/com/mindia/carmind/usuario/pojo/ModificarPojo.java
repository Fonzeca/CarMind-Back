package com.mindia.carmind.usuario.pojo;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Empresas;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "nombre", "empresa", "administrador" })
@Generated("jsonschema2pojo")
public class ModificarPojo {

    @JsonProperty("id")
    private int id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("empresa")
    private Empresas empresa;
    @JsonProperty("administrador")
    private boolean administrador;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public ModificarPojo withId(int id) {
        this.id = id;
        return this;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ModificarPojo withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    @JsonProperty("empresa")
    public Empresas getEmpresa() {
        return empresa;
    }

    @JsonProperty("empresa")
    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    public ModificarPojo withEmpresa(Empresas empresa) {
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

    public ModificarPojo withAdministrador(boolean administrador) {
        this.administrador = administrador;
        return this;
    }

}