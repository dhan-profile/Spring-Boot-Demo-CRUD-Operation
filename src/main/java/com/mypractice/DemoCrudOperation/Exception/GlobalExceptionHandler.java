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
	 
	 @ExceptionHandler(RoleNotFoundException.class)
	 public ResponseEntity<ErrorDetails> RoleNotFound(RoleNotFoundException notfound, WebRequest webRequest)
	 {
		 ErrorDetails e = new ErrorDetails(new Date(), notfound.getMessage(), webRequest.getDescription(true));
		 return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
	 }

	 @ExceptionHandler(UserNotFoundException.class)
	 public ResponseEntity<ErrorDetails> UserNotFound(UserNotFoundException notfound, WebRequest webRequest)
	 {
		ErrorDetails u = new ErrorDetails(new Date(), notfound.getMessage(), webRequest.getDescription(true));
		return new ResponseEntity<>(u, HttpStatus.NOT_FOUND);
	 }
}
