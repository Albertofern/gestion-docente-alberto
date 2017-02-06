package com.ipartek.formacion.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dbms.persistence.Profesor;
import com.ipartek.formacion.service.interfaces.ProfesorService;


@Controller
@RequestMapping(value="/profesores")
public class ProfesorController {
	
	
	@Inject
	private ProfesorService pS;
	private static final Logger logger = LoggerFactory.getLogger(ProfesorController.class);
	ModelAndView mav = null;
	
	@RequestMapping(method =RequestMethod.GET)
	public ModelAndView getAll() {
		mav =new ModelAndView("profesores/profesores");
		//cargar la lista de profesores
		List<Profesor> profesores = pS.getAll(); // He creado el CRUD en la CAPA Service
		//engancharla al modelandview
		mav.addObject("listadoProfesores", profesores); // esto es request (se recoge de la request)
		logger.trace("Pasa por getAll()");
		return mav;
	}
			
	

}
