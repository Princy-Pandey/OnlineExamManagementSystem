package com.capgemini.onlineexammanegmentsystem.dao;
import java.sql.Timestamp;
import java.util.List;

import com.capgemini.onlineexammanegmentsystem.entity.Test;
import com.capgemini.onlineexammanegmentsystem.exception.TestDataInvalidException;


public interface TestDao {
	public void addTest(Test test);
	public void updateTest(long test_Id,String testTiltle,long testDuration,Timestamp startDate,Timestamp endDate) throws TestDataInvalidException;
	public void deleteTest(long test_Id) throws TestDataInvalidException;
	public List<Test> getAllTests();
	public  List<String> getAllTitles();

	public void addQuestionTest(long questionId,long test_Id) throws TestDataInvalidException;

}
