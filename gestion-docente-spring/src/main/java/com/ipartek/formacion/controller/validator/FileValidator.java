package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return MultipartFile.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		final MultipartFile multipartFile = (MultipartFile) obj;
		if (multipartFile != null && multipartFile.isEmpty()) {
			// errors.rejectValue("temario", "file.empty");
		}
	}
}
