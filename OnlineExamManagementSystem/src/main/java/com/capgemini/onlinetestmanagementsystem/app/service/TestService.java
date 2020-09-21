package com.capgemini.onlinetestmanagementsystem.app.service;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetestmanagementsystem.app.dao.TestDaoInterface;
import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;
import com.capgemini.onlinetestmanagementsystem.app.exception.TestException;

@Service
public class TestService implements TestServiceInterface{
	
	@Autowired
	TestDaoInterface testDao;
	
	/************************************************************************************
	 * Method: addTest
     * Description: To Add Test Details into the TestBank Table in database.
	 * @param from addTest            - Test Object Containing Test Details.
	 * @returns void    
	 * @throws TestException          - It is raised if Test already Exists / Test Cannot be added.                         
	 ************************************************************************************/

	
	@Override
	public void addTest(TestBank test) throws TestException{		
		testDao.addTest(test);
	}
	
	/************************************************************************************
	 * Method: retrieveAll 
     * Description: To fetch all Tests Details from the TestBank Table in database.
     * @param from retrieveAll            - void.
	 * @returns List<TestBank>            - return List of Object where each object contains details of a particular Test.           -   
	                         
	 ************************************************************************************/

	@Override
	public List<TestBank> retrieveAll(){
		return testDao.retrieveAll();
	}

	/************************************************************************************
	 * Method: deleteTest
     * Description: To Delete a Test from the TestBank Table in database.
     * @param from delete            - Test ID of that Test.
	 * @returns void            
	 * @throws TestException         - It is raised if Test is not present in the database                         
	 ************************************************************************************/

	@Override
	public void deleteTest(BigInteger testId) throws TestException{
		// TODO Auto-generated method stub
		testDao.deleteTest(testId);
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
		return testDao.updateTest(test);
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
		testDao.assignTest(data);
	}

}
