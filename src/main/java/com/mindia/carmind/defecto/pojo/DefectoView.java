package com.mindia.carmind.defecto.pojo;

import java.time.LocalDateTime;

import javax.annotation.Generated;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Defecto;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "log_pregunta_id",
        "nombre_ape_usuario",
        "fecha_creacion",
        "vehiculo",
        "id_usuario",
        "prioridad",
        "estado"
})
@Generated("jsonschema2pojo")
public class DefectoView {
    
    @JsonProperty("id")
    private int        id ;

    //--- ENTITY DATA FIELDS 
    @JsonProperty("log_pregunta_id")
    private int        logPreguntaId ;

    @JsonProperty("nombre_ape_usuario")
    private String     nombreApeUsuario ;

    @JsonProperty("fecha_creacion")
    private LocalDateTime fechaCreacion ;

    @JsonProperty("vehiculo")
    private String        vehiculo ;

    @JsonProperty("id_usuario")
    private Integer    idUsuario ;

    @JsonProperty("prioridad")
    private Integer       prioridad ;

    @JsonProperty("estado")
    private String     estado ;

        /**
     * No args constructor for use in serialization
     *
     */
    public DefectoView() {
    }

    @JsonProperty("id")
    public void setId( int id ) {
        this.id = id ;
    }
    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    @JsonProperty("log_pregunta_id")
    public void setLogPreguntaId( int logPreguntaId ) {
        this.logPreguntaId = logPreguntaId ;
    }
    @JsonProperty("log_pregunta_id")
    public int getLogPreguntaId() {
        return this.logPreguntaId;
    }

    @JsonProperty("nombre_ape_usuario")
    public void setNombreApeUsuario( String nombreApeUsuario ) {
        this.nombreApeUsuario = nombreApeUsuario ;
    }
    @JsonProperty("nombre_ape_usuario")
    public String getNombreApeUsuario() {
        return this.nombreApeUsuario;
    }

    @JsonProperty("fecha_creacion")
    public void setFechaCreacion( LocalDateTime fechaCreacion ) {
        this.fechaCreacion = fechaCreacion ;
    }
    @JsonProperty("fecha_creacion")
    public LocalDateTime getFechaCreacion() {
        return this.fechaCreacion;
    }

    @JsonProperty("vehiculo")
    public void setVehiculo( String vehiculo ) {
        this.vehiculo = vehiculo ;
    }
    @JsonProperty("vehiculo")
    public String getVehiculo() {
        return this.vehiculo;
    }

    @JsonProperty("id_usuario")
    public void setIdUsuario( Integer idUsuario ) {
        this.idUsuario = idUsuario ;
    }
    @JsonProperty("id_usuario")
    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    @JsonProperty("prioridad")
    public void setPrioridad( Integer prioridad ) {
        this.prioridad = prioridad ;
    }
    @JsonProperty("prioridad")
    public Integer getPrioridad() {
        return this.prioridad;
    }

    @JsonProperty("estado")
    public void setEstado( String estado ) {
        this.estado = estado ;
    }
    @JsonProperty("estado")
    public String getEstado() {
        return this.estado;
    }

    public DefectoView(Defecto d) {
        id = d.getId();
        logPreguntaId = d.getLogPreguntaId();
        nombreApeUsuario = d.getNombreApeUsuario();
        fechaCreacion = d.getFechaCreacion() ;
        this.vehiculo = d.getVehiculo().getNombre();
        idUsuario = d.getIdUsuario();
        prioridad = d.getPrioridad();
        estado = d.getEstado();
    }

}
