package com.mindia.carmind.evaluacion.pojo.view;

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
})
@Generated("jsonschema2pojo")
public class EvaluacionLiteView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("pendiente")
    private boolean pendiente;
    @JsonProperty("vencimiento")
    private int vencimiento;
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

    @JsonProperty("pendiente")
    public boolean isPendiente() {
        return this.pendiente;
    }

    @JsonProperty("pendiente")
    public boolean getPendiente() {
        return this.pendiente;
    }
    
    @JsonProperty("pendiente")
    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }

    @JsonProperty("vencimiento")
    public int getVencimiento() {
        return this.vencimiento;
    }

    @JsonProperty("vencimiento")
    public void setVencimiento(int vencimiento) {
        this.vencimiento = vencimiento;
    }

    @JsonProperty("intervaloDias")
    public int getIntervaloDias() {
        return this.intervaloDias;
    }

    @JsonProperty("intervaloDias")
    public void setIntervaloDias(int intervaloDias) {
        this.intervaloDias = intervaloDias;
    }


    public EvaluacionLiteView(Evaluacion e, int vencimiento, int intervaloDias){
        this.id = e.getId();
        this.titulo = e.getNombre();
        this.vencimiento = vencimiento;
        this.intervaloDias = intervaloDias;
        this.pendiente = vencimiento <= 0;
    }

}