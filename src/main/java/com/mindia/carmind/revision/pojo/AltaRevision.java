package com.mindia.carmind.revision.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "vehiculo_id",
        "nota"
})
@Generated("jsonschema2pojo")
public class AltaRevision {

    @JsonProperty("vehiculo_id")
    private Integer vehiculoId;
    @JsonProperty("nota")
    private String nota;

    /**
     * No args constructor for use in serialization
     *
     */
    public AltaRevision() {
    }

    /**
     *
     * @param vehiculoId
     * @param nota
     */
    public AltaRevision(Integer vehiculoId, String nota) {
        super();
        this.vehiculoId = vehiculoId;
        this.nota = nota;
    }

    @JsonProperty("vehiculo_id")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculo_id")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @JsonProperty("nota")
    public String getNota() {
        return nota;
    }

    @JsonProperty("nota")
    public void setNota(String nota) {
        this.nota = nota;
    }

}