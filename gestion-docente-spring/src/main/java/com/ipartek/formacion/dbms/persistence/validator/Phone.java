package com.ipartek.formacion.dbms.persistence.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy=PhoneValidator.class)
@Target ({ElementType.METHOD, ElementType.FIELD})//Sobre que va a trabajar este elemento
@Retention(RetentionPolicy.RUNTIME) //CUANDO se va a ejecutar esta anotacion
public @interface Phone {
	
	//------------ Tres metodos---------------
	
	// Para el message, obligatorio ponerlos!
	String message() default "{Phone}"; //default: lo que carga por defecto. 
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
