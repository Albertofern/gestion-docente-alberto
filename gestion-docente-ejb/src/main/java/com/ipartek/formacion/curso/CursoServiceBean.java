package com.ipartek.formacion.curso;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.ipartek.formacion.persistence.Curso;





/**
 * Session Bean implementation class CursoServiceBean
 */
@Stateless(name="cursoServiceBean")//lo que figura en el name de presistence.xml de jpa para el tag persistence-unit
public class CursoServiceBean implements CursoServiceRemote {
	
	private static final Logger LOGGER = Logger.getLogger(CursoServiceBean.class);

	@PersistenceContext(unitName = "gestiondocente")
	private EntityManager entityManager;
	
	/**
	 * 
	 */
	public CursoServiceBean() {
	
	}

	@Override
	public List<Curso> getAll() {
		TypedQuery<Curso> cursos = entityManager.createNamedQuery("curso.getAll",Curso.class);
		/* Se devuelve la lista de cursos.*/
		return cursos.getResultList();
	}

	@Override
	public Curso getById(long codigo) {
		Curso curso = entityManager.find(Curso.class, codigo);
		/*
		StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("curso.getAlumnos");
		spq.setParameter(1, curso.getCodigo());
		//spq.setParameter(1, codigo);  //indistintamente
		List<Alumno> alumnos = (List<Alumno>)spq.getResultList();
		curso.setAlumnos(alumnos); // lo coge del setter de la clase Curso(common)
		*/
		return curso;
	}

	// el metodo try catch es lo mismo que usar en la CAPA servide del proyecto spring la anotacion @transactional.
	
	@Override
	public Curso update(Curso curso) {
		//EntityTransaction tx = entityManager.getTransaction(); 
		//tx.begin();
		//try {
		//	LOGGER.info(curso.toString()+" "+curso.getAlumnos());
			curso = entityManager.merge(curso);
			/* Se devuevle el curso.*/
		//	tx.commit();
		//}catch (Exception e){
			//LOGGER.error(e.getMessage());	
		//	}	
		return curso;
	}
	
	@Override
	public Curso create(Curso curso) {
		//EntityTransaction tx = entityManager.getTransaction(); 
		//tx.begin();
		//try {
			curso = entityManager.merge(curso);
			/* Se devuevle el curso.*/
			//tx.commit();
		//}catch (Exception e){
		//	LOGGER.error(e.getMessage());	
		//}	
		return curso;
	}
	
	@Override
	public void delete(long codigo) {
		//EntityTransaction tx = entityManager.getTransaction(); 
		//tx.begin();
		//try {
			entityManager.remove(entityManager.find(Curso.class, codigo));
			/* Se devuevle el curso.*/
			//tx.commit();
		//}catch (Exception e){
		//	LOGGER.error(e.getMessage());	
		//}	
	}




}
