/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.alumno.AlumnoServiceRemote;
import com.ipartek.formacion.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoServiceEJB;

/**
 * @author Alberto
 *
 */
@Service("alumnoServiceEJB")
public class AlumnoServiceEJBImp implements AlumnoServiceEJB {

	@Resource(name="alumnoServiceRemote")
	private AlumnoServiceRemote alumnoServiceRemote;
	
	
	@Override
	public List<Alumno> getAll() {
		return alumnoServiceRemote.getAll();
	}

	@Override
	public void setAlumnoServiceRemote(AlumnoServiceRemote alumnoService) {
		this.alumnoServiceRemote=alumnoService;
		
	}

	@Override
	public Alumno getById(long codigo) {
		return alumnoServiceRemote.getById(codigo);
	}

}
