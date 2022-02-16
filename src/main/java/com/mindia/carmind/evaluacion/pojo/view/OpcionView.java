
package com.mindia.carmind.evaluacion.pojo.view;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.PreguntaOpcion;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "texto"
})
@Generated("jsonschema2pojo")
public class OpcionView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("texto")
    private String texto;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpcionView() {
    }

    /**
     * 
     * @param texto
     * @param id
     */
    public OpcionView(Integer id, String texto) {
        super();
        this.id = id;
        this.texto = texto;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("texto")
    public String getTexto() {
        return texto;
    }

    @JsonProperty("texto")
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public OpcionView(PreguntaOpcion o){
        this.id = o.getId();
        this.texto = o.getOpcion();
    }

}
