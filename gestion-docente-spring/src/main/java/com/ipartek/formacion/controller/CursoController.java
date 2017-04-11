package com.ipartek.formacion.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipartek.formacion.controller.validator.CursoValidator;
import com.ipartek.formacion.controller.validator.FileValidator;
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

	@Autowired
	private ServletContext servletContext;
	
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
	CursoValidator validator;
	
	
	@InitBinder("curso")
	public void initBinder(WebDataBinder binder, Locale locale) {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy")
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.addValidators(validator);//podemos añadirle más de una validación de spring
	}
	@InitBinder("fichero")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new FileValidator());
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
		model.addAttribute("listadoAlumnos",aSe.getAll()); 
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
		//List<Alumno> alumnos = aSe.getAll();
		mav.addObject("listadoAlumnos", aSe.getAll());
    	return mav;
    }


	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@Valid @RequestParam("fichero") MultipartFile file,
						@ModelAttribute(name="curso") @Valid Curso curso,
						BindingResult bindingResult, ModelMap model, RedirectAttributes redirectMap) throws IOException{
		String destino = "";
		//Mensaje mensaje = null;
		if (bindingResult.hasErrors()) {  
  			logger.trace("curso tiene errores");
			model.addAttribute("listadoProfesores", pSe.getAll());
			model.addAttribute("listadoClientes", cSe.getAll());
			model.addAttribute("listadoAlumnos", aSe.getAll());
			//mensaje = new Mensaje(MensajeType.MSG_TYPE_DANGER);
			//String txt = "Los datos de formulario contienen errores";
			//mensaje.setMsg(txt);
			destino = "cursos/cursoform";
		} else {
			destino = "redirect:/cursos"; 
			String txt ="";
			//obtengo el chorro de datos
			InputStream in = file.getInputStream();
			// /resources/docs
			String root = File.separator + "resources" + File.separator + "docs" + File.separator;
			// ruta absoluta del contexto de la aplicacion
			String ruta = servletContext.getRealPath(root);
			// Crearme el archivo fisico que no tiene nada con un 
			File destination = new File(ruta + file.getOriginalFilename());
			// Se copia el chorro de bits al archivo fisico
			FileUtils.copyInputStreamToFile(in, destination);
			//Guardo dentro del Curso --> Temario la ruta del fichero
			curso.setTemario(file.getOriginalFilename());
			logger.info(ruta);
			logger.info(file.getOriginalFilename());
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
	public String deleteCurso(@PathVariable("codigocurso") long id,Model model) {

	return "redirect:/cursos";
	}
	
}
