/**
 * 
 */
package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.service.interfaces.ClienteServiceEJB;

/**
 * @author Alberto Fernandez
 *
 */
public class ClienteConverter implements Converter<String, com.ipartek.formacion.persistence.Cliente>{
	
	@Autowired
	ClienteServiceEJB cSe;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteConverter.class);
	
	
	@Override
	public com.ipartek.formacion.persistence.Cliente convert(String arg0) {
		
		LOGGER.info(arg0.toString());
	
		
		return cSe.getById(Long.parseLong((String) arg0));
	}
	
	

}
