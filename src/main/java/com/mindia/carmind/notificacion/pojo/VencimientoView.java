package com.mindia.carmind.notificacion.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "vehiculo",
    "days",
    "documento"
})
public class VencimientoView {
    
    @JsonProperty("documento")
    private String tipoDocumento;
    @JsonProperty("vehiculo")
    private String vehiculo;
    @JsonProperty("days")
    private int dias;

    public VencimientoView() {
    }

    public VencimientoView(String tipoDocumento, String vehiculo, int dias) {
       this.tipoDocumento = tipoDocumento;
       this.vehiculo = vehiculo;
       this.dias = dias;
    }
    
}
