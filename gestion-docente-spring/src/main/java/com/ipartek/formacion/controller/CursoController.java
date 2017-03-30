package com.ipartek.formacion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.persistence.Profesor;
import com.ipartek.formacion.service.interfaces.CursoService;

import com.ipartek.formacion.service.interfaces.ProfesorServiceEJB;

@Controller
@RequestMapping("/cursos")    
public class CursoController { // aqui porcesaremos las peticiones de las vistas

	private static final Logger logger=LoggerFactory.getLogger(CursoController.class);
	private ModelAndView mav = null;
	
	@Autowired
	private CursoService cS;
	@Autowired
	private ProfesorServiceEJB pSe;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

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
		model.addAttribute("curso", new Curso());
		return "cursos/cursoform";
	}
	
    @RequestMapping(value ="/editCurso/{id}")
    /* Metodo que añade un cusro pasado por parametro.*/
    public String editarCurso(@PathVariable("id") long id,Model model){
    	Curso cur = cS.getById(id);
    	Curso curso = cS.update(cur);
    	List<Profesor> profesores = pSe.getAll();
    	//List<Cliente> clientes = cl.getAll();
    	model.addAttribute("curso",curso);
    	model.addAttribute("listadoProfesores", profesores);
    	//model.addAttribute("listadoClientes", clientes);
    	/* Se redirecciona el formulario de curso.*/
    	return "cursos/cursoform";
    }


	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model,@ModelAttribute("curso") @Valid Curso curso,BindingResult bindingResult){
		Curso cur = null;
		String destino = " ";
		if (bindingResult.hasErrors()) {
			  
  			logger.trace("curso tiene errores");
  			destino = "cursos/cursoform";
			model.addAttribute("listadoProfesores", pSe.getAll());
			//model.addAttribute("listadoClientes", cl.getAll());
			} else {
				destino = "redirect:/cursos";
				 
	 			if (curso.getCodigo() > -1) {
	 				logger.info(curso.toString());
	 				cur = cS.update(curso);
	 			} else {
	 				logger.info(curso.toString());
	 				cur = cS.create(curso);
	 			}
	 			model.addAttribute("curso", cur);
	 		}
	 		return destino;
	 
	 	}
		@RequestMapping(value = "/deleteCurso/{codigo}")
	 	public String deleteCurso(@PathVariable("codigo") long codigo) {
	 
	 		cS.delete(codigo);
	 
	 		return "redirect:/cursos";
	 	}
	
}
