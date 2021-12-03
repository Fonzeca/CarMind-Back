/*
 * Created on 2021-12-01 ( 12:57:09 )
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    @Column(name="nombre", nullable=false, length=50)
    private String     nombre ;

    @Column(name="descripcion", nullable=false, length=100)
    private String     descripcion ;

    @Column(name="activo", nullable=false )
    private Boolean    activo ;


    //--- ENTITY LINKS ( RELATIONSHIP )
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

    public void setNombre( String nombre ) {
        this.nombre = nombre ;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setDescripcion( String descripcion ) {
        this.descripcion = descripcion ;
    }
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setActivo( Boolean activo ) {
        this.activo = activo ;
    }
    public Boolean getActivo() {
        return this.activo;
    }

    //--- GETTERS FOR LINKS
    public List<Pregunta> getListOfPregunta() {
        return this.listOfPregunta;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(nombre);
        sb.append("|");
        sb.append(descripcion);
        sb.append("|");
        sb.append(activo);
        return sb.toString(); 
    } 

}
