
package com.mindia.carmind.evaluacion.pojo.respuesta;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vehiculo_id",
    "respuestas"
})
@Generated("jsonschema2pojo")
public class AltaEvaluacionTerminadaPojo {

    @JsonProperty("vehiculo_id")
    private Integer vehiculoId;
    @JsonProperty("respuestas")
    private List<AltaRespuestaPojo> respuestas = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AltaEvaluacionTerminadaPojo() {
    }

    /**
     * 
     * @param respuestas
     * @param vehiculoId
     */
    public AltaEvaluacionTerminadaPojo(Integer vehiculoId, List<AltaRespuestaPojo> respuestas) {
        super();
        this.vehiculoId = vehiculoId;
        this.respuestas = respuestas;
    }

    @JsonProperty("vehiculo_id")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculo_id")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @JsonProperty("respuestas")
    public List<AltaRespuestaPojo> getRespuestas() {
        return respuestas;
    }

    @JsonProperty("respuestas")
    public void setRespuestas(List<AltaRespuestaPojo> respuestas) {
        this.respuestas = respuestas;
    }

    public void validate(){
        if(this.vehiculoId == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe tener vehiculo_id");
        }

        if(this.respuestas == null || this.respuestas.size() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe tener respuestas");
        }

    }

}
