package com.capgemini.onlineexammanagementsystem.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class OnlineExamManagementSystemControllerAdvice 
{
	@ExceptionHandler(OnlineExamManagementSystemServiceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(final OnlineExamManagementSystemServiceException hcsexception,final UserException userexception , final HttpServletRequest request)
	{
		ExceptionResponse error = new ExceptionResponse();
		error.setMessage(hcsexception.getMessage());
		error.setMessage(userexception.getMessage());
		//error.callerURL(request.getRequestURI());
		return error;
	}
}
