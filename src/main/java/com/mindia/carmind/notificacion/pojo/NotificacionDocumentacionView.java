package com.mindia.carmind.notificacion.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "email",
    "nombre",
    "vencimientos"
})
public class NotificacionDocumentacionView {

    @JsonProperty("email")
    private String email;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("vencimientos")
    private  List<VencimientoView> vencimientos;

    public NotificacionDocumentacionView() {
    }

    public NotificacionDocumentacionView(String email, String nombre, List<VencimientoView> vencimientos) {
        super();
        this.email = email;
        this.nombre = nombre;
        if(!vencimientos.isEmpty()){
            this.vencimientos = vencimientos;
        }
    }

}
