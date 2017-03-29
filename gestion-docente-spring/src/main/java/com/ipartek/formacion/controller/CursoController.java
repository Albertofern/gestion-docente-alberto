package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;
import com.ipartek.formacion.service.interfaces.ProfesorService;

@Controller
@RequestMapping("/cursos")    
public class CursoController { // aqui porcesaremos las peticiones de las vistas

	private static final Logger logger=LoggerFactory.getLogger(CursoController.class);
	private ModelAndView mav = null;
	
	@Autowired
	private CursoService cS;
	@Autowired
	private ProfesorService pS;
	
	
	
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
	
    @RequestMapping(value ="/editarCurso/{id}")
    /* Metodo que añade un cusro pasado por parametro.*/
    public String editarCurso(@PathVariable("id") long id,Model model){
    	/* Se le pasa al modelo el curso recien creado.*/
    	model.addAttribute("curso",cS.getById(id));
    	/* Se redirecciona el formulario de curso.*/
    	return "cursos/cursoform";
    }


	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("curso") Curso curso){
		mav=new ModelAndView("cursos/cursos");

		try {
			if(curso.getCodigo()>0){
				cS.update(curso);

			} else {
			
				cS.create(curso);
				
			}
			mav.addObject("mensaje", "mensaje.ok");

		}catch(Exception e){
			logger.info(e.getMessage());
			mav.addObject("mensaje","mensaje.error");
		}
		
		return mav;
	}
	
	
}
