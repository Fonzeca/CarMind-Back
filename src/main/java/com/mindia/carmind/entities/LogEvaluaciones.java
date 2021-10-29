/*
 * Created on 2021-10-19 ( 12:45:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * JPA entity class for "LogEvaluaciones"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="log_evaluaciones", catalog="carmind" )
public class LogEvaluaciones implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false)
    private Date       fecha ;

    @Column(name="evaluacion", nullable=false)
    private Integer    evaluacion ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="logEvaluaciones")
    private List<LogPreguntas> listOfLogPreguntas ; 

    @ManyToOne
    @JoinColumn(name="evaluacion", referencedColumnName="id", insertable=false, updatable=false)
    private Evaluaciones evaluaciones ; 

    @OneToMany(mappedBy="logEvaluaciones")
    private List<Vehiculos> listOfVehiculos ; 


    /**
     * Constructor
     */
    public LogEvaluaciones() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setFecha( Date fecha ) {
        this.fecha = fecha ;
    }
    public Date getFecha() {
        return this.fecha;
    }

    public void setEvaluacion( Integer evaluacion ) {
        this.evaluacion = evaluacion ;
    }
    public Integer getEvaluacion() {
        return this.evaluacion;
    }

    //--- GETTERS FOR LINKS
    public List<LogPreguntas> getListOfLogPreguntas() {
        return this.listOfLogPreguntas;
    } 

    public Evaluaciones getEvaluaciones() {
        return this.evaluaciones;
    } 

    public List<Vehiculos> getListOfVehiculos() {
        return this.listOfVehiculos;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(fecha);
        sb.append("|");
        sb.append(evaluacion);
        return sb.toString(); 
    } 

}