package com.ipartek.formacion.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	// --------------------  Para el validador de SPRING  --------------------------
	
	@Resource(name="profesorValidator")   // ==@Autowired@Qualifier("profesorValidator")
	private Validator validator = null;
	
	
	// --------------------------- METODOS CRUD ------------------------------------
	
	@RequestMapping(method =RequestMethod.GET)
	public ModelAndView getAll() {
		mav =new ModelAndView("profesores/profesores"); // esto le engancha el .jsp AUTO (puede ser .xxx)
		//cargar la lista de profesores
		List<Profesor> profesores = pS.getAll(); // He creado el CRUD en la CAPA Service
		//engancharla al modelandview
		mav.addObject("listadoProfesores", profesores); // esto es request (se recoge de la request)
		logger.trace("Pasa por getAll()");
		return mav;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProfesor( Model model, @ModelAttribute("profesor") @Valid Profesor profesor, //@Valid para usar la validadion del standar de java
								BindingResult bindingResult) { //es "profesor" porque estaremos trabajando sobre ese mismo objeto!!!
		String destino = ""; // tiene que ir algun if. Aqui va la inset o la update
		
		if (bindingResult.hasErrors()){
			logger.info("profesor tiene errores");
			destino = "/profesores/profesor";
		} else {
			destino = "redirect:/profesores"; // Que hace esto? Hace una redireccion a "public ModelAndView getAll()"  LO RECICLA el codigo de getAll()
			if(profesor.getCodigo() > profesor.CODIGO_NULO){
				logger.info(profesor.toString());
				pS.update(profesor);
			} else {
				logger.info(profesor.toString());
				pS.create(profesor);
			}
		}
		return destino;
	}

	
	@RequestMapping(value= "/{id}") // PARA estructurar la URL
	public ModelAndView getById(@PathVariable("id") int id) { // me parsea el id
		mav = new ModelAndView("profesores/profesores");
		mav.addObject("profesor", pS.getById(id)); // falta el requestMaping para que sea procesado
		return mav;
	}
	

	@RequestMapping(value="/deleteProfesor/{id}") 
	public String delete(@PathVariable("id") int id){  // Cuando borro, mando el codigo
						// me parsea el id del: @RequestMapping(value="/deleteProfesor/(id)") 
		pS.delete(id);								   // Envia a ProfesorService
		return"redirect:/profesores";  				   // Que hace esto? Hace una redireccion a "public ModelAndView getAll()"  LO RECICLA el codigo de getAll()
	}
	
	@RequestMapping(value = "/addProfesor")
	public String addProfesor(Model model){
		model.addAttribute("profesor", new Profesor());  //es identico al getbyid, este mandara un objeto en blanco no nulo y el getbyid uno objeto rellenado.
		return "profesores/profesor";
	}
}
