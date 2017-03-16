package com.ipartek.formacion.api.restfulservers.alumno.configuration;

import javax.servlet.Filter;


import com.ipartek.formacion.api.restfulservers.CORSFilter;

// Para hacer esta clase; En superclass -->  browse.. --> y buscar : AbstractAnnotationConfigDispatcherServletInitializer para que extienda de ella.

public class AlumnoRestInitializer  {


	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AlumnosRestControllerConfiguration.class};
	}


	protected Class<?>[] getServletConfigClasses() {
		return null;
	}


	protected String[] getServletMappings() {
		return new String[]{"/"};
	}


	protected Filter[] getServletFilters() {
		Filter[] filter = {new CORSFilter()};
		return filter;
	}

}
