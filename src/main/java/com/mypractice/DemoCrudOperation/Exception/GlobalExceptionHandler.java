package com.mypractice.DemoCrudOperation.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler
{
//	 @ExceptionHandler(EmployeeNotFoundException.class)
//     public ResponseEntity<String> EmployeeNotFound()
//     {
//    	 return new ResponseEntity<>("Employee not found this id",HttpStatus.NOT_FOUND);
//     }
	
	 @ExceptionHandler(EmployeeNotFoundException.class)
	 public ResponseEntity<ErrorDetails> EmployeeNotFound(EmployeeNotFoundException notfound, WebRequest webRequest)
	 {
		 ErrorDetails s=new ErrorDetails(new Date(),notfound.getMessage(),webRequest.getDescription(false));
		 return new ResponseEntity<>(s,HttpStatus.NOT_FOUND);
	 }
}
