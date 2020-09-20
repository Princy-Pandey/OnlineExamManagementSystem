package com.capgemini.onlineexammanegmentsystem.dao;



import java.util.List;

import com.capgemini.onlineexammanegmentsystem.entity.CategoryResult;
import com.capgemini.onlineexammanegmentsystem.entity.User_Test;


public interface CalculateScoreDao {
	
	User_Test getUserTest(long userTestId) throws Exception;

	boolean setScore(User_Test userTest) throws Exception;
		
	void setCategoryResult(CategoryResult categoryResult) throws Exception;

	List<User_Test> getTests() throws Exception;

}
