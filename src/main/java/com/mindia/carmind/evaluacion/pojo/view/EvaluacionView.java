package com.mindia.carmind.evaluacion.pojo.view;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Evaluacion;
import com.mindia.carmind.entities.Pregunta;
import com.mindia.carmind.entities.Seccion;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "vehiculo_id",
    "titulo",
    "fecha_inicio",
    "preguntas"
})
@Generated("jsonschema2pojo")
public class EvaluacionView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("vehiculo_id")
    private List<Integer> vehiculoId;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("fecha_inicio")
    private String fechaInicio;
    @JsonProperty("preguntas")
    private List<PreguntaView> preguntas = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EvaluacionView() {
    }

    /**
     * 
     * @param vehiculoId
     * @param fechaInicio
     * @param titulo
     * @param id
     * @param preguntas
     */
    public EvaluacionView(Integer id, List<Integer> vehiculoId, String titulo, String fechaInicio, List<PreguntaView> preguntas) {
        super();
        this.id = id;
        this.vehiculoId = vehiculoId;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.preguntas = preguntas;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("vehiculo_id")
    public List<Integer> getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculo_id")
    public void setVehiculoId(List<Integer> vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @JsonProperty("titulo")
    public String getTitulo() {
        return titulo;
    }

    @JsonProperty("titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @JsonProperty("fecha_inicio")
    public String getFechaInicio() {
        return fechaInicio;
    }

    @JsonProperty("fecha_inicio")
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @JsonProperty("preguntas")
    public List<PreguntaView> getPreguntas() {
        return this.preguntas;
    }

    @JsonProperty("preguntas")
    public void setPreguntas(List<PreguntaView> preguntas) {
        this.preguntas = preguntas;
    }


    public EvaluacionView(Evaluacion e){
        this.id = e.getId();
        this.titulo = e.getNombre();
    }

    public static EvaluacionView getEvaluacionDetails(Evaluacion e){
        EvaluacionView ev = new EvaluacionView(e);

        ev.setVehiculoId(e.getListOfVehiculoEvaluacion().stream().map(x -> x.getVehiculoId()).collect(Collectors.toList()));

        ev.setPreguntas(e.getListOfPregunta().stream().map(PreguntaView::new).collect(Collectors.toList()));

        return ev;
    }

    public EvaluacionView(Evaluacion e, List<Pregunta> preguntas, List<Seccion> secciones){
        // this.id = e.getId();
        // this.nombre = e.getNombre();
        // this.secciones = new ArrayList<SeccionView>();

        // for (Seccion seccion : secciones) {
        //     List<Pregunta> preguntasxSeccion = preguntas.stream().filter(x -> x.getSeccion() == seccion.getId()).collect(Collectors.toList());

        //     this.secciones.add(new SeccionView(seccion, preguntasxSeccion));
        // }

    }

}