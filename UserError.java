package com.sb.entity;
import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class UserError {

	
	
	public UserError(HttpStatus internalServerError, String message) {
		
		this.errorCode = internalServerError.value();
		this.errorzMsg = message;
	
	}
	private  Integer errorCode;
	private String errorzMsg;
	
}
