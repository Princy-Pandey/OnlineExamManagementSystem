package com.capgemini.onlineexammanegmentsystem.dao;

import java.util.List;

import com.capgemini.onlineexammanegmentsystem.entity.Question;
import com.capgemini.onlineexammanegmentsystem.entity.Test;



public interface OnlineTestDao {
	public boolean isUserExist(long userId);
	public List<Test> getAllTestAssignToPerticularUser(long UserId) throws Exception;
	public List<Test> getAllTest() throws Exception;
	public Test getActiveTest(long userId, long testId) throws Exception;
	public List<Question> getAllQuestion(long UserId, long testId) throws Exception;
	
	public boolean submitTest(List<Integer> answer, long testId, long userId) throws Exception;
}
