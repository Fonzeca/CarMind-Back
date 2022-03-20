/*
 * Created on 2022-03-19 ( 21:44:21 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * JPA entity class for "Seccion"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="seccion", catalog="carmind" )
public class Seccion implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="evaluacion_id", nullable=false)
    private Integer    evaluacionId ;

    @Column(name="nombre", nullable=false, length=50)
    private String     nombre ;

    @Column(name="activo", nullable=false)
    private Boolean    activo ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="evaluacion_id", referencedColumnName="id", insertable=false, updatable=false)
    private Evaluacion evaluacion ; 

    @OneToMany(mappedBy="seccion2")
    private List<Pregunta> listOfPregunta ; 


    /**
     * Constructor
     */
    public Seccion() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setEvaluacionId( Integer evaluacionId ) {
        this.evaluacionId = evaluacionId ;
    }
    public Integer getEvaluacionId() {
        return this.evaluacionId;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre ;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setActivo( Boolean activo ) {
        this.activo = activo ;
    }
    public Boolean getActivo() {
        return this.activo;
    }

    //--- GETTERS FOR LINKS
    public Evaluacion getEvaluacion() {
        return this.evaluacion;
    } 

    public List<Pregunta> getListOfPregunta() {
        return this.listOfPregunta;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(evaluacionId);
        sb.append("|");
        sb.append(nombre);
        sb.append("|");
        sb.append(activo);
        return sb.toString(); 
    } 

}
