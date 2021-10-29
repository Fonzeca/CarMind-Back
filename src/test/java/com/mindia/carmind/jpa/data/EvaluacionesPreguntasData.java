/*
 * Created on 2021-10-19 ( 12:45:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.jpa.data;

import javax.persistence.EntityManager;

import com.mindia.carmind.entities.EvaluacionesPreguntas;

public class EvaluacionesPreguntasData {

	private static EvaluacionesPreguntas entity ;

    public static void init(EntityManager em) {
    	// new entity instance
    	EvaluacionesPreguntas newEntity = new EvaluacionesPreguntas();
		newEntity.setId( Integer.valueOf(100) ) ;
		newEntity.setEvaluacion( Integer.valueOf(100) ) ;
		newEntity.setPregunta( Integer.valueOf(100) ) ;

		// save entity in database
        em.getTransaction().begin();
        EvaluacionesPreguntas managedEntity = (EvaluacionesPreguntas) em.merge(newEntity);
        em.getTransaction().commit();
        entity = managedEntity;
    }
	
    public static EvaluacionesPreguntas getEntity() {
    	return entity;
    }
}