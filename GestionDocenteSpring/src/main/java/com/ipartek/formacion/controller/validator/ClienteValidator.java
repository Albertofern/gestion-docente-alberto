package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dbms.persistence.Cliente;
import com.ipartek.formacion.service.Util;

public class ClienteValidator implements Validator{

	@Override
	public boolean supports(Class<?> paramClass) {
		return Cliente.class.equals(paramClass);
	}

	// -------- Clases que implementaran un validador	
	// -------- OPERACIONES RELATIVAS A LA VALIDACION
	
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "formCliente.nombreRequerido" ,"Tiene que introducir un nombre");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "formAlumno.apellidosRequerido", "Tiene que introducir los apellidos");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion", "formCliente.direccionRequerido" ,"Tiene que introducir un direccion");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "poblacion", "formCliente.poblacion", "Tiene que introducir una poblacion");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "formCliente.emailRequerido" ,"Tiene que introducir un email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "identificador", "formCliente.IdentificadorRequerido" ,"Tiene que introducir un Identificador");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "formCliente.telefonoRequerido" ,"Tiene que introducir un telefono");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoPostal", "formCliente.codigopostal", "Tiene que introducir un codigo Postal");
		
		Cliente cliente = (Cliente) obj;
		if (cliente.getCodigo() > 50 && !Util.validarCodigoPostal(cliente.getCodigoPostal())) {
			errors.rejectValue("codigopostal", "form.formatoCodigoPostalIncorrecto", new Object[] { "'codigopostal'" },
					"El código postal introducido no es correcto.");
		}
		if (!Util.validarEmail(cliente.getEmail())) {
			errors.rejectValue("email", "form.formatoEmailIncorrecto", new Object[] { "'email'" },
					"El email introducido no es correcto.");
		}
		if (!Util.validarTelefono(cliente.getTelefono())) {
			errors.rejectValue("telefono", "form.telefonoIncorrecto", new Object[] { "'telefono'" },
					"El telefono introducido es incorrecto");
		}
		if (cliente.getDireccion().length() > 250) {
			errors.rejectValue("direccion", "form.longitudDireccionIncorrecta", new Object[] { "'direccion'" },
					"La dirección tiene que tener una longitud máxima de 250 caracteres.");
		}
		if (cliente.getPoblacion().length() > 150) {
			errors.rejectValue("poblacion", "form.longitudPoblacionIncorrecta", new Object[] { "'poblacion'" },
					"La poblacion tiene que tener una longitud máxima de 250 caracteres.");
		}
		if (cliente.getCodigo() > 50 && !Util.validarCodigoPostal(cliente.getCodigoPostal())) {
			errors.rejectValue("codigopostal", "form.formatoCodigoPostalIncorrecto", new Object[] { "'codigopostal'" },
					"El código postal introducido no es correcto.");
		}
		if (!Util.validarCIF(cliente.getIdentificador()) && !Util.validarDni(cliente.getIdentificador())
				&& Util.validarNIE(cliente.getIdentificador())) {
			errors.rejectValue("idenficador", "form.identificadorIncorrecto", new Object[] { "'idenficador'" },
					"El identificador (CIF, NIE o NIF) introducido no es correcto.");
		}
	
	}

}
