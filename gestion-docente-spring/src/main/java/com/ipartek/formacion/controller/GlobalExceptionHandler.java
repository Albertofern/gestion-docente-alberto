package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice 
public class GlobalExceptionHandler {
	private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(SQLException.class) // esta controloara a nivel de todo el proyecto
	public String HandlerSQLexception(HttpServletRequest request, Exception ex){
		logger.error("SQLException URL: " + request.getRequestURL());
		logger.error("Mensaje: " + ex.getMessage()); //Cuando da errores en BBDD no se dan DATOS
		
		return "database_error";
	}
	
	// asociado a un error input output **(a la hora de subir un archivo o no encontrar una carpeta)**
	
	// Input Output --> I O Exception --> IOException
	
	//lo controloremos a traves del contesto de spring mediante una clase que heredara de SimpleMappingExceptionResolver
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IO Exception lanzada")
	@ExceptionHandler(IOException.class)
	public void handlerIOException(){
		
		logger.error("Se ha ejecutado una excepcion de tipo IOException");
		
	}
	
	
	
	
	
}
