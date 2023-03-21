package com.employeemanagementSys.Springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundDException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
public ResourceNotFoundDException (String message) {
	super(message);
}
}
