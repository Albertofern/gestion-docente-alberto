/**
 * 
 */
package com.ipartek.formacion.profesor;

import java.util.List;

import com.ipartek.formacion.persistence.Profesor;



/**
 * @author Alberto Fernandez
 *
 */
public interface ProfesorServiceRemote {

	
	public List<Profesor> getAll();
	public Profesor getById(long codigo);

	
	
}
