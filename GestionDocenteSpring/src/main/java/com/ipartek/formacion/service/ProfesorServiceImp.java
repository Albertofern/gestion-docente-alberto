package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dbms.dao.interfaces.ProfesorDAO;
import com.ipartek.formacion.dbms.persistence.Profesor;
import com.ipartek.formacion.service.interfaces.ProfesorService;

@Service
public class ProfesorServiceImp implements ProfesorService {

	@Autowired // Con esto instancio la clase. 
	private ProfesorDAO profesorDao; // El objeto (BEN del root-context) que esta en el .xml
	
	
	@Override
	public Profesor create(Profesor profesor) {
		return profesorDao.create(profesor);
	}

	@Override
	public List<Profesor> getAll() {
		return profesorDao.getAll();
	}

	@Override
	public Profesor getById(int codigo) {
		return profesorDao.getById(codigo);
	}

	@Override
	public Profesor update(Profesor profesor) {
		return profesorDao.update(profesor);
	}

	@Override
	public void delete(int codigo) {
		profesorDao.delete(codigo);
		
	}

	@Override
	public void setProfesorDao(ProfesorDAO profesorDao) {
		this.profesorDao = profesorDao;
	}

}
