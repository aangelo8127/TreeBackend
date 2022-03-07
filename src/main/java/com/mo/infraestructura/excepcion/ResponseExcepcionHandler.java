package com.mo.infraestructura.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mo.dominio.excepcion.ValidacionNegocioExcepcion;


@ControllerAdvice
@RestController
public class ResponseExcepcionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ValidacionNegocioExcepcion.class)
	public ResponseEntity<Error> 
		manejarModeloNotFoundException(ValidacionNegocioExcepcion ex, WebRequest request){
		Error er = new Error(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Error>(er, HttpStatus.BAD_REQUEST);
	}	
	
}
