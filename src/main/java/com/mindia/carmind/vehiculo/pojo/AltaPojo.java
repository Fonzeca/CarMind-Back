package com.mindia.carmind.vehiculo.pojo;

import java.time.LocalDate;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@JsonPropertyOrder({ "nombre", "patente", "marca", "modelo", "linea", "color", "tipo", "fecha_service" })
@Generated("jsonschema2pojo")
public class AltaPojo {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("patente")
    private String patente;
    @JsonProperty("marca")
    private String marca;
    @JsonProperty("modelo")
    private String modelo;
    @JsonProperty("linea")
    private String linea;
    @JsonProperty("color")
    private String color;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("fecha_service")
    private LocalDate fechaService;

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
    public LocalDate getFechaService() {
        return fechaService;
    }

    @JsonProperty("fecha_service")
    public void setFechaService(LocalDate fechaService) {
        this.fechaService = fechaService;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return this.nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("patente")
    public String getPatente() {
        return this.patente;
    }

    @JsonProperty("patente")
    public void setPatente(String patente) {
        this.patente = patente;
    }

    @JsonProperty("tipo")
    public String getTipo() {
        return this.tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean validate() {

        this.modelo = this.modelo.trim();
        this.marca = this.marca.trim();
        /*
         * //Busco si verdaderamente existe la marca que se quiere dar de alta
         * MarcaPojo marcaPojo = MarcaPojo.buscarMarca(this.marca);
         * 
         * if(this.marca == null || this.marca.isBlank()
         * || marcaPojo == null){
         * throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca erronea");
         * }
         * this.marca = marcaPojo.getMarca();
         * 
         * //Se busca si verdaderamente existe el modelo que se quiere dar de alta
         * ModeloPojo modeloPojo =
         * ModeloPojo.buscarModelo(marcaPojo.getModelos().stream(), this.modelo);
         * 
         * if(this.modelo == null || this.modelo.isBlank()
         * || modeloPojo == null){
         * throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modelo erroneo");
         * }
         * this.modelo = modeloPojo.getModelo();
         */
        // Valida si la linea no esta vacia o es mayor a 10 caracteres
        if (this.linea == null || this.linea.isBlank() || this.linea.length() > 10) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato linea incorrecto");
        }

        return true;
    }

}
