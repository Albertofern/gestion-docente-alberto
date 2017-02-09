package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dbms.persistence.Profesor;

public class ProfesorValidator implements Validator {

	
	
	@Override
	public boolean supports(Class<?> paramClass) {
		return Profesor.class.equals(paramClass);
	}

	
	// -------- Clases que implementaran un validador	
	// -------- OPERACIONES RELATIVAS A LA VALIDACION
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "505" ,"Tiene que introducir un nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "505" ,"Tiene que introducir un apellido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "505" ,"Tiene que introducir un email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "505" ,"Tiene que introducir un dni");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nss", "505" ,"Tiene que introducir un nss");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "505" ,"Tiene que introducir un telefono");
		
		
		
		Profesor prof = (Profesor) obj;
		if(prof.getCodigo()<Profesor.CODIGO_NULO){
			errors.rejectValue("codigo", "valorNegativo",
								new Object[]{"'codigo'"}, "no puede ser menor que"+Profesor.CODIGO_NULO);
		}
		if (1 != 1) {// validación de la letra del DNI
					errors.rejectValue("dni", "letraDniIncorrecta", new Object[] { "'dni'" },
							"el DNI introducido es incorrecto");
		
		}
	}

}
