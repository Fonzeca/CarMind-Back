/*
 * Created on 2021-11-16 ( 09:54:32 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * JPA entity class for "Evaluacion"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="evaluacion", catalog="carmind" )
public class Evaluacion implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="identificador", nullable=false, length=50)
    private String     identificador ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="evaluacion2")
    private List<LogEvaluacion> listOfLogEvaluacion ; 

    @OneToMany(mappedBy="evaluacion2")
    private List<EvaluacionPregunta> listOfEvaluacionPregunta ; 


    /**
     * Constructor
     */
    public Evaluacion() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setIdentificador( String identificador ) {
        this.identificador = identificador ;
    }
    public String getIdentificador() {
        return this.identificador;
    }

    //--- GETTERS FOR LINKS
    public List<LogEvaluacion> getListOfLogEvaluacion() {
        return this.listOfLogEvaluacion;
    } 

    public List<EvaluacionPregunta> getListOfEvaluacionPregunta() {
        return this.listOfEvaluacionPregunta;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(identificador);
        return sb.toString(); 
    } 

}