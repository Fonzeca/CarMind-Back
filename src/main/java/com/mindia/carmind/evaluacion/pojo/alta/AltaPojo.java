
package com.mindia.carmind.evaluacion.pojo.alta;

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
    "preguntas"
})
@Generated("jsonschema2pojo")
public class AltaPojo {

    @JsonProperty("vehiculo_id")
    private Integer vehiculoId;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("fecha_inicio")
    private String fechaInicio;
    @JsonProperty("preguntas")
    private List<AltaPreguntaPojo> preguntas = null;

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
     * @param preguntas
     */
    public AltaPojo(Integer vehiculoId, String titulo, String fechaInicio, List<AltaPreguntaPojo> preguntas) {
        super();
        this.vehiculoId = vehiculoId;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.preguntas = preguntas;
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

    @JsonProperty("preguntas")
    public List<AltaPreguntaPojo> getPreguntas() {
        return this.preguntas;
    }

    @JsonProperty("preguntas")
    public void setPreguntas(List<AltaPreguntaPojo> preguntas) {
        this.preguntas = preguntas;
    }

}
