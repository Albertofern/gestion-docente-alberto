/**
 * 
 */
package com.ipartek.formacion.controller.formater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.service.interfaces.AlumnoServiceEJB;

/**
 * @author Alberto Fernandez
 *
 */
public class AlumnoConverter implements Converter<String, com.ipartek.formacion.persistence.Alumno>{

	@Autowired
	AlumnoServiceEJB aSe;
	
	@Override
	public com.ipartek.formacion.persistence.Alumno convert(String arg0) {
		return aSe.getById(Long.parseLong((String) arg0));

	}

}
