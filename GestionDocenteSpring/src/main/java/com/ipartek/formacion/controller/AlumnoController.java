package com.ipartek.formacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/alumnos")
public class AlumnoController {
	
	ModelAndView mav = null;
	
	@RequestMapping( method =RequestMethod.GET)
	public ModelAndView getAll() {
		mav =new ModelAndView("home");
		
		return mav;
	}

}
