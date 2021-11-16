
package com.mindia.carmind.vehiculo.pojo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Id",
    "Marca",
    "Modelos"
})
@Generated("jsonschema2pojo")
public class MarcaPojo {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Marca")
    private String marca;
    @JsonProperty("Modelos")
    private List<ModeloPojo> modelos = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MarcaPojo() {
    }

    /**
     * 
     * @param marca
     * @param id
     * @param modelos
     */
    public MarcaPojo(String id, String marca, List<ModeloPojo> modelos) {
        super();
        this.id = id;
        this.marca = marca;
        this.modelos = modelos;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Marca")
    public String getMarca() {
        return marca;
    }

    @JsonProperty("Marca")
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @JsonProperty("Modelos")
    public List<ModeloPojo> getModelos() {
        return modelos;
    }

    @JsonProperty("Modelos")
    public void setModelos(List<ModeloPojo> modelos) {
        this.modelos = modelos;
    }

    /* Singleton */

    private static List<MarcaPojo> MARCAS = null;

    public static List<MarcaPojo> getMarcas(){
        if(MARCAS == null){
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<MarcaPojo>> typeReference = new TypeReference<List<MarcaPojo>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/jsonAutos.json");
            try {
                MARCAS = mapper.readValue(inputStream,typeReference);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return MARCAS;
    }

    /**
     * Funcion para buscar entre las base de datos, una marca.
     * Si no existe, devuelve null.
     * 
     * @param marca la marca a buscar
     * @return El objeto MarcaPojo buscado
     */
    public static MarcaPojo buscarMarca(String marca){
        if(marca != null && !marca.isBlank()){

            //Busca y lo encapsulamos en a
            List<MarcaPojo> a = getMarcas().stream().filter(
                x -> x.getMarca().trim().toLowerCase().equals(marca.trim().toLowerCase())
            ).collect(Collectors.toList());

            //Me duvuelve el primero o null
            return a.size() > 0 ? a.get(0) : null;
        }else{
            return null;
        }
    }

}
