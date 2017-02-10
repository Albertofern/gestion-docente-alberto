package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dbms.persistence.Alumno;

public class AlumnoValidator implements Validator {


	// -------- Sirve para definir que tipos de datos..
	
	@Override
	public boolean supports(Class<?> paramClass) {
		return Alumno.class.equals(paramClass);
	}

	// -------- Clases que implementaran un validador	
	// -------- OPERACIONES RELATIVAS A LA VALIDACION
	
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombreRequerido" ,"Tiene que introducir un nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "apellidosRequerido" ,"Tiene que introducir un apellido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "emailRequerido" ,"Tiene que introducir un email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "dniRequerido" ,"Tiene que introducir un dni");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "telefonoRequerido" ,"Tiene que introducir un telefono");
		// Para cubirnos de los datos que insertamos a la BBDD
		// Se le añadira el validation a todos los campos de la BBDD para que no metan campos en blanco "WhiteSpace"
		// Se le añadira el validation a todos los campos de la BBDD que le pusimos "not null"
		// Se le añadira el validation a los nombres para que tengas mas de dos caracteres.

		
		
		Alumno alum = (Alumno) obj;
		if(alum.getCodigo()<Alumno.CODIGO_NULO){
			errors.rejectValue("codigo", "valorNegativo",
								new Object[]{"'codigo'"}, "no puede ser menor que"+Alumno.CODIGO_NULO);
		}
		if (false){ // validación de la letra del DNI
			errors.rejectValue("dni", "letraDniIncorrecto", new Object[]{"'dni'"}, 
								"El DNI introducido es incorrecto");
		}
		




	}

}
