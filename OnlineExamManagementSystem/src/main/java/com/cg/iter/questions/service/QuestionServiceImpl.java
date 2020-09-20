package com.cg.iter.questions.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.questions.entities.Question;
import com.cg.iter.questions.entities.Test;
import com.cg.iter.questions.exception.QuestionAlreadyExistsException;
import com.cg.iter.questions.exception.QuestionNotFoundException;
import com.cg.iter.questions.exception.TestNotAvailableException;
import com.cg.iter.questions.repository.QuestionsRepository;
import com.cg.iter.questions.repository.TestRepository;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionsRepository qrepo;
	@Autowired
	TestRepository trepo;

	@Override
	public String addQuestion(int testId, Question question) {
		Optional<Test> findbyid=trepo.findById(testId);
		if(findbyid.isPresent())
		{
			Test test=findbyid.get();
			test.setTestTotalMarks(test.getTestTotalMarks()+question.getQuestionMarks());
			List<Question> ques=test.getTestQuestions();
			ques.add(question);
		test.setTestQuestions(ques);
			trepo.save(test);
			return "question added";
		}
		else
		throw new TestNotAvailableException("test not found");
		
	}
	@Override
	public String deleteQuestion(int questionId) {
		Optional<Question> findbyid=qrepo.findById(questionId);
		if(findbyid.isPresent()) {
			qrepo.deleteById(questionId);
		
		return "question deleted";
		}
		else
			throw new QuestionNotFoundException("question not found");
	}
	@Override
	public String UpdateQuestion(int questionId, Question question) {
		// TODO Auto-generated method stub
		Optional<Question> findbyid=qrepo.findById(questionId);
		if(findbyid.isPresent()) {
			Question q=findbyid.get();
			q.setQuestionAnswer(question.getQuestionAnswer());
			q.setQuestionMarks(question.getQuestionMarks());
			q.setQuestionOptions(question.getQuestionOptions());
			q.setQuestionTitle(question.getQuestionTitle());
			qrepo.save(q);
			return "updated"; 
	}
		else
			throw new QuestionNotFoundException("question not found");
		
	}
	@Override
	public List<Question> viewAll() {
		
		return qrepo.findAll();
	}
	
	
}






















//
//@Override
//public Question addQuestion(Question question, int testid){
//	Optional<Question> findQuestion=qrepo.findById(question.getQuestionId());
//	Optional<Test> testQuestions=trepo.findById(testid);
//	if(findQuestion.isPresent()) {
//		throw new QuestionAlreadyExistsException("Question Already Exists");
//	}
//		question.setTestQuestions(testQuestions.get());
//	return qrepo.save(question);
//	//System.out.println("saved");
//}
//
//@Override
//public boolean deleteQuestion(Question question) {
//	Optional<Question> findQuestion =qrepo.findById(question.getQuestionId());
//	if(findQuestion==null) {
//		throw new  QuestionNotFoundException("Question Not Found");
//	}
//	else
//	 qrepo.deleteById(question.getQuestionId());
//	return true;
//}
//
//@Override
//public boolean deleteQuestionFromTest(int questionId, int testId) {
//	Optional<Question> findQuestion=qrepo.findById(questionId);
//	Optional<Test> testQuestions=trepo.findById(testId);
//	if(testQuestions.isEmpty())
//		throw new TestNotAvailableException("Test Not Available");
//	else
//		if(findQuestion.isEmpty())
//			throw new QuestionNotFoundException("Question Not Found");
//		else 
//			qrepo.deleteById(questionId);
//	return true;
//}
//
//@Override
//public Question getQuestionByName(String name) {
//	// TODO Auto-generated method stub
//	return qrepo.findByName(name).get(0);
//}
//
//@Override
//public Question getQuestion(int questionId) {
//	// TODO Auto-generated method stub
//	return qrepo.findById(questionId).get();
//}
//
//@Override
//public boolean updateQuestion(Question question) {
//	// TODO Auto-generated method stub
//	return false;
//}
//
//@Override
//public boolean addQuestionToTest(int questionId, int testId) {
//	/*
//	 * Question question=qrepo.getOne(questionId); if(question==null) throw new
//	 * TestDataInvalidException("question id not present");
//	 * 
//	 * 
//	 * Test test=trepo.getOne(testId);
//	 * 
//	 * if(test==null) throw new TestDataInvalidException("test id not present");
//	 * question.setTestQuestions(question);
//	 */
//	Optional<Question> findQuestion= qrepo.findById(questionId);
//	Optional<Test> test=trepo.findById(testId);
//	Question question=findQuestion.get();
//	if(findQuestion.isPresent())
//	 throw new QuestionAlreadyExistsException("Question already exists");
//	
//	else
//		if(test.isEmpty())
//			throw new TestNotAvailableException();
//		else
//		question.setTestQuestions(test.get());
//			qrepo.save(findQuestion.get());
//	
//	return true;
//}
//
////getAllquestions
//@Override
//public List<Question> getAllQuestion() {
//	if (qrepo.findAll().isEmpty()) {
//		throw new QuestionNotFoundException();
//	}
//	return qrepo.findAll();
//}
//
