/*
 * Created on 2022-02-04 ( 00:09:31 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * JPA entity class for "Usuario"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="usuario", catalog="carmind" )
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="nombre", nullable=false, length=50)
    private String     nombre ;

    @Column(name="empresa", nullable=false)
    private Integer    empresa ;

    @Column(name="username", nullable=false, length=50)
    private String     username ;

    @Column(name="administrador", nullable=false)
    private Boolean    administrador ;

    @Column(name="apellido", nullable=false, length=50)
    private String     apellido ;

    @Column(name="DNI", nullable=false, length=15)
    private String     dni ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="usuario")
    private List<Vehiculo> listOfVehiculo ; 

    @ManyToOne
    @JoinColumn(name="empresa", referencedColumnName="id", insertable=false, updatable=false)
    private Empresa    empresa2 ; 


    /**
     * Constructor
     */
    public Usuario() {
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

    public void setEmpresa( Integer empresa ) {
        this.empresa = empresa ;
    }
    public Integer getEmpresa() {
        return this.empresa;
    }

    public void setUsername( String username ) {
        this.username = username ;
    }
    public String getUsername() {
        return this.username;
    }

    public void setAdministrador( Boolean administrador ) {
        this.administrador = administrador ;
    }
    public Boolean getAdministrador() {
        return this.administrador;
    }

    public void setApellido( String apellido ) {
        this.apellido = apellido ;
    }
    public String getApellido() {
        return this.apellido;
    }

    public void setDni( String dni ) {
        this.dni = dni ;
    }
    public String getDni() {
        return this.dni;
    }

    //--- GETTERS FOR LINKS
    public List<Vehiculo> getListOfVehiculo() {
        return this.listOfVehiculo;
    } 

    public Empresa getEmpresa2() {
        return this.empresa2;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(nombre);
        sb.append("|");
        sb.append(empresa);
        sb.append("|");
        sb.append(username);
        sb.append("|");
        sb.append(administrador);
        sb.append("|");
        sb.append(apellido);
        sb.append("|");
        sb.append(dni);
        return sb.toString(); 
    } 

}
