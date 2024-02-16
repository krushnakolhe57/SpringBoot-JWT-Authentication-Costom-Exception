package com.sb.exceptionController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sb.entity.UserError;
import com.sb.exception.UserException;
import com.sb.exception.UserException2;

@RestControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<UserError> mapException(UserException ex) {
		UserError error = new UserError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		
		return new ResponseEntity<UserError>(error , HttpStatus.INTERNAL_SERVER_ERROR );
		
	}
	
	@ExceptionHandler(UserException2.class)
	public ResponseEntity<UserError> mapException1(UserException2 ex) {
		UserError error = new UserError(HttpStatus.NOT_FOUND, ex.getMessage());
		
		return new ResponseEntity<UserError>(error , HttpStatus.NOT_FOUND );
		
	}

	
	
}
