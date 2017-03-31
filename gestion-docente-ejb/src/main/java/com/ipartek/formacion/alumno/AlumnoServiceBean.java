package com.ipartek.formacion.alumno;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Alumno;

/**
 * Session Bean implementation class AlumnoServiceBean
 */
@Stateless(name="alumnoServiceBean")
public class AlumnoServiceBean implements AlumnoServiceRemote {
	
	@PersistenceContext(unitName = "gestiondocente")
	private EntityManager entityManager;
    

	@Override
	public List<Alumno> getAll() {
		TypedQuery<Alumno> palumnos = entityManager.createNamedQuery("alumno.getAll", Alumno.class);
		return palumnos.getResultList();
	}

}
