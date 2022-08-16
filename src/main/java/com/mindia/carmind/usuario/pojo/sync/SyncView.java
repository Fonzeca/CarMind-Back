
package com.mindia.carmind.usuario.pojo.sync;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "logsUso",
    "logsEvaluaciones"
})
@Generated("jsonschema2pojo")
public class SyncView {

    @JsonProperty("logsUso")
    private List<LogUsoView> logsUso = null;
    @JsonProperty("logsEvaluaciones")
    private List<LogEvaluacionRealizada> logsEvaluaciones = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SyncView() {
    }

    /**
     * 
     * @param logsEvaluaciones
     * @param logsUso
     */
    public SyncView(List<LogUsoView> logsUso, List<LogEvaluacionRealizada> logsEvaluaciones) {
        super();
        this.logsUso = logsUso;
        this.logsEvaluaciones = logsEvaluaciones;
    }

    @JsonProperty("logsUso")
    public List<LogUsoView> getLogsUso() {
        return logsUso;
    }

    @JsonProperty("logsUso")
    public void setLogsUso(List<LogUsoView> logsUso) {
        this.logsUso = logsUso;
    }

    @JsonProperty("logsEvaluaciones")
    public List<LogEvaluacionRealizada> getlogsEvaluaciones() {
        return logsEvaluaciones;
    }

    @JsonProperty("logsEvaluaciones")
    public void setlogsEvaluaciones(List<LogEvaluacionRealizada> logsEvaluaciones) {
        this.logsEvaluaciones = logsEvaluaciones;
    }

}
