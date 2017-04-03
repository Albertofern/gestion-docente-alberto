package com.ipartek.formacion.service;




import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipartek.formacion.controller.HomeController;
import com.ipartek.formacion.curso.CursoServiceRemote;
import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;



@Service("cursoServiceImp")
public class CursoServiceImp implements CursoService {

	private static final Logger logger = LoggerFactory.getLogger(CursoServiceImp.class);

	@Resource(name= "cursoServiceRemote")
	private CursoServiceRemote cursoServiceRemote;
	
	@Override
	public void setCursoServiceRemote(CursoServiceRemote cursoService) {
		this.cursoServiceRemote = cursoService;
	}

	@Override
	public Curso getById(long codigo) {
		return cursoServiceRemote.getById(codigo);
	}

	@Override
	public List<Curso> getAll() {
		return cursoServiceRemote.getAll();
		//return new ArrayList<Curso>();
	}
	
	@Override
	public Curso create(Curso curso) {
		logger.info(curso.toString());
		return cursoServiceRemote.create(curso);
	}


	@Override
	public Curso update(Curso curso) {
		logger.info(curso.getAlumnos().toString());
		return cursoServiceRemote.update(curso);
	}


	@Transactional
	@Override
	public void delete(long codigo) {
		Curso curso = cursoServiceRemote.getById(codigo);
		curso.setActivo(false);
		cursoServiceRemote.delete(codigo);
		
	}




	

}
