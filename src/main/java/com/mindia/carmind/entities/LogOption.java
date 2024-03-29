/*
 * Created on 2022-08-03 ( 13:05:11 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 4.0.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * JPA entity class for "LogOption"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="log_option", catalog="carmind" )
public class LogOption implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int        id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="id_log_pregunta", nullable=false)
    private int        idLogPregunta ;

    @Column(name="tick_check", nullable=false)
    private boolean    tickCheck ;

    @Column(name="descripcion", nullable=false, length=50)
    private String     descripcion ;

    @Column(name="crucial", nullable=false)
    private boolean    crucial ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="id_log_pregunta", referencedColumnName="id", insertable=false, updatable=false)
    private LogPregunta logpregunta ; 


    /**
     * Constructor
     */
    public LogOption() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( int id ) {
        this.id = id ;
    }
    public int getId() {
        return this.id;
    }

    public void setIdLogPregunta( int idLogPregunta ) {
        this.idLogPregunta = idLogPregunta ;
    }
    public int getIdLogPregunta() {
        return this.idLogPregunta;
    }

    public void setTickCheck( boolean tickCheck ) {
        this.tickCheck = tickCheck ;
    }
    public boolean isTickCheck() {
        return this.tickCheck;
    }

    public void setDescripcion( String descripcion ) {
        this.descripcion = descripcion ;
    }
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setCrucial( boolean crucial ) {
        this.crucial = crucial ;
    }
    public boolean isCrucial() {
        return this.crucial;
    }

    //--- GETTERS FOR LINKS
    public LogPregunta getLogpregunta() {
        return this.logpregunta;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(idLogPregunta);
        sb.append("|");
        sb.append(tickCheck);
        sb.append("|");
        sb.append(descripcion);
        sb.append("|");
        sb.append(crucial);
        return sb.toString(); 
    } 

}
