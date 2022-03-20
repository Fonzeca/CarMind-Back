/*
 * Created on 2022-03-19 ( 21:52:54 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import java.util.List;

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
 * JPA entity class for "PreguntaOpcion"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="pregunta_opcion", catalog="carmind" )
public class PreguntaOpcion implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="id_pregunta", nullable=false)
    private Integer    idPregunta ;

    @Column(name="opcion", nullable=false, length=50)
    private String     opcion ;

    @Column(name="crucial", nullable=false)
    private Boolean    crucial = false;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="preguntaOpcion")
    private List<LogOption> listOfLogOption ; 

    @ManyToOne
    @JoinColumn(name="id_pregunta", referencedColumnName="id", insertable=false, updatable=false)
    private Pregunta   pregunta ; 


    /**
     * Constructor
     */
    public PreguntaOpcion() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setIdPregunta( Integer idPregunta ) {
        this.idPregunta = idPregunta ;
    }
    public Integer getIdPregunta() {
        return this.idPregunta;
    }

    public void setOpcion( String opcion ) {
        this.opcion = opcion ;
    }
    public String getOpcion() {
        return this.opcion;
    }

    public void setCrucial( Boolean crucial ) {
        this.crucial = crucial ;
    }
    public Boolean getCrucial() {
        return this.crucial;
    }

    //--- GETTERS FOR LINKS
    public List<LogOption> getListOfLogOption() {
        return this.listOfLogOption;
    } 

    public Pregunta getPregunta() {
        return this.pregunta;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(idPregunta);
        sb.append("|");
        sb.append(opcion);
        sb.append("|");
        sb.append(crucial);
        return sb.toString(); 
    } 

}
