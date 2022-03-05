package com.mindia.carmind.vehiculo.pojo;

import java.time.format.DateTimeFormatter;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Documento;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "vehiculo_id",
        "tipo_documento",
        "fecha_vencimiento"
})
@Generated("jsonschema2pojo")
public class DocumentoView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("vehiculo_id")
    private Integer vehiculoId;
    @JsonProperty("tipo_documento")
    private String tipoDocumento;
    @JsonProperty("fecha_vencimiento")
    private String fechaVencimiento;

    /**
     * No args constructor for use in serialization
     *
     */
    public DocumentoView(Documento d) {
        this.id = d.getId();
        this.vehiculoId = d.getVehiculoId();
        this.tipoDocumento = d.getTipoDocumento();
        this.fechaVencimiento = d.getVencimiento().format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
    }


    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("vehiculo_id")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculo_id")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @JsonProperty("tipo_documento")
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    @JsonProperty("tipo_documento")
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @JsonProperty("fecha_vencimiento")
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    @JsonProperty("fecha_vencimiento")
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }



}