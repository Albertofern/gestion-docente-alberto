package com.ipartek.formacion.controller.validator;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.service.Util;
import com.ipartek.formacion.service.interfaces.AlumnoService;

public class AlumnoValidator implements Validator {

	// ------------------------------ Constantes ----------------------------------------
	
	// ------------------------------  NOMBRE  ----------------------------------------
	@Value("${alumno.nombre.size.min}")
 	private int nombreTamMin;
	@Value("${alumno.nombre.size.max}")
 	private int nombreTamMax;
	// ------------------------------ APELLIDOS ----------------------------------------
	@Value("${alumno.apellidos.size.min}")
	private int apellidosTamMin;
	@Value("${alumno.apellidos.size.max}")
	private int apellidosTamMax;
	// ------------------------------ DIRECCION ----------------------------------------
	@Value("${alumno.direccion.size.min}")
	private int direccionTamMin;
	@Value("${alumno.direccion.size.max}")
	private int direccionTamMax;
	// ----------------------------- POBLACION ------------------------------------------
	@Value("${alumno.poblacion.size.min}")
	private int poblacionTamMin;
	@Value("${alumno.poblacion.size.max}")
	private int poblacionTamMax;
	// ----------------------------- CODIGOPOSTAL -------------------------------------
	@Value("${alumno.codigopostal.size}")
	private int codigoPostalTam;
	// ----------------------------- EMAIL ----------------------------------------------
	@Value("${alumno.telefono.size}")
	private int emailTam;
	
	@Inject
	AlumnoService aS;
	
	// -------- Sirve para definir que tipos de datos..
	
	@Override
	public boolean supports(Class<?> paramClass) {
		return Alumno.class.equals(paramClass);
	}

	// -------- Clases que implementaran un validador	
	// -------- OPERACIONES RELATIVAS A LA VALIDACION
	
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "formAlumno.nombreRequerido" ,"Tiene que introducir un nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "formAlumno.apellidosRequerido" ,"Tiene que introducir un apellido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "formAlumno.emailRequerido" ,"Tiene que introducir un email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "formAlumno.dniRequerido" ,"Tiene que introducir un dni");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "formAlumno.telefonoRequerido" ,"Tiene que introducir un telefono");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"fNacimiento", "formAlumno.fNacimiento" , "Tiene que introducir la fecha de nacimiento");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,"direccion", "formAlumno.poblacion", "Tiene que introducir una poblacion");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"codigoPostal", "formAlumno.codigopostal", "Tiene que introducir una poblacion");
		
		// Para cubirnos de los datos que insertamos a la BBDD
		// Se le añadira el validation a todos los campos de la BBDD para que no metan campos en blanco "WhiteSpace"
		// Se le añadira el validation a todos los campos de la BBDD que le pusimos "not null"
		// Se le añadira el validation a los nombres para que tengas mas de dos caracteres.

		
		
		Alumno alum = (Alumno) obj;
		if(alum.getCodigo()<Alumno.CODIGO_NULO){
			errors.rejectValue("codigo", "valorNegativo",
								new Object[]{"'codigo'"}, "no puede ser menor que"+Alumno.CODIGO_NULO);
		}
		
		if (!Util.validarTelefono(alum.getTelefono())) {
					errors.rejectValue("telefono", "form.telefonoIncorrecto", new Object[] { "'telefono'" },
							"el telefono introducido es incorrecto");
		}
		if (!Util.validarDni(alum.getDni().toUpperCase())) {// validación de la // letra del DNI												
					errors.rejectValue("dni", "form.letraDniIncorrecta", new Object[] { "'dni'" },
								"El DNI introducido es incorrecto");
		}
		if (alum.getNombre().length() < nombreTamMin || alum.getNombre().length() > nombreTamMax) {
					errors.rejectValue("nombre", "form.longitudNombreIncorrecta", new Object[] { nombreTamMin,nombreTamMax },
								"El nombre tiene que ocupar entre 3 y 50 caracteres.");
		}
		
		if (alum.getApellidos().length() < apellidosTamMin || alum.getApellidos().length() > apellidosTamMax) {
					errors.rejectValue("apellidos", "form.longitudNombreIncorrecta", new Object[] { apellidosTamMin,apellidosTamMax },
								"Los dos apellidos tienen que ocupar entre 7 y 250 caracteres.");
		}	
		
		if (alum.getDireccion().length() < direccionTamMin || alum.getDireccion().length() > direccionTamMax) {
					errors.rejectValue("direccion", "form.longitudDireccionIncorrecta", new Object[] { direccionTamMin,direccionTamMax },
							"La dirección tiene que tener una longitud entre 10 y 250 caracteres.");
		}
		if (alum.getPoblacion().length() < poblacionTamMin || alum.getPoblacion().length() > poblacionTamMax) {
			 		errors.rejectValue("poblacion", "form.longitudPoblacionIncorrecta", new Object[] { poblacionTamMin,poblacionTamMax },
							"La poblacion tiene que tener una longitud entre 4 y 150 caracteres.");
		}
			
		if (alum.getCodigo() > 50 && !Util.validarCodigoPostal(alum.getCodigoPostal())) {
					errors.rejectValue("codigoPostal", "form.formatoCodigoPostalIncorrecto", new Object[] { codigoPostalTam },
							"El código postal introducido no es correcto.");
		}
		if (!Util.validarEmail(alum.getEmail())) {
			errors.rejectValue("email", "form.formatoEmailIncorrecto", new Object[] { "'email'" },
					"El email introducido no es correcto.");
		}
		
		
		
		if (alum.getCodigo() == Alumno.CODIGO_NULO && aS.getByDni(alum.getDni()) != null) {
			errors.rejectValue("dni", "form.dniExiste", new Object[] { alum.getDni() },
					"el dni ya existe en la base de datos");

		}
		




	}

}
