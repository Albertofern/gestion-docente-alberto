/**
 * 
 */
package com.ipartek.formacion.profesor;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistence.Profesor;



/**
 * @author Alberto Fernandez
 *
 */
@Remote
public interface ProfesorServiceRemote {

	
	public List<Profesor> getAll();
	public Profesor getById(long codigo);

	
	
}
