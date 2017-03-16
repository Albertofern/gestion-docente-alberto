package com.ipartek.formacion.api.restfulclients;

import java.util.List;

import com.ipartek.formacion.dbms.persistence.Alumno;

public interface AlumnoRestClient {

	
	// la ruta donde consumo el recurso web
	final String URL ="http://localhost:8080/gestiondocente/api/alumnos";
	
	public List<Alumno> getAll();
	
	public Alumno getById(int codigo);
	
	public Alumno update(Alumno alumno);

	public Alumno create(Alumno alumno);
	
	public void delete(int codigo);
	

}
