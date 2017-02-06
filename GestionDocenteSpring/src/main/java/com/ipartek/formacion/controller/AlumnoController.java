package com.ipartek.formacion.controller;


import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	// --------------------------- METODOS CRUD -----------------------------------------------
	
	
	@RequestMapping(method =RequestMethod.GET)
	public ModelAndView getAll() {
		mav =new ModelAndView("alumnos/alumnos");
		//cargar la lista de alumnos
		List<Alumno> alumnos = aS.getAll(); // He creado el CRUD en la CAPA Service
		//engancharla al modelandview
		mav.addObject("listadoAlumnos", alumnos); // esto es request (se recoge de la request)
		logger.trace("Pasa por getAll()");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("alumno") Alumno alumno, Model model) { //es "alumno" porque estaremos trabajando sobre ese mismo objeto!!!
		String destino = ""; // tiene que ir algun if. Aqui va la inset o la update
		
		if(alumno.getCodigo() > alumno.CODIGO_NULO){
			aS.update(alumno);
		} else {
			aS.create(alumno);
		}
		
		return destino;
	}
	
	
	@RequestMapping(value= "/{id}") // PARA estructurar la URL
	public ModelAndView getById(@PathVariable("id") int id) { // me parsea el id
		mav = new ModelAndView("alumnos/alumnos");
		mav.addObject("alumno", aS.getById(id)); // falta el requestMaping para que sea procesado
		return mav;
	}
	
	
	@RequestMapping(value="/deleteAlumno/{id}") 
	public String delete(@PathVariable("id") int id){  // Cuando borro, mando el codigo
						// me parsea el id del: @RequestMapping(value="/deleteAlumno/(id)") 
		aS.delete(id);								   // Envia a AlumnoService
		return"redirect:/alumnos";  				   // Que hace esto? Hace una redireccion a "public ModelAndView getAll()"  LO RECICLE el codigo de getAll()
	}
	
	@RequestMapping(value = "/addAlumno")
	public String addAlumno(Model model){
		model.addAttribute("alumno", new Alumno());  //es identico al getbyid, este mandara un objeto en blanco no nulo y el getbyid uno objeto rellenado.
		return "alumnos/alumno";
	}
	
	
}
