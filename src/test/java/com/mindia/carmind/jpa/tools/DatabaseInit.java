/*
 * Created on 2021-10-19 ( 12:45:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.mindia.carmind.jpa.tools;

import javax.persistence.EntityManager;

import com.mindia.carmind.jpa.data.EmpresasData;
import com.mindia.carmind.jpa.data.EvaluacionesData;
import com.mindia.carmind.jpa.data.EvaluacionesPreguntasData;
import com.mindia.carmind.jpa.data.LogEvaluacionesData;
import com.mindia.carmind.jpa.data.LogPreguntasData;
import com.mindia.carmind.jpa.data.PreguntasData;
import com.mindia.carmind.jpa.data.SeccionesData;
import com.mindia.carmind.jpa.data.UsuariosData;
import com.mindia.carmind.jpa.data.VehiculosData;

/**
 * Database initialization before unit tests
 * 
 * @author Telosys
 *
 */
public class DatabaseInit {

    public static void init(EntityManager em) {

		// Disable referential integrity
    	em.getTransaction().begin();
    	em.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
    	em.getTransaction().commit();

		// Init data for all entities
		EmpresasData.init(em);
		EvaluacionesData.init(em);
		EvaluacionesPreguntasData.init(em);
		LogEvaluacionesData.init(em);
		LogPreguntasData.init(em);
		PreguntasData.init(em);
		SeccionesData.init(em);
		UsuariosData.init(em);
		VehiculosData.init(em);

		// Enable referential integrity
    	em.getTransaction().begin();
    	em.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    	em.getTransaction().commit();
    }

}
