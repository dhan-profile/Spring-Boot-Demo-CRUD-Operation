package com.mypractice.DemoCrudOperation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String str) {
		super(str);
	}
}
