package com.ipartek.formacion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.persistence.Alumno;
import com.ipartek.formacion.persistence.Cliente;
import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.persistence.Profesor;
import com.ipartek.formacion.service.interfaces.AlumnoServiceEJB;
import com.ipartek.formacion.service.interfaces.ClienteServiceEJB;
import com.ipartek.formacion.service.interfaces.CursoService;

import com.ipartek.formacion.service.interfaces.ProfesorServiceEJB;

@Controller
@RequestMapping("/cursos")    
public class CursoController { // aqui porcesaremos las peticiones de las vistas

	private static final Logger logger=LoggerFactory.getLogger(CursoController.class);
	private ModelAndView mav;
	
	@Autowired
	private CursoService cS;
	@Autowired
	private ProfesorServiceEJB pSe;
	@Autowired
	private ClienteServiceEJB cSe;
	@Autowired
	private AlumnoServiceEJB aSe;
	
	@Resource(name = "cursoValidator")
 	Validator validator = null;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.addValidators(validator);//podemos añadirle más de una validación de spring
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model){
		model.addAttribute("listadoCursos", cS.getAll());
		return "cursos/cursos";
	}
	
	@RequestMapping(value="/{codigo}")
	public String getById(@PathVariable("codigo") long codigo, Model model) {
		model.addAttribute("curso", cS.getById(codigo));
		return "cursos/curso";
	}
	
	// funcionalidades
	
	@RequestMapping(value="/{codigocurso}/alumnos/{codigoalumno}")
	public ModelAndView getAlumnoByCurso(@PathVariable("codigocurso")long codigocurso,
			@PathVariable("codigoalumno")long codigoalumno){
		return mav;
	}

	
	@RequestMapping(value="/addCurso")
	public String addCurso(Model model){
		model.addAttribute("curso",new Curso());
		model.addAttribute("listadoProfesores",pSe.getAll()); 
		model.addAttribute("listadoClientes",cSe.getAll()); 
		model.addAttribute("listadoClientes",aSe.getAll()); 
		/*
		mav = new ModelAndView("/cursos/cursoform")
		Curso curso = new Curso();
		curso.setActivo(true);
		mav.addObject("curso", curso);
		List<Profesor> profesores =pSe.getAll();
 		mav.addObject("listadoProfesores", profesores);
 		List<Cliente> clientes = cSe.getAll();
		mav.addObject("listadoClientes", clientes);
		List<Alumno> alumnos = aSe.getAll();
		mav.addObject("listadoAlumnos", alumnos);
 		return mav;
		*/
 		return "cursos/cursoform";
	}
	
    @RequestMapping(value ="/editCurso/{codigocurso}", method= RequestMethod.GET)
    public ModelAndView editarCurso(@PathVariable("codigocurso") long codigocurso){
    	mav = new ModelAndView("/cursos/cursoform");
 		Curso curso = cS.getById(codigocurso);
 		mav.addObject("curso", curso);
 		List<Profesor> profesores = pSe.getAll();
 		mav.addObject("listadoProfesores", profesores);
 		List<Cliente> clientes=cSe.getAll();
		mav.addObject("listadoClientes", clientes);
		List<Alumno> alumnos = aSe.getAll();
		mav.addObject("listadoAlumnos", alumnos);
    	return mav;
    }


	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute(name="curso") @Valid Curso curso,
						BindingResult bindingResult, ModelMap model){
		String destino = "";
		if (bindingResult.hasErrors()) {  
  			logger.trace("curso tiene errores");
			model.addAttribute("listadoProfesores", pSe.getAll());
			model.addAttribute("listadoClientes", cSe.getAll());
			model.addAttribute("listadoAlumnos", aSe.getAll());
			destino = "cursos/cursoform";
		} else {
			destino = "redirect:/cursos"; 
	 		if (curso.getCodigo() >  Curso.CODIGO_NULO) {
	 			logger.info(curso.toString());
	 			cS.update(curso);
	 		} else {
	 			logger.info(curso.toString());
	 			cS.create(curso);
	 		} 	
	 	}
	 	return destino;
	}
	
	
	@RequestMapping(value = "/deleteCurso/{codigocurso}")
	public String deleteCurso(@PathVariable("codigocurso") long id) {

	return "redirect:/cursos";
	}
	
}
