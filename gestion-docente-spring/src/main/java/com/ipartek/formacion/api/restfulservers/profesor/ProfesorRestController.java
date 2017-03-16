package com.ipartek.formacion.api.restfulservers.profesor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ipartek.formacion.dbms.persistence.Profesor;
import com.ipartek.formacion.service.interfaces.ProfesorService;

@RestController
@RequestMapping(value = "/api/profesores")
public class ProfesorRestController {

	private static final Logger LOG = LoggerFactory.getLogger(ProfesorRestController.class);

	@Autowired
	ProfesorService pS;

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Profesor> getById(@PathVariable("codigo") int id) {
		Profesor profesor = pS.getById(id);
		ResponseEntity<Profesor> response = null;
		if (profesor == null) {
			response = new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<Profesor>(profesor, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> getAll(){
		List<Profesor> profesores = pS.getAll();
		ResponseEntity<List<Profesor>> response = null;
		
		if (profesores == null || profesores.isEmpty()){
			response = new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT);
		}else{
			response = new ResponseEntity<List<Profesor>>(profesores, HttpStatus.OK);
		}
		return  response;	
	}
	
	public ResponseEntity<Void> create(@RequestBody Profesor profesor,
									UriComponentsBuilder ucBuilder){
		Profesor profedni = pS.getByDni(profesor.getDni());
		Profesor profenss = pS.getByNss(profesor.getnSS());
		
		ResponseEntity<Void> response = null;
		
		if(profedni != null || profenss != null){
			response = new ResponseEntity<Void>(HttpStatus.CONFLICT);	
		}else{
			try{
				Profesor aux = pS.create(profesor);
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(ucBuilder.path("/api/profesores/{codigo}").
						buildAndExpand(aux.getCodigo()).toUri());
				response = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			}catch (Exception e){
				response = new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);	
			}
		}
		return response;
	}
	
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Profesor> update(@PathVariable("codigo")int id,
								@RequestBody Profesor profesor){
		Profesor profe = pS.getById(id);
		ResponseEntity<Profesor> response = null;
		
		if(profe == null){
			response = new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}else{
			try{
				profe = pS.update(profesor);
				response = new ResponseEntity<Profesor>(profe, HttpStatus.ACCEPTED);
			}catch (Exception e){
				response = new ResponseEntity<Profesor>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		return response;
	}
	
	
	
	@RequestMapping(value= "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Profesor> deleteById(@PathVariable("codigo") int id){
		
		Profesor profe = pS.getById(id);
		ResponseEntity<Profesor> response = null;
		
		if (profe == null){
			response = new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}else{
			pS.delete(id);
			response = new ResponseEntity<Profesor>(HttpStatus.NO_CONTENT);
		}
		return response;	
	}

	
}
