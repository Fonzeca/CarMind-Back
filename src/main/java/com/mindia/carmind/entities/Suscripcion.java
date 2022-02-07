/*
 * Created on 2022-02-07 ( 08:45:48 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JPA entity class for "Suscripcion"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="suscripcion", catalog="carmind" )
public class Suscripcion implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="empresa_id", nullable=false)
    private Integer    empresaId ;

    @Column(name="fecha_inicio", nullable=false)
    private LocalDate       fechaInicio ;

    @Column(name="fecha_fin", nullable=false)
    private LocalDate       fechaFin ;

    @Column(name="plan", nullable=false)
    private Integer    plan ;

    @Column(name="es_free_tiral", nullable=false)
    private Boolean    esFreeTiral ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="empresa_id", referencedColumnName="id", insertable=false, updatable=false)
    private Empresa    empresa ; 


    /**
     * Constructor
     */
    public Suscripcion() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setEmpresaId( Integer empresaId ) {
        this.empresaId = empresaId ;
    }
    public Integer getEmpresaId() {
        return this.empresaId;
    }

    public void setFechaInicio( LocalDate fechaInicio ) {
        this.fechaInicio = fechaInicio ;
    }
    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaFin( LocalDate fechaFin ) {
        this.fechaFin = fechaFin ;
    }
    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setPlan( Integer plan ) {
        this.plan = plan ;
    }
    public Integer getPlan() {
        return this.plan;
    }

    public void setEsFreeTiral( Boolean esFreeTiral ) {
        this.esFreeTiral = esFreeTiral ;
    }
    public Boolean getEsFreeTiral() {
        return this.esFreeTiral;
    }

    //--- GETTERS FOR LINKS
    public Empresa getEmpresa() {
        return this.empresa;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(empresaId);
        sb.append("|");
        sb.append(fechaInicio);
        sb.append("|");
        sb.append(fechaFin);
        sb.append("|");
        sb.append(plan);
        sb.append("|");
        sb.append(esFreeTiral);
        return sb.toString(); 
    } 

}
