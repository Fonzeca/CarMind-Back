package com.mindia.carmind.model;

import java.util.Objects;

class Usuario{
    private int id;
    private String nombre;
    private Empresa empresa;
    private boolean administrador;


    public Usuario() {
    }

    public Usuario(int id, String nombre, Empresa empresa, boolean administrador) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
        this.administrador = administrador;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean isAdministrador() {
        return this.administrador;
    }

    public boolean getAdministrador() {
        return this.administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public Usuario id(int id) {
        setId(id);
        return this;
    }

    public Usuario nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Usuario empresa(Empresa empresa) {
        setEmpresa(empresa);
        return this;
    }

    public Usuario administrador(boolean administrador) {
        setAdministrador(administrador);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(nombre, usuario.nombre) && Objects.equals(empresa, usuario.empresa) && administrador == usuario.administrador;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, empresa, administrador);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", empresa='" + getEmpresa() + "'" +
            ", administrador='" + isAdministrador() + "'" +
            "}";
    }

}