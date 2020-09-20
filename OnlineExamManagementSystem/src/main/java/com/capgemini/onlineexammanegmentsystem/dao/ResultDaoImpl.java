package com.capgemini.onlineexammanegmentsystem.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.onlineexammanegmentsystem.entity.CategoryResult;
import com.capgemini.onlineexammanegmentsystem.entity.Question;
import com.capgemini.onlineexammanegmentsystem.entity.Test;
import com.capgemini.onlineexammanegmentsystem.entity.User;
import com.capgemini.onlineexammanegmentsystem.entity.User_Test;
import com.capgemini.onlineexammanegmentsystem.exception.DataMismatchExcpetion;
import com.capgemini.onlineexammanegmentsystem.exception.NoDataFoundedException;
import com.capgemini.onlineexammanegmentsystem.exception.QuestionsNotFoundException;



@Repository
public class ResultDaoImpl implements ResultDao {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public List<User_Test> getResult(Long userId) throws Exception{
	
		try {
		User user = entityManager.find(User.class,userId);
		String qStr = "SELECT ut from User_Test ut where ut.user=:user and ut.isAttempted = 1";
		TypedQuery<User_Test> query = entityManager.createQuery(qStr, User_Test.class);
		query.setParameter("user", user);
		List<User_Test> list=query.getResultList();
		if(list == null || list.size() == 0) {
			throw new NoDataFoundedException("No data Founded...");
		}
		return list;
		}
		catch(NoDataFoundedException exception) {
			throw new NoDataFoundedException("No Data Available in database...");
		}
		catch(Exception exception) {
			throw new DataMismatchExcpetion("Internal server error!");
		}
	}


	@Override
	public List<CategoryResult> getCategoryResult(Long userTestId) throws Exception{
	
		try {
			
		User_Test userTest = entityManager.find(User_Test.class,userTestId);
		String qStr = "SELECT cr from CategoryResult cr where cr.userTest=:userTest";
		TypedQuery<CategoryResult> query = entityManager.createQuery(qStr, CategoryResult.class);
		query.setParameter("userTest", userTest);
		List<CategoryResult> list=query.getResultList();
		if(list == null || list.size() == 0)
			throw new NoDataFoundedException("No data Founded...");
		return list;
		}
		catch(NoDataFoundedException exception) {
			throw new NoDataFoundedException("No Data Available in database...");
		}
		catch(Exception exception) {
			throw new DataMismatchExcpetion("Internal server error!");
		}
	}


	@Override
	public List<Question> getQuestions(Long testId) throws Exception{
		try {
		Test test = entityManager.find(Test.class, testId);
		
		List<Question> questionsList =  test.getAllQuestion();
		
		if(questionsList == null)
			throw new QuestionsNotFoundException();
		
		return questionsList; 
		}
		catch(QuestionsNotFoundException exception){
			throw new QuestionsNotFoundException("No questions available for this test");
		}
	}

}
