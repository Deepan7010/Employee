package com.tech.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeGlobalExceptionHandler {
	@ExceptionHandler(NameNotException.class)
	public ResponseEntity<Object>noname(NameNotException n){
		return new ResponseEntity<>(n.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CapitalLetterNotBoundException.class)
	public ResponseEntity<Object>nocase(CapitalLetterNotBoundException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}

}
