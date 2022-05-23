package com.mindia.carmind.evaluacion.pojo.alta;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "opcion",
    "crucial"
})
@Generated("jsonschema2pojo")
public class AltaOpcionPojo {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("opcion")
    private String opcion;
    @JsonProperty("crucial")
    private Boolean crucial;

    @JsonProperty("opcion")
    public String getOpcion() {
        return this.opcion;
    }

    @JsonProperty("opcion")
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    @JsonProperty("crucial")
    public Boolean getCrucial() {
        return this.crucial;
    }

    @JsonProperty("crucial")
    public void setCrucial(Boolean crucial) {
        this.crucial = crucial;
    }

    @JsonProperty("id")
    public Integer getId() {
        return this.id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

}
