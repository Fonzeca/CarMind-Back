/*
 * Created on 2022-06-22 ( 09:55:48 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 4.0.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JPA entity class for "Pregunta"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="pregunta", catalog="carmind" )
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int        id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="descripcion", nullable=false, length=100)
    private String     descripcion ;

    @Column(name="tipo", nullable=false, length=50)
    private String     tipo ;

    @Column(name="crucial", nullable=false)
    private boolean    crucial ;

    @Column(name="evaluacion_id", nullable=false)
    private int        evaluacionId ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="evaluacion_id", referencedColumnName="id", insertable=false, updatable=false)
    private Evaluacion evaluacion ; 

    @ManyToOne
    @JoinColumn(name="tipo", referencedColumnName="codigo", insertable=false, updatable=false)
    private TipoPregunta tipopregunta ; 

    @OneToMany(mappedBy="pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PreguntaOpcion> preguntaopcionList ; 


    /**
     * Constructor
     */
    public Pregunta() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( int id ) {
        this.id = id ;
    }
    public int getId() {
        return this.id;
    }

    public void setDescripcion( String descripcion ) {
        this.descripcion = descripcion ;
    }
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setTipo( String tipo ) {
        this.tipo = tipo ;
    }
    public String getTipo() {
        return this.tipo;
    }

    public void setCrucial( boolean crucial ) {
        this.crucial = crucial ;
    }
    public boolean isCrucial() {
        return this.crucial;
    }

    public void setEvaluacionId( int evaluacionId ) {
        this.evaluacionId = evaluacionId ;
    }
    public int getEvaluacionId() {
        return this.evaluacionId;
    }

    //--- GETTERS FOR LINKS
    public Evaluacion getEvaluacion() {
        return this.evaluacion;
    } 

    public TipoPregunta getTipopregunta() {
        return this.tipopregunta;
    } 

    public List<PreguntaOpcion> getPreguntaopcionList() {
        return this.preguntaopcionList;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(descripcion);
        sb.append("|");
        sb.append(tipo);
        sb.append("|");
        sb.append(crucial);
        sb.append("|");
        sb.append(evaluacionId);
        return sb.toString(); 
    } 

}
