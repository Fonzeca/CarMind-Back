/*
 * Created on 2021-10-19 ( 12:45:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.jpa.data;

import javax.persistence.EntityManager;

import com.mindia.carmind.entities.Vehiculos;

public class VehiculosData {

	private static Vehiculos entity ;

    public static void init(EntityManager em) {
    	// new entity instance
    	Vehiculos newEntity = new Vehiculos();
		newEntity.setId( Integer.valueOf(100) ) ;
		newEntity.setMarca( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		newEntity.setModelo( "AAAA" ) ;
		newEntity.setLinea( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		newEntity.setFechaService( java.sql.Date.valueOf("2001-06-22") ) ;
		newEntity.setUltimaEvaluacion( Integer.valueOf(100) ) ;
		newEntity.setColor( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;

		// save entity in database
        em.getTransaction().begin();
        Vehiculos managedEntity = (Vehiculos) em.merge(newEntity);
        em.getTransaction().commit();
        entity = managedEntity;
    }
	
    public static Vehiculos getEntity() {
    	return entity;
    }
}