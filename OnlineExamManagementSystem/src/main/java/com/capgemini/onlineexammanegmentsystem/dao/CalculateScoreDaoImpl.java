package com.capgemini.onlineexammanegmentsystem.dao;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlineexammanegmentsystem.entity.CategoryResult;
import com.capgemini.onlineexammanegmentsystem.entity.User_Test;
import com.capgemini.onlineexammanegmentsystem.exception.DataEnteringException;
import com.capgemini.onlineexammanegmentsystem.exception.DataMergingException;
import com.capgemini.onlineexammanegmentsystem.exception.DataMismatchExcpetion;
import com.capgemini.onlineexammanegmentsystem.exception.NoDataFoundedException;



@Repository
@Transactional
public class CalculateScoreDaoImpl implements CalculateScoreDao{

	
	@Autowired
	private EntityManager entityManager;
	
	
	
	/*
	 * getUserTest method returns class User_Test based on the UserTestId
	 * 
	 * parameter accepted is userTestId
	 * 
	 * @return: User_test object based on userTestId
	 */
	@Override
	public User_Test getUserTest(long userTestId) throws Exception{
		//logger.info("DAO method to fetch User_Test class based on UserId");
		try {
			return entityManager.find(User_Test.class, userTestId);
		}
		catch(Exception e)
		{
			throw new NoDataFoundedException("No Data Available in database...");
		}
	}

	/*
	 * setScore method merges class User_Test into database
	 * 
	 * parameter accepted is User_Test class
	 * 
	 * @return: boolean value
	 */
	@Override
	public boolean setScore(User_Test userTest) throws Exception{
		//logger.info("DAO method to merge User_Test class into Database");
		try {
			entityManager.merge(userTest);
			return true;
		}
		catch(Exception e) {
			throw new DataMergingException("Data cannot be merged...");
		}
	}

	
	/*
	 * setCategoryResult method adds details class Category_Reslut into database
	 * 
	 * parameter accepted is Category_Result class
	 * 
	 */
	@Override
	public void setCategoryResult(CategoryResult categoryResult) throws Exception{
		try {
			entityManager.persist(categoryResult);
		}
		catch(Exception e) {
			throw new DataEnteringException("Data cannot be entered to Database...");
		}
		//logger.info("DAO method to persist Category_Result class into Database");		
	}

	
	/*
	 * getTests method adds all tests from class User_Test to List of type User_Test
	 * 
	 * no parameter
	 * 
	 * @return: List of User_Test
	 */
	@Override
	public List<User_Test> getTests() throws Exception {
		try {
			String qStr = "SELECT ut from User_Test ut";
			TypedQuery<User_Test> query = entityManager.createQuery(qStr, User_Test.class);
			List<User_Test> testsList = query.getResultList();
			if(testsList == null || testsList.size() == 0) {
				throw new NoDataFoundedException("No data Found...");
			}
			return testsList;
			}
			catch(NoDataFoundedException exception) {
				throw new NoDataFoundedException("No Data Available in database...");
			}
			catch(Exception exception) {
				throw new DataMismatchExcpetion("Internal server error!");
			}
	}
	
	
}
