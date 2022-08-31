package com.mindia.carmind.vehiculo.pojo;

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
        "patente",
        "tipo",
        "imei",
        "estado_motor",
        "latitud",
        "longitud"
})
@Generated("jsonschema2pojo")
public class VehiculoPositionView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("en_uso")
    private Boolean enUso;
    @JsonProperty("usuario_en_uso")
    private String usuarioEnUso;
    @JsonProperty("patente")
    private String patente;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("imei")
    private String     imei ;
    @JsonProperty("engine_status")
    private Boolean     estado_motor ;
    @JsonProperty("latitud")
    private Double     latitud ;
    @JsonProperty("longitud")
    private Double     longitud ;


    /**
     * No args constructor for use in serialization
     *
     */
    public VehiculoPositionView() {
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

    @JsonProperty("patente")
    public String getPatente() {
        return patente;
    }

    @JsonProperty("patente")
    public void setPatente(String patente) {
        this.patente = patente;
    }

    @JsonProperty("usuario_en_uso")
    public String getUsuarioEnUso() {
        return this.usuarioEnUso;
    }

    @JsonProperty("usuario_en_uso")
    public void setUsuarioEnUso(String usuarioEnUso) {
        this.usuarioEnUso = usuarioEnUso;
    }

    @JsonProperty("tipo")
    public String getTipo() {
        return this.tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonProperty("imei")
    public String getImei(){
        return this.imei;
    }

    @JsonProperty("imei")
    public void setImei(String imei){
        this.imei = imei;
    }

    @JsonProperty("estado_motor")
    public Boolean getEstadoMotor(){
        return this.estado_motor;
    }

    @JsonProperty("estado_motor")
    public void setEstadoMotor(Boolean estado_motor){
        this.estado_motor = estado_motor;
    }

    @JsonProperty("latitud")
    public Double getLatitud(){
        return this.latitud;
    }

    @JsonProperty("latitud")
    public void setLatitud(Double latitud){
        this.latitud = latitud;
    }

    @JsonProperty("longitud")
    public Double getLongitud(){
        return this.longitud;
    }

    @JsonProperty("longitud")
    public void setLongitud(Double longitud){
        this.longitud = longitud;
    }

    public void setVehiculo(Vehiculo v) {
        id = v.getId();
        nombre = v.getNombre();
        enUso = v.getUsuarioIdUsando() != null;
        if(enUso){
            usuarioEnUso = v.getUsuario().getNombre() + " " + v.getUsuario().getApellido();
        }
        patente = v.getPatente();
        tipo = v.getTipoVehiculo();
        imei = v.getImei();
    }

}
