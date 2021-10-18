package com.mindia.carmind.model;

import java.util.Objects;

class Pregunta{
    private int id;
    private String descripcion;
    private Seccion seccion;


    public Pregunta() {
    }

    public Pregunta(int id, String descripcion, Seccion seccion) {
        this.id = id;
        this.descripcion = descripcion;
        this.seccion = seccion;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Seccion getSeccion() {
        return this.seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Pregunta id(int id) {
        setId(id);
        return this;
    }

    public Pregunta descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public Pregunta seccion(Seccion seccion) {
        setSeccion(seccion);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pregunta)) {
            return false;
        }
        Pregunta pregunta = (Pregunta) o;
        return id == pregunta.id && Objects.equals(descripcion, pregunta.descripcion) && Objects.equals(seccion, pregunta.seccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, seccion);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", seccion='" + getSeccion() + "'" +
            "}";
    }

}
