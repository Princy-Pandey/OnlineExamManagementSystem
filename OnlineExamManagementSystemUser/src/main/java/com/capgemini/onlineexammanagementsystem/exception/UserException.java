package com.capgemini.onlineexammanagementsystem.exception;

public class UserException extends Exception
{
	private static final long serialVersionUID = -470180507998010368L;

	public UserException() {
		super();
	}

	public UserException(final String message) {
		super(message);
	}
}
