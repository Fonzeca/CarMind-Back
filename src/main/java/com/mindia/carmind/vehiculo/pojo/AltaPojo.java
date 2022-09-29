package com.mindia.carmind.vehiculo.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@JsonPropertyOrder({ "nombre", "patente", "marca", "modelo", "linea", "tipo", "kilometraje" })
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
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("kilometraje")
    private Integer kilometraje;

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

    @JsonProperty("kilometraje")
    public Integer getKilometraje(){
        return this.kilometraje;
    }

    @JsonProperty("kilometraje")
    public void setKilometraje(Integer kilometraje){
        this.kilometraje = kilometraje;
    }

    public boolean validate() {

        this.modelo = this.modelo.trim();
        this.patente = this.patente.trim();

        if(this.marca != null){
            this.marca.trim();
        }

        // Valida si la linea no esta vacia o es mayor a 10 caracteres
        if (this.linea == null || this.linea.isBlank() || this.linea.length() > 10) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato linea incorrecto");
        }

        if(this.nombre == null || this.nombre.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nombre vacio");
        }
        
        if(this.tipo == null || this.tipo.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo vacio");
        }

        return true;
    }

}
