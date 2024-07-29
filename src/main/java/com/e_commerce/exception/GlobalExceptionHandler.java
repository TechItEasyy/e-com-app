package com.e_commerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException)
	{
	String message =	resourceNotFoundException.getMessage();
	ApiResponce responce= ApiResponce.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponce>(responce,HttpStatus.NOT_FOUND);
		
	}

}
