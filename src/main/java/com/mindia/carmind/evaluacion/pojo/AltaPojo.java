
package com.mindia.carmind.evaluacion.pojo;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vehiculo_id",
    "titulo",
    "fecha_inicio",
    "secciones"
})
@Generated("jsonschema2pojo")
public class AltaPojo {

    @JsonProperty("vehiculo_id")
    private Integer vehiculoId;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("fecha_inicio")
    private String fechaInicio;
    @JsonProperty("secciones")
    private List<AltaSeccionPojo> secciones = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AltaPojo() {
    }

    /**
     * 
     * @param vehiculoId
     * @param fechaInicio
     * @param titulo
     * @param secciones
     */
    public AltaPojo(Integer vehiculoId, String titulo, String fechaInicio, List<AltaSeccionPojo> secciones) {
        super();
        this.vehiculoId = vehiculoId;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.secciones = secciones;
    }

    @JsonProperty("vehiculo_id")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculo_id")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @JsonProperty("titulo")
    public String getTitulo() {
        return titulo;
    }

    @JsonProperty("titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @JsonProperty("fecha_inicio")
    public String getFechaInicio() {
        return fechaInicio;
    }

    @JsonProperty("fecha_inicio")
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @JsonProperty("secciones")
    public List<AltaSeccionPojo> getSecciones() {
        return secciones;
    }

    @JsonProperty("secciones")
    public void setSecciones(List<AltaSeccionPojo> secciones) {
        this.secciones = secciones;
    }

}
