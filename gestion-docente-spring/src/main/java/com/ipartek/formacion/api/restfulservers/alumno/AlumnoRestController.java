package com.ipartek.formacion.api.restfulservers.alumno;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@CrossOrigin(origins= "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value= "/api/alumnos")
public class AlumnoRestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AlumnoRestController.class);
	
	@Autowired
	AlumnoService aS;
	
	//	http://gestiondocente/api/alumnos/{1}
	//	PUT ----> UPDATE
	//	DELETE -> DELETE
	//  GET ----> GETBYID
	//	http://gestiondocente/api/alumno
	//	POST ---> GETALL
	//	GET	----> CREATE
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(validator);
	}
	
	@Resource(name ="alumnoValidator")
	Validator validator;
	// validaremos en el PUT y en el POST cuando se prevee que necesite validacion.
	
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Alumno> getById(@PathVariable("codigo") int id){
		Alumno alumno = aS.getById(id);
		ResponseEntity<Alumno> response = null;
		
		if(alumno == null){ //404
			response = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
			LOG.info("codigo alumno: "+id);
		}else{ //200   // el ResponseEntity usa el constructor con BODY que nos enviara el alumno!
			response = new ResponseEntity<Alumno>(alumno, HttpStatus.OK); 
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Alumno>> getAll(){
		List<Alumno> alumnos = aS.getAll();
		ResponseEntity<List<Alumno>> response = null;
		
		if (alumnos == null || alumnos.isEmpty()){  // si es nula o si esta vacia 
			response = new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT); //204
			LOG.info("Pasa por getAll()");
		}else{
			response = new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
		}
		
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			 			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
			 			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Void> create(@Valid @RequestBody Alumno alumno,
									UriComponentsBuilder ucBuilder){ // tengo que recivir el objeto serializado a traves de la uri
		
		Alumno alum = aS.getByDni(alumno.getDni());
		ResponseEntity<Void> response = null;
		
		if (alum != null){
			response = new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}else{
			// por si algun campo para hacer el create no esta rellenado y lo hemos requerido ! not null, syze...
			try{
				Alumno aux = aS.create(alumno);
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(ucBuilder.path("/api/alumnos/{codigo}").
						buildAndExpand(aux.getCodigo()).toUri());
				response = new ResponseEntity<Void>(headers,HttpStatus.CREATED);
			}catch (Exception e){
				response = new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
			}
			// Esto funciona pero no lo podriamos ver. Esta correcto pero para verlo tendria que pasar por el getById
			// si no reciclase el metodo getById le respuesta es <Alumno>
			//	response = new ResponseEntity<Alumno>(alumno, HttpStatus.CREATED); y el void del metodo por <Alumno>
			//	response = new ResponseEntity<Void>(HttpStatus.CREATED);
			// si quiero que se pase por el getById para reciclar codigo y mostrarlo...
			// Se manipulan los encabezados HTTP para llamar al metodo getById	
			
		}
		
		
		return response;
	}
	
	@RequestMapping(value = "/{codigo}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			 			MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.PUT, produces = {
						MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Alumno> update(@PathVariable("codigo")int id ,@Valid @RequestBody Alumno alumno){
		Alumno alum = aS.getById(id);
		ResponseEntity<Alumno> response = null;
		
		if(alum == null){
			response = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}else{
			// por si algun campo para hacer el update no esta rellenado y lo hemos requerido ! not null, syze...
			try{
				alum = aS.update(alumno);
				response = new ResponseEntity<Alumno>(alum, HttpStatus.ACCEPTED);
			}catch (Exception e){
				response = new ResponseEntity<Alumno>( HttpStatus.NOT_ACCEPTABLE);
			}
			
		}
		return response;
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Alumno> deleteById(@PathVariable("codigo") int id){
		Alumno alum = aS.getById(id);
		ResponseEntity<Alumno> response = null;
		if (alum == null){
			response = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}else{
			aS.delete(id);
			response = new ResponseEntity<Alumno>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
}
