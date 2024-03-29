
package com.mindia.carmind.usuario.pojo.sync;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vehiculoId",
    "fecha",
    "enUso"
})
@Generated("jsonschema2pojo")
public class LogUsoView implements Comparable<LogUsoView> {

    @JsonProperty("vehiculoId")
    private Integer vehiculoId;
    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("enUso")
    private Boolean enUso;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LogUsoView() {
    }

    /**
     * 
     * @param fecha
     * @param vehiculoId
     * @param enUso
     */
    public LogUsoView(Integer vehiculoId, String fecha, Boolean enUso) {
        super();
        this.vehiculoId = vehiculoId;
        this.fecha = fecha;
        this.enUso = enUso;
    }

    @JsonProperty("vehiculoId")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculoId")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @JsonProperty("fecha")
    public String getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @JsonProperty("enUso")
    public Boolean getEnUso() {
        return enUso;
    }

    @JsonProperty("enUso")
    public void setEnUso(Boolean enUso) {
        this.enUso = enUso;
    }

    @Override
    public int compareTo(LogUsoView o) {
        try {
            var format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDate date1 = LocalDate.parse(this.getFecha(), format);
            LocalDate date2 = LocalDate.parse(o.getFecha(), format);
            return date2.compareTo(date1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
