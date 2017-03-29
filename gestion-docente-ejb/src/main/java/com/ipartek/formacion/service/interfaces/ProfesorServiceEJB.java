/**
 * 
 */
package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.persistence.Profesor;
import com.ipartek.formacion.profesor.ProfesorServiceRemote;

/**
 * @author Alberto Fernandez
 *
 */
public interface ProfesorServiceEJB {
	
	public List<Profesor> getAll();
	public Profesor getById(long codigo);
	public void setProfesorServiceRemote(ProfesorServiceRemote profesorService);

}
