package com.mindia.carmind.notificacion.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "nombre",
    "vencimientos"
})
public class NotificacionDocumentacionView {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("vencimientos")
    private  List<VencimientoView> vencimientos;

    public NotificacionDocumentacionView() {
    }

    public NotificacionDocumentacionView(String nombre, List<VencimientoView> vencimientos) {
        super();
        this.nombre = nombre;
        if(!vencimientos.isEmpty()){
            this.vencimientos = vencimientos;
        }
    }

}
