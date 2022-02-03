/*
 * Created on 2022-02-02 ( 13:08:25 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
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
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Lob
    @Column(name="data", nullable=false)
    private byte[]     data ;

    @Column(name="formato", nullable=false, length=6)
    private String     formato ;

    @Column(name="content_type", nullable=false, length=50)
    private String     contentType ;


    //--- ENTITY LINKS ( RELATIONSHIP )

    /**
     * Constructor
     */
    public Documento() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
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

    //--- GETTERS FOR LINKS
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
        return sb.toString(); 
    } 

}
