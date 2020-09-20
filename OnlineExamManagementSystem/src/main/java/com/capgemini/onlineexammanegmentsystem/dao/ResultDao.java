package com.capgemini.onlineexammanegmentsystem.dao;

import java.util.List;

import com.capgemini.onlineexammanegmentsystem.entity.CategoryResult;
import com.capgemini.onlineexammanegmentsystem.entity.Question;
import com.capgemini.onlineexammanegmentsystem.entity.User_Test;




public interface ResultDao {

	List<User_Test> getResult(Long userId) throws Exception;
	
	List<CategoryResult> getCategoryResult(Long userTestId) throws Exception;
	
	List<Question> getQuestions(Long userTestId) throws Exception;
	
}
