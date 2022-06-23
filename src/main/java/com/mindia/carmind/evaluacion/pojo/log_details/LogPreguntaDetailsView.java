
package com.mindia.carmind.evaluacion.pojo.log_details;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.LogPregunta;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "log_id",
    "pregunta_id",
    "pregunta",
    "tipo",
    "texto",
    "base64_image",
    "tick_correcto",
    "crucial",
    "opciones"
})
@Generated("jsonschema2pojo")
public class LogPreguntaDetailsView {

    @JsonProperty("log_id")
    private Integer logId;
    @JsonProperty("pregunta")
    private String pregunta;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("texto")
    private String texto;
    @JsonProperty("base64_image")
    private String base64Image;
    @JsonProperty("tick_correcto")
    private Boolean tickCorrecto;
    @JsonProperty("crucial")
    private Boolean crucial;
    @JsonProperty("opciones")
    private List<LogOpcionDetailsView> opciones = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LogPreguntaDetailsView() {
    }

    /**
     * 
     * @param texto
     * @param tipo
     * @param opciones
     * @param base64Image
     * @param crucial
     * @param logId
     * @param preguntaId
     * @param tickCorrecto
     * @param pregunta
     */
    public LogPreguntaDetailsView(Integer logId, String pregunta, String tipo, String texto, String base64Image, Boolean tickCorrecto, Boolean crucial, List<LogOpcionDetailsView> opciones) {
        super();
        this.logId = logId;
        this.pregunta = pregunta;
        this.tipo = tipo;
        this.texto = texto;
        this.base64Image = base64Image;
        this.tickCorrecto = tickCorrecto;
        this.crucial = crucial;
        this.opciones = opciones;
    }

    public LogPreguntaDetailsView(LogPregunta log) {
        super();
        this.logId = log.getId();
        this.pregunta = log.getDescripcion();
        this.tipo = log.getTipo();
        this.crucial = log.isCrucial();

        this.texto = log.getNota();

        if(log.getImage() != null){
            this.base64Image = new String(Base64.getEncoder().encode(log.getImage()));
        }

        this.tickCorrecto = log.getTickCorrecto();
        
        if(log.getLogoptionList() != null && !log.getLogoptionList().isEmpty()){
            this.opciones = log.getLogoptionList().stream().map(LogOpcionDetailsView::new).collect(Collectors.toList());
        }
    }

    @JsonProperty("log_id")
    public Integer getLogId() {
        return logId;
    }

    @JsonProperty("log_id")
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    @JsonProperty("pregunta")
    public String getPregunta() {
        return pregunta;
    }

    @JsonProperty("pregunta")
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @JsonProperty("tipo")
    public String getTipo() {
        return tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonProperty("texto")
    public String getTexto() {
        return texto;
    }

    @JsonProperty("texto")
    public void setTexto(String texto) {
        this.texto = texto;
    }

    @JsonProperty("base64_image")
    public String getBase64Image() {
        return base64Image;
    }

    @JsonProperty("base64_image")
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @JsonProperty("tick_correcto")
    public Boolean getTickCorrecto() {
        return tickCorrecto;
    }

    @JsonProperty("tick_correcto")
    public void setTickCorrecto(Boolean tickCorrecto) {
        this.tickCorrecto = tickCorrecto;
    }

    @JsonProperty("crucial")
    public Boolean getCrucial() {
        return crucial;
    }

    @JsonProperty("crucial")
    public void setCrucial(Boolean crucial) {
        this.crucial = crucial;
    }

    @JsonProperty("opciones")
    public List<LogOpcionDetailsView> getOpciones() {
        return opciones;
    }

    @JsonProperty("opciones")
    public void setOpciones(List<LogOpcionDetailsView> opciones) {
        this.opciones = opciones;
    }

}
