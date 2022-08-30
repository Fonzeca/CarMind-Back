package com.mindia.carmind.vehiculo.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Vehiculo;
import com.mindia.carmind.evaluacion.pojo.view.EvaluacionLiteView;

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
        "averiado",
        "ultima_evaluacion",
        "pendientes",
        "kilometraje",
        "imei"
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
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("fecha_service")
    private LocalDate fechaService;
    @JsonProperty("averiado")
    private Boolean averiado;
    @JsonProperty("ultima_evaluacion")
    private String ultimaEvaluacion;
    @JsonProperty("pendientes")
    private List<EvaluacionLiteView> pendientes;
    @JsonProperty("kilometraje")
    private Integer     kilometraje ;
    @JsonProperty("imei")
    private String     imei ;


    /**
     * No args constructor for use in serialization
     *
     */
    public VehiculoView() {
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

    @JsonProperty("pendientes")
    public List<EvaluacionLiteView> getPendientes() {
        return this.pendientes;
    }

    @JsonProperty("pendientes")
    public void setPendientes(List<EvaluacionLiteView> pendientes) {
        this.pendientes = pendientes;
    }

    @JsonProperty("tipo")
    public String getTipo() {
        return this.tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonProperty("averiado")
    public Boolean getAveriado() {
        return this.averiado;
    }

    @JsonProperty("averiado")
    public void setAveriado(Boolean averiado) {
        this.averiado = averiado;
    }

    @JsonProperty("kilometraje")
    public Integer getKilometraje(){
        return this.kilometraje;
    }

    @JsonProperty("kilometraje")
    public void setKilometraje(Integer kilometraje){
        this.kilometraje = kilometraje;
    }

    @JsonProperty("imei")
    public String getImei(){
        return this.imei;
    }

    @JsonProperty("imei")
    public void setImei(String imei){
        this.imei = imei;
    }

    public VehiculoView(Vehiculo v) {
        this(v, false);
    }

    public VehiculoView(Vehiculo v, boolean detalle) {
        id = v.getId();
        nombre = v.getNombre();
        this.enUso = v.getUsuarioIdUsando() != null;
        this.tipo = v.getTipoVehiculo();
        this.averiado = v.isAveriado();
        this.kilometraje = v.getKilometraje();
        this.imei = v.getImei();
        
        if (detalle) {
            if(this.enUso){
                usuarioEnUso = v.getUsuario().getNombre() + " " + v.getUsuario().getApellido();
            }
            marca = v.getMarca();
            modelo = v.getModelo();
            linea = v.getLinea();
            patente = v.getPatente();
        }
    }

}
