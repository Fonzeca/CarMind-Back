/*
 * Created on 2022-08-03 ( 12:05:05 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 4.0.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * JPA entity class for "Documento"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="documento", catalog="carmind" )
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int        id ;

    //--- ENTITY DATA FIELDS 
    @Lob
    @Column(name="data", nullable=false)
    private byte[]     data ;

    @Column(name="formato", nullable=false, length=6)
    private String     formato ;

    @Column(name="content_type", nullable=false, length=50)
    private String     contentType ;

    @Column(name="vehiculo_id", nullable=false)
    private int        vehiculoId ;

    @Column(name="tipo_documento", nullable=false, length=20)
    private String     tipoDocumento ;

    @Column(name="vencimiento")
    private LocalDate  vencimiento ;

    @Column(name="aviso_vencimiento", nullable=false)
    private boolean    avisoVencimiento ;

    @Column(name="active", nullable=false)
    private boolean    active ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="tipo_documento", referencedColumnName="nombre", insertable=false, updatable=false)
    private TipoDocumento tipodocumento ; 

    @ManyToOne
    @JoinColumn(name="vehiculo_id", referencedColumnName="id", insertable=false, updatable=false)
    private Vehiculo   vehiculo ; 


    /**
     * Constructor
     */
    public Documento() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( int id ) {
        this.id = id ;
    }
    public int getId() {
        return this.id;
    }

    public void setData( byte[] data ) {
        this.data = data ;
    }
    public byte[] getData() {
        return this.data;
    }

    public void setFormato( String formato ) {
        this.formato = formato ;
    }
    public String getFormato() {
        return this.formato;
    }

    public void setContentType( String contentType ) {
        this.contentType = contentType ;
    }
    public String getContentType() {
        return this.contentType;
    }

    public void setVehiculoId( int vehiculoId ) {
        this.vehiculoId = vehiculoId ;
    }
    public int getVehiculoId() {
        return this.vehiculoId;
    }

    public void setTipoDocumento( String tipoDocumento ) {
        this.tipoDocumento = tipoDocumento ;
    }
    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setVencimiento( LocalDate vencimiento ) {
        this.vencimiento = vencimiento ;
    }
    public LocalDate getVencimiento() {
        return this.vencimiento;
    }

    public void setAvisoVencimiento( boolean avisoVencimiento ) {
        this.avisoVencimiento = avisoVencimiento ;
    }
    public boolean isAvisoVencimiento() {
        return this.avisoVencimiento;
    }

    public void setActive( boolean active ) {
        this.active = active ;
    }
    public boolean isActive() {
        return this.active;
    }

    //--- GETTERS FOR LINKS
    public TipoDocumento getTipodocumento() {
        return this.tipodocumento;
    } 

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        // attribute 'data' not usable (type = byte[])
        sb.append("|");
        sb.append(formato);
        sb.append("|");
        sb.append(contentType);
        sb.append("|");
        sb.append(vehiculoId);
        sb.append("|");
        sb.append(tipoDocumento);
        sb.append("|");
        sb.append(vencimiento);
        sb.append("|");
        sb.append(avisoVencimiento);
        sb.append("|");
        sb.append(active);
        return sb.toString(); 
    } 

}
