package com.mindia.carmind.vehiculo.pojo;

import java.util.Date;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Vehiculo;

@JsonPropertyOrder({ "id","marca", "modelo", "linea", "color", "fecha_service", "ultima_evaluacion" })
@Generated("jsonschema2pojo")
public class VehiculoView {

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
    private Integer ultimaEvaluacion;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("marca")
    public String getMarca() {
        return marca;
    }

    @JsonProperty("marca")
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @JsonProperty("modelo")
    public String getModelo() {
        return modelo;
    }

    @JsonProperty("modelo")
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @JsonProperty("linea")
    public String getLinea() {
        return linea;
    }

    @JsonProperty("linea")
    public void setLinea(String linea) {
        this.linea = linea;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("fecha_service")
    public Date getFechaService() {
        return fechaService;
    }

    @JsonProperty("fecha_service")
    public void setFechaService(Date fechaService) {
        this.fechaService = fechaService;
    }

    @JsonProperty("ultima_evaluacion")
    public Integer getUltimaEvaluacion() {
        return ultimaEvaluacion;
    }

    @JsonProperty("ultima_evaluacion")
    public void setUltimaEvaluacion(Integer ultimaEvaluacion) {
        this.ultimaEvaluacion = ultimaEvaluacion;
    }

    public VehiculoView(Vehiculo v) {
        id = v.getId();
        marca = v.getMarca();
        color = v.getColor();
        modelo = v.getModelo();
        linea = v.getLinea();
        fechaService = v.getFechaService();
    }

}
