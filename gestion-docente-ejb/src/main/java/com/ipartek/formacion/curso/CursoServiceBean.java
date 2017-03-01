package com.ipartek.formacion.curso;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Curso;

/**
 * Session Bean implementation class CursoServiceBean
 */
@Stateless(name="CursoServiceBean")
public class CursoServiceBean implements CursoServiceRemote {

	@PersistenceContext(unitName = "gestiondocente")
	private EntityManager entityManager;

	@Override
	public List<Curso> getAll() {
		TypedQuery<Curso> cursos = entityManager.createNamedQuery("curso.getAll",Curso.class);
		/* Se devuelve la lista de cursos.*/
		return cursos.getResultList();
	}

	@Override
	public Curso getById(long codigo) {
		Curso curso = entityManager.find(Curso.class, codigo);
		/* Se devuevle el curso.*/
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		EntityTransaction tx = entityManager.getTransaction(); 
		tx.begin();
		try {
			entityManager.persist(curso);
			/* Se devuevle el curso.*/
		}catch (Exception e){
			tx.rollback();
		}
		
		return curso;
	}

}
