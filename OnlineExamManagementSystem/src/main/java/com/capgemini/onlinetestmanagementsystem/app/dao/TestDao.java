package com.capgemini.onlinetestmanagementsystem.app.dao;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.User;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;
import com.capgemini.onlinetestmanagementsystem.app.exception.TestException;

@Transactional 
@Repository
public class TestDao implements TestDaoInterface{
	
	@PersistenceContext
	EntityManager myManager;
	

	@Override
	public void addTest(TestBank test) throws TestException {
		myManager.persist(test);
		
		TestBank addedTest= myManager.find(TestBank.class, test.getTestId());
		if(addedTest==null)
			throw new TestException("Test not added");
	}

	/************************************************************************************
	 * Method: retrieveAll 
     * Description: To fetch all Tests Details from the TestBank Table in database.
     * @param from retrieveAll            - void.
	 * @returns List<TestBank>            - return List of Object where each object contains details of a particular Test.           -  
	                           
	 ************************************************************************************/

	@Override
	public List<TestBank> retrieveAll(){
		String queryString = "SELECT tests FROM TestBank tests";
		TypedQuery<TestBank> query = myManager.createQuery(queryString , TestBank.class);
		return query.getResultList();
	}
	
	/************************************************************************************
	 * Method: deleteTest
     * Description: To Delete a Test from the TestBank Table in database.
     * @param from delete            - Test ID of that Test.
	 * @returns void            
	 * @throws TestException         - It is raised if Test is not present in the database                           
	 ************************************************************************************/

	@Override
	public void deleteTest(BigInteger testId) throws TestException {
		
		TestBank test=myManager.find(TestBank.class, testId);//this method will which id to remove
		
		if(test==null)
			throw new TestException("Test id not found");
		else
			myManager.remove(test);//this is object from the database
	}

	/************************************************************************************
	 * Method: UpdateTest
     * Description: To update/modify Test Details into the TestBank Table in database.
     * @param from update            - Test object containing Test Details.
	 * @returns void 
	 * @throws TestException         - It is raised if Test is not present in the database                             
	 ************************************************************************************/
	
	@Override
	public Boolean updateTest(TestBank test) throws TestException{
		// TODO Auto-generated method stub
		TestBank testUpdate= myManager.find(TestBank.class, test.getTestId());		
		if(testUpdate==null)
		{
			throw new TestException("No test found for the corresponding testId");
		}
			
		else
		{
			testUpdate.setTestTitle(test.getTestTitle());
			testUpdate.setStartTime(test.getStartTime());
			testUpdate.setEndTime(test.getEndTime());
			testUpdate.setTestQuestions(test.getTestQuestions());
			
			return true;
		}
		
	}

	/************************************************************************************
	 * Method: assignTest
     * Description: To assign Test to the User.
     * @param from assignTest        - WorkSpaceData object which contains User Id and Test Id.
	 * @returns void            
	 * @throws TestException         - It is raised if User or Test doesnot exist in the database/ Test mot assigned                            
	 ************************************************************************************/
	
	@Override
	public void assignTest(WorkSpaceData data) throws TestException {
		// TODO Auto-generated method stub
		User user = myManager.find(User.class, data.getUserId());
		if(user==null)
			throw new TestException("User doesnot exists");
		
		TestBank test = myManager.find(TestBank.class, data.getTestId());
		if(test==null)
			throw new TestException("Test doesnot exist");
		
		myManager.persist(data);
		
		WorkSpaceData workSpaceData = myManager.find(WorkSpaceData.class, data.getSequence());
		if(workSpaceData==null)
			throw new TestException("Test not assigned");
	}
}
