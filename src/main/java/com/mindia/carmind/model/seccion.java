package com.mindia.carmind.model;

import java.util.Objects;

class Seccion {
    private int id;
    private String nombre, descripcion;


    public Seccion() {
    }

    public Seccion(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Seccion id(int id) {
        setId(id);
        return this;
    }

    public Seccion nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Seccion descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Seccion)) {
            return false;
        }
        Seccion seccion = (Seccion) o;
        return id == seccion.id && Objects.equals(nombre, seccion.nombre) && Objects.equals(descripcion, seccion.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            "}";
    }

}