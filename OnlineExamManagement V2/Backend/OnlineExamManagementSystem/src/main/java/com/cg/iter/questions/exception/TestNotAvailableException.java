package com.cg.iter.questions.exception;
/*******************************************************************************************************************************
-Author                   :     ShirshakPanda
-Created/Modified Date    :     24-09-2020
-Description              :     TestNotAvailableException  is thrown when the testId is not present in the database
*******************************************************************************************************************************/
public class TestNotAvailableException extends RuntimeException {

	public TestNotAvailableException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestNotAvailableException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
