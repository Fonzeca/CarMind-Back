package com.mindia.carmind.empresa.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nombre",
        "unidad_distancia",
        "usuario_admin"
})
@Generated("jsonschema2pojo")
public class AltaPojo {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("unidad_distancia")
    private String unidadDistancia;
    @JsonProperty("usuario_admin")
    private com.mindia.carmind.usuario.pojo.AltaPojo usuarioAdmin;

    /**
     * No args constructor for use in serialization
     *
     */
    public AltaPojo() {
    }

    /**
     *
     * @param unidadDistancia
     * @param nombre
     * @param usuarioAdmin
     */
    public AltaPojo(String nombre, String unidadDistancia, com.mindia.carmind.usuario.pojo.AltaPojo usuarioAdmin) {
        super();
        this.nombre = nombre;
        this.unidadDistancia = unidadDistancia;
        this.usuarioAdmin = usuarioAdmin;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("unidad_distancia")
    public String getUnidadDistancia() {
        return unidadDistancia;
    }

    @JsonProperty("unidad_distancia")
    public void setUnidadDistancia(String unidadDistancia) {
        this.unidadDistancia = unidadDistancia;
    }

    @JsonProperty("usuario_admin")
    public com.mindia.carmind.usuario.pojo.AltaPojo getUsuarioAdmin() {
        return usuarioAdmin;
    }

    @JsonProperty("usuario_admin")
    public void setUsuarioAdmin(com.mindia.carmind.usuario.pojo.AltaPojo usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

}