package com.capgemini.onlinetestmanagementsystem.app.controller;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;
import com.capgemini.onlinetestmanagementsystem.app.exception.TestException;
import com.capgemini.onlinetestmanagementsystem.app.service.TestServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/test")
public class TestController{
	
	@Autowired
	TestServiceInterface testService;
	
	//Add test
	@PostMapping("/addTest")
	public ResponseEntity<String> addTest(@RequestBody TestBank test) throws TestException{
		try{
			testService.addTest(test);
			return new ResponseEntity<String>("Test added successfully",HttpStatus.OK);
		}
		catch(TestException exception)
		{
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	//Get all test details
	@GetMapping("/getTestDetails")
    public ResponseEntity<List<TestBank>> getAllTestDetails(){
			List<TestBank> testList = testService.retrieveAll();
			return new ResponseEntity<List<TestBank>>(testList,HttpStatus.OK);
	}
	
	//Delete test using testId
	@DeleteMapping("/deleteTest/{testId}")
    public ResponseEntity<String> deletetestId
              (@PathVariable("testId") BigInteger testId){
		try{
			testService.deleteTest(testId);
			return new ResponseEntity<String>("Test deleted successfully",HttpStatus.OK);
		}
		catch(TestException exception)
		{
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Updating test using testId
	@PutMapping("/updateTest/{testId}")
	public ResponseEntity<String> updateTest(@RequestBody TestBank test) throws TestException{
		try {
			testService.updateTest(test);	
			return new ResponseEntity<String>("Test updated succesfully",HttpStatus.OK);
		}
		catch(TestException exception)
		{
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Assign test 
	@PostMapping("/assignTest")
	public ResponseEntity<String> assignTest(@RequestBody WorkSpaceData data) throws TestException{
		try{
			testService.assignTest(data);	
			return new ResponseEntity<String>("Test assigned succesfully",HttpStatus.OK);
		}
		catch(TestException exception)
		{
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
