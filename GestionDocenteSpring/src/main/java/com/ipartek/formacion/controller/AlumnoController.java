package com.ipartek.formacion.controller;


import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Controller
@RequestMapping(value="/alumnos")
public class AlumnoController {
	
	@Inject // es lo mismo que @autowired
	private AlumnoService aS;
	private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	ModelAndView mav = null;
	
	@RequestMapping( method =RequestMethod.GET)
	public ModelAndView getAll() {
		mav =new ModelAndView("alumnos/alumnos");
		//cargar la lista de alumnos
		List<Alumno> alumnos = aS.getAll(); // He creado el CRUD en la CAPA Service
		//engancharla al modelandview
		mav.addObject("listadoAlumnos", alumnos); // esto es request (se recoge de la request)
		logger.trace("Pasa por getAll()");
		return mav;
	}

}
