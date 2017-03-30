/**
 * 
 */
package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.curso.CursoServiceRemote;
import com.ipartek.formacion.persistence.Curso;

/**
 * @author Alberto Fernandez
 *
 */
public interface CursoServiceEJB {

	public List<Curso> getAll();
	public Curso getById(long codigo);
	public void setCursoServiceRemote(CursoServiceRemote cursoService);
	
	
}
