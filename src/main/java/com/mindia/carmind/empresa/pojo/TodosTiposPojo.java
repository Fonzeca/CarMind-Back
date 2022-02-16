package com.mindia.carmind.empresa.pojo;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "tipo_vehiculo",
        "tipo_documento"
})
@Generated("jsonschema2pojo")
public class TodosTiposPojo {

    @JsonProperty("tipo_vehiculo")
    private List<String> tipoVehiculo = null;
    @JsonProperty("tipo_documento")
    private List<String> tipoDocumento = null;
    @JsonProperty("tipo_pregunta")
    private List<TipoPojo> tipoPregunta = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public TodosTiposPojo() {
    }

    /**
     *
     * @param tipoDocumento
     * @param tipoVehiculo
     */
    public TodosTiposPojo(List<String> tipoVehiculo, List<String> tipoDocumento) {
        super();
        this.tipoVehiculo = tipoVehiculo;
        this.tipoDocumento = tipoDocumento;
    }

    @JsonProperty("tipo_vehiculo")
    public List<String> getTipoVehiculo() {
        return tipoVehiculo;
    }

    @JsonProperty("tipo_vehiculo")
    public void setTipoVehiculo(List<String> tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @JsonProperty("tipo_documento")
    public List<String> getTipoDocumento() {
        return tipoDocumento;
    }

    @JsonProperty("tipo_documento")
    public void setTipoDocumento(List<String> tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @JsonProperty("tipo_pregunta")
    public List<TipoPojo> getTipoPregunta() {
        return this.tipoPregunta;
    }

    @JsonProperty("tipo_pregunta")
    public void setTipoPregunta(List<TipoPojo> tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }


}