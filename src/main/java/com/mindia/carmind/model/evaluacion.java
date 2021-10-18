package com.mindia.carmind.model;

import java.util.Objects;

class Evaluacion{
    private int id;
    private String identificador;


    public Evaluacion() {
    }

    public Evaluacion(int id, String identificador) {
        this.id = id;
        this.identificador = identificador;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Evaluacion id(int id) {
        setId(id);
        return this;
    }

    public Evaluacion identificador(String identificador) {
        setIdentificador(identificador);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Evaluacion)) {
            return false;
        }
        Evaluacion evaluacion = (Evaluacion) o;
        return id == evaluacion.id && Objects.equals(identificador, evaluacion.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identificador);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", identificador='" + getIdentificador() + "'" +
            "}";
    }

}