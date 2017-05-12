package com.ipartek.formacion.controller.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MyMappingExceptionResolver extends SimpleMappingExceptionResolver {

	// Boton derecho --> override/implements method 
	// Elegir el segundo metodo **AbstractHandlerExceptionResolver** y luego ***buildLogMessage***
	
	
	/* (non-Javadoc)
	 * 
	 * @see 
	 * org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver#
	 * buildLogMessage(java.lang.Exception,
	 * javax.servlet.http.HttpServletRequest)
	 * 
	 */
	@Override
	protected String buildLogMessage(Exception ex, HttpServletRequest request) {
		
		return "Gestion Docente Exception" + ex.getLocalizedMessage();
	}

	//boton derecho --> override method 
	
	
	
}
