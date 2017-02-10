package com.ipartek.formacion.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
										
	@Resource(name="alumnoValidator")   // == @qualifier/@qualifier("alumnoValidator")
	private Validator validator = null; // injecto el validador del servlet-context (bean) 
										// Articulo: INJECCIONES DE DEPENDENCIAS! EN EL CAMPUS!!
	
	// --------------------  Para el validador de SPRING  --------------------------
	
	@InitBinder // Esta anotacion alimenta el metodo init de ese Servlet
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
						new SimpleDateFormat("dd/MM/yyy"), false, 10));
	}
	
	// --------------------------- METODOS CRUD ------------------------------------
	
	
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
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAlumno(Model model, @ModelAttribute("alumno") @Validated Alumno alumno,
						BindingResult bindingResult) { //es "alumno" porque estaremos trabajando sobre ese mismo objeto!!!
		String destino = ""; // tiene que ir algun if. Aqui va la inset o la update
		
		if (bindingResult.hasErrors()){
			logger.info("alumno tiene errores");
			destino = "alumnos/alumno";
		} else {
			destino = "redirect:/alumnos"; // Que hace esto? Hace una redireccion a "public ModelAndView getAll()"  LO RECICLA el codigo de getAll()
			if(alumno.getCodigo() > alumno.CODIGO_NULO){
				logger.info(alumno.toString());
				aS.update(alumno);
			} else {
				logger.info(alumno.toString());
				aS.create(alumno);
				
			}
		}
		return destino;
	}
	
	
	@RequestMapping(value= "/{id}") // PARA estructurar la URL
	public ModelAndView getById(@PathVariable("id") int id) { // me parsea el id
		mav = new ModelAndView("alumnos/alumno");
		mav.addObject("alumno", aS.getById(id)); // falta el requestMaping para que sea procesado
		return mav;
	}
	
	
	@RequestMapping(value="/deleteAlumno/{id}") 
	public String delete(@PathVariable("id") int id){  // Cuando borro, mando el codigo
						// me parsea el id del: @RequestMapping(value="/deleteAlumno/(id)") 
		aS.delete(id);								   // Envia a AlumnoService
		return"redirect:/alumnos";  				   // Que hace esto? Hace una redireccion a "public ModelAndView getAll()"  LO RECICLA el codigo de getAll()
	}
	
	@RequestMapping(value = "/addAlumno")
	public String addAlumno(Model model){
		model.addAttribute("alumno", new Alumno());  //es identico al getbyid, este mandara un objeto en blanco no nulo y el getbyid uno objeto rellenado.
		return "alumnos/alumno";
	}
	
	
}
