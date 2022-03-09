package com.mindia.carmind.notificacion.pojo;

import java.time.format.DateTimeFormatter;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Notificaciones;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "fecha_creacion",
        "titulo",
        "texto"
})
@Generated("jsonschema2pojo")
public class NotificacionPojo {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("fecha_creacion")
    private String fechaCreacion;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("texto")
    private String texto;

    /**
     * No args constructor for use in serialization
     *
     */
    public NotificacionPojo() {
    }

    /**
     *
     * @param texto
     * @param fechaCreacion
     * @param titulo
     * @param id
     */
    public NotificacionPojo(Integer id, String fechaCreacion, String titulo, String texto) {
        super();
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.titulo = titulo;
        this.texto = texto;
    }

    public NotificacionPojo(Notificaciones notificacion) {
        super();
        this.id = notificacion.getId();
        this.fechaCreacion = notificacion.getFechaCreacion().format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
        this.titulo = notificacion.getTitulo();
        this.texto = notificacion.getTexto();
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("fecha_creacion")
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    @JsonProperty("fecha_creacion")
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @JsonProperty("titulo")
    public String getTitulo() {
        return titulo;
    }

    @JsonProperty("titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @JsonProperty("texto")
    public String getTexto() {
        return texto;
    }

    @JsonProperty("texto")
    public void setTexto(String texto) {
        this.texto = texto;
    }



}