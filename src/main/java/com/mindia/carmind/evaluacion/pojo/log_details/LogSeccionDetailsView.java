
package com.mindia.carmind.evaluacion.pojo.log_details;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.LogPregunta;
import com.mindia.carmind.entities.Seccion;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "seccion_id",
    "seccion_nombre",
    "preguntas"
})
@Generated("jsonschema2pojo")
public class LogSeccionDetailsView {

    @JsonProperty("seccion_id")
    private Integer seccionId;
    @JsonProperty("seccion_nombre")
    private String seccionNombre;
    @JsonProperty("preguntas")
    private List<LogPreguntaDetailsView> preguntas = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LogSeccionDetailsView() {
    }

    /**
     * 
     * @param seccionId
     * @param preguntas
     * @param seccionNombre
     */
    public LogSeccionDetailsView(Integer seccionId, String seccionNombre, List<LogPreguntaDetailsView> preguntas) {
        super();
        this.seccionId = seccionId;
        this.seccionNombre = seccionNombre;
        this.preguntas = preguntas;
    }

    public LogSeccionDetailsView(Seccion seccion, List<LogPregunta> logPregunta) {
        super();
        this.seccionId = seccion.getId();
        this.seccionNombre = seccion.getNombre();

        //Busco las preguntas correspondientes a esta seccion.
        var preguntasDeSeccion = logPregunta.stream().filter(x -> x.getPregunta().getSeccion().equals(this.seccionId)).collect(Collectors.toList());
        
        this.preguntas = preguntasDeSeccion.stream().map(LogPreguntaDetailsView::new).collect(Collectors.toList());
    }

    @JsonProperty("seccion_id")
    public Integer getSeccionId() {
        return seccionId;
    }

    @JsonProperty("seccion_id")
    public void setSeccionId(Integer seccionId) {
        this.seccionId = seccionId;
    }

    @JsonProperty("seccion_nombre")
    public String getSeccionNombre() {
        return seccionNombre;
    }

    @JsonProperty("seccion_nombre")
    public void setSeccionNombre(String seccionNombre) {
        this.seccionNombre = seccionNombre;
    }

    @JsonProperty("preguntas")
    public List<LogPreguntaDetailsView> getPreguntas() {
        return preguntas;
    }

    @JsonProperty("preguntas")
    public void setPreguntas(List<LogPreguntaDetailsView> preguntas) {
        this.preguntas = preguntas;
    }

}
