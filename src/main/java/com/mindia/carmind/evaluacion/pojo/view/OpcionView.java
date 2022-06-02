
package com.mindia.carmind.evaluacion.pojo.view;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.PreguntaOpcion;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "opcion"
})
@Generated("jsonschema2pojo")
public class OpcionView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("opcion")
    private String opcion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpcionView() {
    }

    /**
     * 
     * @param opcion
     * @param id
     */
    public OpcionView(Integer id, String opcion) {
        super();
        this.id = id;
        this.opcion = opcion;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("opcion")
    public String getOpcion() {
        return this.opcion;
    }

    @JsonProperty("opcion")
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }


    public OpcionView(PreguntaOpcion o){
        this.id = o.getId();
        this.opcion = o.getOpcion();
    }

}
