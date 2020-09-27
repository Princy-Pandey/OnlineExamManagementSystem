package com.capgemini.onlineexammanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAdvice 
{
	@ExceptionHandler(value = {UserException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionResponse handleException(Exception exception) 
	{
		return new ExceptionResponse(exception.getMessage());
	}
}
