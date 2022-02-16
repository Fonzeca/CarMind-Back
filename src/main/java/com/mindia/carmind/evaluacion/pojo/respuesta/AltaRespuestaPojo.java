
package com.mindia.carmind.evaluacion.pojo.respuesta;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pregunta_id",
    "tick_correcto",
    "base64_image",
    "texto",
    "opciones"
})
@Generated("jsonschema2pojo")
public class AltaRespuestaPojo {

    @JsonProperty("pregunta_id")
    private Integer preguntaId;
    @JsonProperty("tick_correcto")
    private Boolean tickCorrecto;
    @JsonProperty("base64_image")
    private String base64Image;
    @JsonProperty("texto")
    private String texto;
    @JsonProperty("opciones")
    private List<RespuestaOpcionPojo> opciones = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AltaRespuestaPojo() {
    }

    /**
     * 
     * @param texto
     * @param opciones
     * @param base64Image
     * @param preguntaId
     * @param tickCorrecto
     */
    public AltaRespuestaPojo(Integer preguntaId, Boolean tickCorrecto, String base64Image, String texto, List<RespuestaOpcionPojo> opciones) {
        super();
        this.preguntaId = preguntaId;
        this.tickCorrecto = tickCorrecto;
        this.base64Image = base64Image;
        this.texto = texto;
        this.opciones = opciones;
    }

    @JsonProperty("pregunta_id")
    public Integer getPreguntaId() {
        return preguntaId;
    }

    @JsonProperty("pregunta_id")
    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    @JsonProperty("tick_correcto")
    public Boolean getTickCorrecto() {
        return tickCorrecto;
    }

    @JsonProperty("tick_correcto")
    public void setTickCorrecto(Boolean tickCorrecto) {
        this.tickCorrecto = tickCorrecto;
    }

    @JsonProperty("base64_image")
    public String getBase64Image() {
        return base64Image;
    }

    @JsonProperty("base64_image")
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @JsonProperty("texto")
    public String getTexto() {
        return texto;
    }

    @JsonProperty("texto")
    public void setTexto(String texto) {
        this.texto = texto;
    }

    @JsonProperty("opciones")
    public List<RespuestaOpcionPojo> getOpciones() {
        return opciones;
    }

    @JsonProperty("opciones")
    public void setOpciones(List<RespuestaOpcionPojo> opciones) {
        this.opciones = opciones;
    }

}
