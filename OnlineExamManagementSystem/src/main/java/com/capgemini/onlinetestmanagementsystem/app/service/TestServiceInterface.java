package com.capgemini.onlinetestmanagementsystem.app.service;
import java.math.BigInteger;
import java.util.List;

import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;
import com.capgemini.onlinetestmanagementsystem.app.exception.TestException;

public interface TestServiceInterface {

	public void addTest(TestBank test) throws TestException;
	
	public List<TestBank> retrieveAll();

	public void deleteTest(BigInteger testId) throws TestException;

	public Boolean updateTest(TestBank test) throws TestException;

	public void assignTest(WorkSpaceData data) throws TestException;
}
