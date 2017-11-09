package com.leysoft.ufproject.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.leysoft.ufproject.entity.ImagenContenedor;

@Component
public class ImagenValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ImagenContenedor.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ImagenContenedor imagen = (ImagenContenedor) obj;
		if(imagen.getFile() != null) {
			if(imagen.getFile().isEmpty()) {
				errors.rejectValue("file", "imagen.file", "Debe cargar un imagen");
			}
			if(!imagen.getFile().getContentType().contains("image")) {
				errors.rejectValue("file", "imagen.file", "Debe subir un archivo de tipo imagen");
			}
			if(imagen.getFile().getSize() > 10*1024*1024) {
				errors.rejectValue("file", "imagen.file", "Exede el tamaño de 10MB");
			}
		}
	}
}