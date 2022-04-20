package com.mindia.carmind.evaluacion.pojo.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Evaluacion;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "titulo",
    "pendiente",
    "intervaloDias"
})
@Generated("jsonschema2pojo")
public class EvaluacionLiteView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("fechaVencimiento")
    private String fechaVencimiento;
    @JsonProperty("intervaloDias")
    private int intervaloDias;


    /**
     * No args constructor for use in serialization
     * 
     */
    public EvaluacionLiteView() {
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("titulo")
    public String getTitulo() {
        return titulo;
    }

    @JsonProperty("titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @JsonProperty("fechaVencimiento")
    public String getVencimiento() {
        return this.fechaVencimiento;
    }

    @JsonProperty("fechaVencimiento")
    public void setVencimiento(String vencimiento) {
        this.fechaVencimiento = vencimiento;
    }

    @JsonProperty("intervaloDias")
    public int getIntervaloDias() {
        return this.intervaloDias;
    }

    @JsonProperty("intervaloDias")
    public void setIntervaloDias(int intervaloDias) {
        this.intervaloDias = intervaloDias;
    }


    public EvaluacionLiteView(Evaluacion e, LocalDate fechaProxima, int intervaloDias){
        this.id = e.getId();
        this.titulo = e.getNombre();
        if(fechaProxima != null){
            this.fechaVencimiento = fechaProxima.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        this.intervaloDias = intervaloDias;
    }

}