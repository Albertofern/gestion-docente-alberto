/**
 * 
 */
package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.alumno.AlumnoServiceRemote;
import com.ipartek.formacion.persistence.Alumno;

/**
 * @author Alberto
 *
 */

public interface AlumnoServiceEJB {
	
	public List<Alumno> getAll();
	
	public Alumno getById(long codigo);
	
	public void setAlumnoServiceRemote(AlumnoServiceRemote alumnoService);
}
