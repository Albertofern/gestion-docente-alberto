package com.ipartek.formacion.curso;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Alumno;
import com.ipartek.formacion.persistence.Curso;

/**
 * Session Bean implementation class CursoServiceBean
 */
@Stateless(name="cursoServiceBean")
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
		StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("curso.getAlumnos");
		//spq.setParameter(1, curso.getCodigo());
		spq.setParameter(1, codigo);  //indistintamente
		List<Alumno> alumnos = (List<Alumno>)spq.getResultList();
		curso.setAlumnos(alumnos); // lo coge del setter de la clase Curso(common)
		return curso;
	}

	// el metodo try catch es lo mismo que usar en la CAPA servide del proyecto spring la anotacion @transactional.
	
	@Override
	public Curso update(Curso curso) {
		//EntityTransaction tx = entityManager.getTransaction(); 
		//tx.begin();
		try {
			entityManager.merge(curso);
			/* Se devuevle el curso.*/
		//	tx.commit();
		}catch (Exception e){
		//	tx.rollback();
		}	
		return curso;
	}
	
	@Override
	public Curso create(Curso curso) {
		//EntityTransaction tx = entityManager.getTransaction(); 
		//tx.begin();
		try {
			entityManager.persist(curso);
			/* Se devuevle el curso.*/
			//tx.commit();
			entityManager.flush();
		}catch (Exception e){
			//tx.rollback();
		}	
		return curso;
	}
	
	@Override
	public void delete(long codigo) {
		//EntityTransaction tx = entityManager.getTransaction(); 
		//tx.begin();
		try {
			entityManager.remove(entityManager.find(Curso.class, codigo));
			/* Se devuevle el curso.*/
			//tx.commit();
		}catch (Exception e){
			//tx.rollback();
		}	
	}




}
