package com.mindia.carmind.model;

import java.util.Objects;

class Vehiculo{
    private int id;
    private String marca, modelo, linea, color;
    private Evaluacion ultima_evaluacion;


    public Vehiculo() {
    }

    public Vehiculo(int id, String marca, String modelo, String linea, String color, Evaluacion ultima_evaluacion) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.color = color;
        this.ultima_evaluacion = ultima_evaluacion;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return this.linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Evaluacion getUltima_evaluacion() {
        return this.ultima_evaluacion;
    }

    public void setUltima_evaluacion(Evaluacion ultima_evaluacion) {
        this.ultima_evaluacion = ultima_evaluacion;
    }

    public Vehiculo id(int id) {
        setId(id);
        return this;
    }

    public Vehiculo marca(String marca) {
        setMarca(marca);
        return this;
    }

    public Vehiculo modelo(String modelo) {
        setModelo(modelo);
        return this;
    }

    public Vehiculo linea(String linea) {
        setLinea(linea);
        return this;
    }

    public Vehiculo color(String color) {
        setColor(color);
        return this;
    }

    public Vehiculo ultima_evaluacion(Evaluacion ultima_evaluacion) {
        setUltima_evaluacion(ultima_evaluacion);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehiculo)) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) o;
        return id == vehiculo.id && Objects.equals(marca, vehiculo.marca) && Objects.equals(modelo, vehiculo.modelo) && Objects.equals(linea, vehiculo.linea) && Objects.equals(color, vehiculo.color) && Objects.equals(ultima_evaluacion, vehiculo.ultima_evaluacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, linea, color, ultima_evaluacion);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", marca='" + getMarca() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", linea='" + getLinea() + "'" +
            ", color='" + getColor() + "'" +
            ", ultima_evaluacion='" + getUltima_evaluacion() + "'" +
            "}";
    }
    
}