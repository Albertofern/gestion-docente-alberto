/**
 * 
 */
package com.ipartek.formacion.controller.formater;

/**
 * @author Alberto Fernandez
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.service.interfaces.ProfesorServiceEJB;

public class ProfesorConverter implements Converter<String, com.ipartek.formacion.persistence.Profesor> {
	
	@Autowired
	ProfesorServiceEJB pSe;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfesorConverter.class);

	@Override
	public com.ipartek.formacion.persistence.Profesor convert(String arg0) {

		LOGGER.info(arg0.toString());
		return pSe.getById(Long.parseLong((String) arg0));
	}

}
