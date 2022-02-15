package com.mindia.carmind.vehiculo.pojo;

import java.time.LocalDate;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Vehiculo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "nombre",
        "en_uso",
        "usuario_en_uso",
        "color",
        "marca",
        "modelo",
        "linea",
        "patente",
        "fecha_service",
        "ultima_evaluacion"
})
@Generated("jsonschema2pojo")
public class VehiculoView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("en_uso")
    private Boolean enUso;
    @JsonProperty("usuario_en_uso")
    private String usuarioEnUso;
    @JsonProperty("color")
    private String color;
    @JsonProperty("marca")
    private String marca;
    @JsonProperty("modelo")
    private String modelo;
    @JsonProperty("linea")
    private String linea;
    @JsonProperty("patente")
    private String patente;
    @JsonProperty("fecha_service")
    private LocalDate fechaService;
    @JsonProperty("ultima_evaluacion")
    private String ultimaEvaluacion;

    /**
     * No args constructor for use in serialization
     *
     */
    public VehiculoView() {
    }

    /**
     *
     * @param marca
     * @param color
     * @param ultimaEvaluacion
     * @param enUso
     * @param id
     * @param fechaService
     * @param nombre
     * @param modelo
     * @param linea
     * @param patente
     */
    public VehiculoView(Integer id, String nombre, Boolean enUso, String color, String marca, String modelo,
            String linea, String patente, LocalDate fechaService, String ultimaEvaluacion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.enUso = enUso;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.patente = patente;
        this.fechaService = fechaService;
        this.ultimaEvaluacion = ultimaEvaluacion;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("en_uso")
    public Boolean getEnUso() {
        return enUso;
    }

    @JsonProperty("en_uso")
    public void setEnUso(Boolean enUso) {
        this.enUso = enUso;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
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

    @JsonProperty("patente")
    public String getPatente() {
        return patente;
    }

    @JsonProperty("patente")
    public void setPatente(String patente) {
        this.patente = patente;
    }

    @JsonProperty("fecha_service")
    public LocalDate getFechaService() {
        return fechaService;
    }

    @JsonProperty("fecha_service")
    public void setFechaService(LocalDate fechaService) {
        this.fechaService = fechaService;
    }

    @JsonProperty("ultima_evaluacion")
    public String getUltimaEvaluacion() {
        return ultimaEvaluacion;
    }

    @JsonProperty("ultima_evaluacion")
    public void setUltimaEvaluacion(String ultimaEvaluacion) {
        this.ultimaEvaluacion = ultimaEvaluacion;
    }

    @JsonProperty("usuario_en_uso")
    public String getUsuarioEnUso() {
        return this.usuarioEnUso;
    }

    @JsonProperty("usuario_en_uso")
    public void setUsuarioEnUso(String usuarioEnUso) {
        this.usuarioEnUso = usuarioEnUso;
    }


    public VehiculoView(Vehiculo v) {
        this(v, false);
    }

    public VehiculoView(Vehiculo v, boolean detalle) {
        id = v.getId();
        nombre = v.getNombre();
        this.enUso = v.getUsuarioIdUsando() != null;
        color = v.getColor();
        
        if (detalle) {
            if(this.enUso){
                usuarioEnUso = v.getUsuario().getNombre() + " " + v.getUsuario().getApellido();
            }
            marca = v.getMarca();
            modelo = v.getModelo();
            linea = v.getLinea();
            patente = v.getPatente();
            fechaService = v.getFechaService();
        }
    }

}
