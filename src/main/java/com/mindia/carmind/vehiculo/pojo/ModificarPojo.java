package com.mindia.carmind.vehiculo.pojo;

import java.util.Date;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "marca", "modelo", "linea", "color", "fecha_service", "ultima_evaluacion" })
@Generated("jsonschema2pojo")
public class ModificarPojo {

    @JsonProperty("id")
    private int id;
    @JsonProperty("marca")
    private String marca;
    @JsonProperty("modelo")
    private String modelo;
    @JsonProperty("linea")
    private String linea;
    @JsonProperty("color")
    private String color;
    @JsonProperty("fecha_service")
    private Date fechaService;
    @JsonProperty("ultima_evaluacion")
    private int ultimaEvaluacion;

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

    @JsonProperty("marca")
    public String getMarca() {
        return marca;
    }

    @JsonProperty("marca")
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public ModificarPojo withMarca(String marca) {
        this.marca = marca;
        return this;
    }

    @JsonProperty("modelo")
    public String getModelo() {
        return modelo;
    }

    @JsonProperty("modelo")
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ModificarPojo withModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    @JsonProperty("linea")
    public String getLinea() {
        return linea;
    }

    @JsonProperty("linea")
    public void setLinea(String linea) {
        this.linea = linea;
    }

    public ModificarPojo withLinea(String linea) {
        this.linea = linea;
        return this;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    public ModificarPojo withColor(String color) {
        this.color = color;
        return this;
    }

    @JsonProperty("fecha_service")
    public Date getFechaService() {
        return fechaService;
    }

    @JsonProperty("fecha_service")
    public void setFechaService(Date fechaService) {
        this.fechaService = fechaService;
    }

    public ModificarPojo withFechaService(Date fechaService) {
        this.fechaService = fechaService;
        return this;
    }

    @JsonProperty("ultima_evaluacion")
    public int getUltimaEvaluacion() {
        return ultimaEvaluacion;
    }

    @JsonProperty("ultima_evaluacion")
    public void setUltimaEvaluacion(int ultimaEvaluacion) {
        this.ultimaEvaluacion = ultimaEvaluacion;
    }

    public ModificarPojo withUltimaEvaluacion(int ultimaEvaluacion) {
        this.ultimaEvaluacion = ultimaEvaluacion;
        return this;
    }

}
