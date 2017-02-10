package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dbms.persistence.Cliente;

public class ClienteValidator implements Validator{

	@Override
	public boolean supports(Class<?> paramClass) {
		return Cliente.class.equals(paramClass);
	}

	// -------- Clases que implementaran un validador	
	// -------- OPERACIONES RELATIVAS A LA VALIDACION
	
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombreRequerido" ,"Tiene que introducir un nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion", "direccionRequerido" ,"Tiene que introducir un direccion");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "emailRequerido" ,"Tiene que introducir un email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "identificador", "identificadorRequerido" ,"Tiene que introducir un identificador");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "telefonoRequerido" ,"Tiene que introducir un telefono");
		
		
	
	}

}
