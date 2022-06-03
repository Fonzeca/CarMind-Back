package com.mindia.carmind.vehiculo.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "marca", "modelo", "linea", "color","tipo","kilometraje" })
@Generated("jsonschema2pojo")
public class ModificarPojo {

    @JsonProperty("id")
    private int id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("marca")
    private String marca;
    @JsonProperty("modelo")
    private String modelo;
    @JsonProperty("linea")
    private String linea;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("kilometraje")
    private String kilometraje;

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

    @JsonProperty("tipo")
    public String getTipo() {
        return this.tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return this.nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("kilometraje")
    public String getKilometraje() {
        return this.kilometraje;
    }

    @JsonProperty("kilometraje")
    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public boolean validate(){

        this.marca = this.marca.trim();
        this.modelo = this.modelo.trim();

        if(this.marca == null || this.marca.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca vacio");
        }

        //Se busca si verdaderamente existe el modelo que se quiere dar de alta
        if(this.modelo == null || this.modelo.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modelo vacio");
        }

        //Valida si la linea no esta vacia o es mayor a 10 caracteres
        if(this.linea == null || this.linea.isBlank() || this.linea.length() > 10){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato linea incorrecto");
        }

        return true;
    }

}
