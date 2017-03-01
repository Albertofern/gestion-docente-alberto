package com.ipartek.formacion.service;




import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.curso.CursoServiceRemote;
import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;



@Service("cursoServiceImp")
public class CursoServiceImp implements CursoService {


	@Resource(name= "cursoServiceRemote")
	private CursoServiceRemote cursoServiceRemote;
	
	@Override
	public void setCursoServiceRemote(CursoServiceRemote cursoService) {
		this.cursoServiceRemote = cursoService;
	}

	@Override
	public Curso getById(long codigo) {
		return this.cursoServiceRemote.getById(codigo);
		//return new Curso();
	}

	@Override
	public List<Curso> getAll() {
		return cursoServiceRemote.getAll();
		//return new ArrayList<Curso>();
	}


	

}
