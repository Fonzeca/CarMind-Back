package com.mindia.carmind.revision.pojo;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Revision;
import com.mindia.carmind.evaluacion.pojo.LogEvaluacionView;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "nota",
        "fecha",
        "logs"
})
@Generated("jsonschema2pojo")
public class RevisionView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nota")
    private String nota;
    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("logs")
    private List<LogEvaluacionView> logs = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public RevisionView() {
    }

    /**
     *
     * @param fecha
     * @param id
     * @param nota
     * @param logs
     */
    public RevisionView(Revision revision) {
        super();
        this.id = revision.getId();
        this.nota = revision.getNota();
        this.fecha = revision.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/YYYY mm:hh"));
        this.logs = revision.getLogevaluacionList().stream().map(LogEvaluacionView::new).collect(Collectors.toList());
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("nota")
    public String getNota() {
        return nota;
    }

    @JsonProperty("nota")
    public void setNota(String nota) {
        this.nota = nota;
    }

    @JsonProperty("fecha")
    public String getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @JsonProperty("logs")
    public List<LogEvaluacionView> getLogs() {
        return logs;
    }

    @JsonProperty("logs")
    public void setLogs(List<LogEvaluacionView> logs) {
        this.logs = logs;
    }

}