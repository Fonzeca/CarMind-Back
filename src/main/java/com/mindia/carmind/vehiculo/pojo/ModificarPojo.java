package com.mindia.carmind.vehiculo.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "marca", "modelo", "linea", "color","tipo","kilometraje","patente","imei" })
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
    private Integer kilometraje;
    @JsonProperty("patente")
    private String patente;
    @JsonProperty("imei")
    private String imei;

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
    public Integer getKilometraje() {
        return this.kilometraje;
    }

    @JsonProperty("kilometraje")
    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    @JsonProperty("patente")
    public String getPatente() {
        return this.patente;
    }

    @JsonProperty("patente")
    public void setPatente(String patente) {
        this.patente = patente;
    }

    @JsonProperty("imei")
    public String getImei() {
        return this.imei;
    }

    @JsonProperty("imei")
    public void setImei(String imei) {
        this.imei = imei;
    }

    public boolean validate(){

        if(this.patente != null) this.patente = this.patente.trim();
        
        if(this.marca != null) this.marca.trim();
        
        if(this.modelo != null) this.modelo = this.modelo.trim();

        //Valida si la linea no esta vacia o es mayor a 10 caracteres
        if(this.linea != null && this.linea.length() > 10){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato linea incorrecto");
        }

        return true;
    }

}
