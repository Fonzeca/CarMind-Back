/*
 * Created on 2022-02-14 ( 11:21:33 )
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
 * JPA entity class for "Notificaciones"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="notificaciones", catalog="carmind" )
public class Notificaciones implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="empresa_id", nullable=false)
    private Integer    empresaId ;

    @Column(name="usuario_id")
    private Integer    usuarioId ;

    @Column(name="texto", nullable=false, length=1000)
    private String     texto ;

    @Column(name="titulo", nullable=false, length=150)
    private String     titulo ;

    @Column(name="fecha_creacion", nullable=false)
    private LocalDate       fechaCreacion ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="empresa_id", referencedColumnName="id", insertable=false, updatable=false)
    private Empresa    empresa ; 

    @ManyToOne
    @JoinColumn(name="usuario_id", referencedColumnName="id", insertable=false, updatable=false)
    private Usuario    usuario ; 


    /**
     * Constructor
     */
    public Notificaciones() {
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

    public void setUsuarioId( Integer usuarioId ) {
        this.usuarioId = usuarioId ;
    }
    public Integer getUsuarioId() {
        return this.usuarioId;
    }

    public void setTexto( String texto ) {
        this.texto = texto ;
    }
    public String getTexto() {
        return this.texto;
    }

    public void setTitulo( String titulo ) {
        this.titulo = titulo ;
    }
    public String getTitulo() {
        return this.titulo;
    }

    public void setFechaCreacion( LocalDate fechaCreacion ) {
        this.fechaCreacion = fechaCreacion ;
    }
    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    //--- GETTERS FOR LINKS
    public Empresa getEmpresa() {
        return this.empresa;
    } 

    public Usuario getUsuario() {
        return this.usuario;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(empresaId);
        sb.append("|");
        sb.append(usuarioId);
        sb.append("|");
        sb.append(texto);
        sb.append("|");
        sb.append(titulo);
        sb.append("|");
        sb.append(fechaCreacion);
        return sb.toString(); 
    } 

}
