/*
 * Created on 2021-12-03 ( 10:36:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * JPA entity class for "VehiculoEvaluacion"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="vehiculo_evaluacion", catalog="carmind" )
public class VehiculoEvaluacion implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="vehiculo_id", nullable=false)
    private Integer    vehiculoId ;

    @Column(name="evaluacion_id", nullable=false)
    private Integer    evaluacionId ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="vehiculo_id", referencedColumnName="id", insertable=false, updatable=false)
    private Vehiculo   vehiculo ; 

    @ManyToOne
    @JoinColumn(name="evaluacion_id", referencedColumnName="id", insertable=false, updatable=false)
    private Evaluacion evaluacion ; 


    /**
     * Constructor
     */
    public VehiculoEvaluacion() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setVehiculoId( Integer vehiculoId ) {
        this.vehiculoId = vehiculoId ;
    }
    public Integer getVehiculoId() {
        return this.vehiculoId;
    }

    public void setEvaluacionId( Integer evaluacionId ) {
        this.evaluacionId = evaluacionId ;
    }
    public Integer getEvaluacionId() {
        return this.evaluacionId;
    }

    //--- GETTERS FOR LINKS
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    } 

    public Evaluacion getEvaluacion() {
        return this.evaluacion;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(vehiculoId);
        sb.append("|");
        sb.append(evaluacionId);
        return sb.toString(); 
    } 

}
