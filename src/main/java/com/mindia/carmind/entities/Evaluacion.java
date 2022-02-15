/*
 * Created on 2022-02-15 ( 17:22:25 )
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
    @Column(name="nombre", nullable=false, length=50)
    private String     nombre ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="evaluacion")
    private List<LogEvaluacion> listOfLogEvaluacion ; 

    @OneToMany(mappedBy="evaluacion")
    private List<VehiculoEvaluacion> listOfVehiculoEvaluacion ; 

    @OneToMany(mappedBy="evaluacion")
    private List<Seccion> listOfSeccion ; 


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

    public void setNombre( String nombre ) {
        this.nombre = nombre ;
    }
    public String getNombre() {
        return this.nombre;
    }

    //--- GETTERS FOR LINKS
    public List<LogEvaluacion> getListOfLogEvaluacion() {
        return this.listOfLogEvaluacion;
    } 

    public List<VehiculoEvaluacion> getListOfVehiculoEvaluacion() {
        return this.listOfVehiculoEvaluacion;
    } 

    public List<Seccion> getListOfSeccion() {
        return this.listOfSeccion;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(nombre);
        return sb.toString(); 
    } 

}
