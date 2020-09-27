package com.cg.iter.questions.exception;
/*******************************************************************************************************************************
-Author                   :     ShirshakPanda
-Created/Modified Date    :     24-09-2020
-Description              :     QuestionNotFoundException  is thrown when the Question is not found in the database
*******************************************************************************************************************************/

public class QuestionNotFoundException extends RuntimeException {

	public QuestionNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
