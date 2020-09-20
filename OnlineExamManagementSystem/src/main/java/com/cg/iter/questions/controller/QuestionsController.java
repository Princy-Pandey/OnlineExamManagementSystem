package com.cg.iter.questions.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.questions.entities.Question;
import com.cg.iter.questions.service.QuestionServiceImpl;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/exam")
public class QuestionsController {
	@Autowired
	QuestionServiceImpl service;
	@PostMapping("/add/{id}")
public ResponseEntity<String> addQuestion(@PathVariable(value = "id") int testId,@RequestBody Question question)
{
	try {
	service.addQuestion(testId, question);
	return new ResponseEntity<String>("question added",HttpStatus.OK);
	}
	catch(Exception e) {
	return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
}}
	@DeleteMapping("/delete/{id}")
public String deleteQuestion(@PathVariable(value = "id")int questionId) {
	 service.deleteQuestion(questionId);
	 return "deleted";
}
	@PostMapping("/update/{id}")
public ResponseEntity<String> UpdateQuestion(@PathVariable(value = "id")int questionId,@RequestBody Question question) {
	service.UpdateQuestion(questionId, question);
	return new ResponseEntity<String>("question updated", HttpStatus.OK);
}
@GetMapping("/viewAll")
public List<Question> viewAll() {
	return service.viewAll();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
//	@RequestMapping("/addQuestion/{testId}")
//	public boolean addQuestion(@RequestBody Question question, @RequestParam int testId) {
//		// logger.trace("Requested to add a question");
//
//		service.addQuestion(question, testId);
//		return true;
//	}
//	@PutMapping("/addQuestionToTest/{questionId}/{testId}")
//	public boolean addQuestionToTest(@PathVariable int questionId, @PathVariable int testId){
//		//logger.trace("Requested to add a question to a test");
//		service.addQuestionToTest(questionId, testId);
//		return true;
//	}
//	@GetMapping("/getQuestion/{questionId}")
//	public ResponseEntity<Question> getQuestionById(@PathVariable int questionId)	{
//		//logger.trace("Requested to get all tests");
//		return new ResponseEntity<Question>(service.getQuestion(questionId), HttpStatus.OK);
//	}
//	@GetMapping("/getAllQuestions")
//	public ResponseEntity<List<Question>> getAllQuestion(){
//		//logger.trace("Requested to get all questions");			
//		return new ResponseEntity<List<Question>>(service.getAllQuestion(), HttpStatus.OK);
//	}		
//	
//	@DeleteMapping("/deleteQuestion/{questionId}")
//	 public boolean deleteQuestion(@RequestBody Question question) 	{
//		//logger.trace("Requested to delete a question");
//			return service.deleteQuestion(question);
//	}
//	
//	@PutMapping("/deleteQuestionFromTest")
//	public boolean deleteQuestionFromTest(@PathVariable int questionId, @PathVariable int testId){
//		//logger.trace("Requested to delete a question from a test");
//		return service.deleteQuestionFromTest(questionId, testId);


