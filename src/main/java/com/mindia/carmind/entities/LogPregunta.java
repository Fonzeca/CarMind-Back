/*
 * Created on 2021-11-20 ( 12:39:49 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * JPA entity class for "LogPregunta"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="log_pregunta", catalog="carmind" )
public class LogPregunta implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="log_evaluacion", nullable=false)
    private Integer    logEvaluacion ;

    @Column(name="pregunta", nullable=false)
    private Integer    pregunta ;

    @Column(name="respuesta", nullable=false, length=50)
    private String     respuesta ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="log_evaluacion", referencedColumnName="id", insertable=false, updatable=false)
    private LogEvaluacion logEvaluacion2 ; 

    @ManyToOne
    @JoinColumn(name="pregunta", referencedColumnName="id", insertable=false, updatable=false)
    private Pregunta   pregunta2 ; 


    /**
     * Constructor
     */
    public LogPregunta() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setLogEvaluacion( Integer logEvaluacion ) {
        this.logEvaluacion = logEvaluacion ;
    }
    public Integer getLogEvaluacion() {
        return this.logEvaluacion;
    }

    public void setPregunta( Integer pregunta ) {
        this.pregunta = pregunta ;
    }
    public Integer getPregunta() {
        return this.pregunta;
    }

    public void setRespuesta( String respuesta ) {
        this.respuesta = respuesta ;
    }
    public String getRespuesta() {
        return this.respuesta;
    }

    //--- GETTERS FOR LINKS
    public LogEvaluacion getLogEvaluacion2() {
        return this.logEvaluacion2;
    } 

    public Pregunta getPregunta2() {
        return this.pregunta2;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(logEvaluacion);
        sb.append("|");
        sb.append(pregunta);
        sb.append("|");
        sb.append(respuesta);
        return sb.toString(); 
    } 

}
