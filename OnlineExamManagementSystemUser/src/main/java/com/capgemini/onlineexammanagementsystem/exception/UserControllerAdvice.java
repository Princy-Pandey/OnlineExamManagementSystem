package com.capgemini.onlineexammanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/************************************************************************************
 *          @author          Maneesh Kumar
 *          Description      It is a rest controller advice class for exceptions
 *          Version          1.0
 *          Created Date     24-APR-2020
 ************************************************************************************/
@RestControllerAdvice
public class UserControllerAdvice 
{
	@ExceptionHandler(value = UserException.class)
	public ResponseEntity<Object> handleException1(UserException exception) 
	{
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
}