package com.ipartek.formacion.dbms.persistence.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.service.interfaces.ProfesorService;

public class ProfesorExistsValidator implements ConstraintValidator<ProfesorExists, Object> {
	private static final Logger Logger = LoggerFactory.getLogger(ProfesorExistsValidator.class);
	private String code;
	private String key;
	
	@Autowired
	private ProfesorService pS;

	@Override
	public void initialize(ProfesorExists dniexits) {
		this.code = dniexits.code();
		this.key = dniexits.key();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext ctx) {
		// ctx.
		Logger.info(object.toString());
		boolean valid = true;
		try {
			Logger.info(object.toString());

			final String codeValue = BeanUtils.getProperty(object, code);
			final String keyValue = BeanUtils.getProperty(object, key);
			Object obj = null;
			if ("nSS".equalsIgnoreCase(key)) {
				obj = pS.getByNss(keyValue);
			} else if ("dni".equalsIgnoreCase(key)) {
				obj = pS.getByDni(keyValue);
			}

			valid = true;
		} catch (

		final Exception ignore) {
			// ignore
			valid = false;
		}
		return valid;
	}

}