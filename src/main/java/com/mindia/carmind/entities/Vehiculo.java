/*
 * Created on 2022-02-14 ( 16:35:48 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.entities;

import java.io.Serializable;
import java.time.LocalDate;
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
 * JPA entity class for "Vehiculo"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="vehiculo", catalog="carmind" )
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="marca", nullable=false, length=50)
    private String     marca ;

    @Column(name="nombre", nullable=false, length=50)
    private String     nombre ;

    @Column(name="patente", nullable=false, length=20)
    private String     patente ;

    @Column(name="modelo", nullable=false, length=50)
    private String     modelo ;

    @Column(name="linea", nullable=false, length=4)
    private String     linea ;

    @Column(name="fecha_service")
    private LocalDate       fechaService ;

    @Column(name="usuario_id")
    private Integer    usuarioId ;

    @Column(name="color", nullable=false, length=50)
    private String     color ;

    @Column(name="empresa_id", nullable=false)
    private Integer    empresaId ;

    @Column(name="tipo_vehiculo", nullable=false, length=50)
    private String     tipoVehiculo ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="empresa_id", referencedColumnName="id", insertable=false, updatable=false)
    private Empresa    empresa ; 

    @ManyToOne
    @JoinColumn(name="usuario_id", referencedColumnName="id", insertable=false, updatable=false)
    private Usuario    usuario ; 

    @OneToMany(mappedBy="vehiculo")
    private List<VehiculoEvaluacion> listOfVehiculoEvaluacion ; 

    @OneToMany(mappedBy="vehiculo")
    private List<Documento> listOfDocumento ; 

    @OneToMany(mappedBy="vehiculo")
    private List<LogEvaluacion> listOfLogEvaluacion ; 

    @ManyToOne
    @JoinColumn(name="tipo_vehiculo", referencedColumnName="nombre", insertable=false, updatable=false)
    private TipoVehiculo tipoVehiculo2 ; 


    /**
     * Constructor
     */
    public Vehiculo() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setMarca( String marca ) {
        this.marca = marca ;
    }
    public String getMarca() {
        return this.marca;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre ;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setPatente( String patente ) {
        this.patente = patente ;
    }
    public String getPatente() {
        return this.patente;
    }

    public void setModelo( String modelo ) {
        this.modelo = modelo ;
    }
    public String getModelo() {
        return this.modelo;
    }

    public void setLinea( String linea ) {
        this.linea = linea ;
    }
    public String getLinea() {
        return this.linea;
    }

    public void setFechaService( LocalDate fechaService ) {
        this.fechaService = fechaService ;
    }
    public LocalDate getFechaService() {
        return this.fechaService;
    }

    public void setUsuarioId( Integer usuarioId ) {
        this.usuarioId = usuarioId ;
    }
    public Integer getUsuarioId() {
        return this.usuarioId;
    }

    public void setColor( String color ) {
        this.color = color ;
    }
    public String getColor() {
        return this.color;
    }

    public void setEmpresaId( Integer empresaId ) {
        this.empresaId = empresaId ;
    }
    public Integer getEmpresaId() {
        return this.empresaId;
    }

    public void setTipoVehiculo( String tipoVehiculo ) {
        this.tipoVehiculo = tipoVehiculo ;
    }
    public String getTipoVehiculo() {
        return this.tipoVehiculo;
    }

    //--- GETTERS FOR LINKS
    public Empresa getEmpresa() {
        return this.empresa;
    } 

    public Usuario getUsuario() {
        return this.usuario;
    } 

    public List<VehiculoEvaluacion> getListOfVehiculoEvaluacion() {
        return this.listOfVehiculoEvaluacion;
    } 

    public List<Documento> getListOfDocumento() {
        return this.listOfDocumento;
    } 

    public List<LogEvaluacion> getListOfLogEvaluacion() {
        return this.listOfLogEvaluacion;
    } 

    public TipoVehiculo getTipoVehiculo2() {
        return this.tipoVehiculo2;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(marca);
        sb.append("|");
        sb.append(nombre);
        sb.append("|");
        sb.append(patente);
        sb.append("|");
        sb.append(modelo);
        sb.append("|");
        sb.append(linea);
        sb.append("|");
        sb.append(fechaService);
        sb.append("|");
        sb.append(usuarioId);
        sb.append("|");
        sb.append(color);
        sb.append("|");
        sb.append(empresaId);
        sb.append("|");
        sb.append(tipoVehiculo);
        return sb.toString(); 
    } 

}
