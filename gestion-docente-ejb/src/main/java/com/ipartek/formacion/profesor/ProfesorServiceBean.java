/**
 * 
 */
package com.ipartek.formacion.profesor;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.persistence.Profesor;

/**
 * @author Alberto Fernandez
 *
 */

@Stateless(name="profesorServiceBean")
public class ProfesorServiceBean implements ProfesorServiceRemote{

	@PersistenceContext(unitName = "gestiondocente")
	private EntityManager entityManager;
	
	@Override
	public List<Profesor> getAll() {
		TypedQuery<Profesor> profesores = entityManager.createNamedQuery("profesor.getAll", Profesor.class);
		return profesores.getResultList();
	}

	@Override
	public Profesor getById(long codigo) {
		Profesor profesor = entityManager.find(Profesor.class, codigo);
		StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("profesor.getCursos");
		spq.setParameter(1, codigo);
		List<Curso> cursos = (List<Curso>)spq.getResultList();
		profesor.setCursos(cursos);
		return profesor;
	}




}
