package com.cg.iter.questions.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.questions.entities.Question;
import com.cg.iter.questions.entities.Test;
import com.cg.iter.questions.exception.QuestionNotFoundException;
import com.cg.iter.questions.exception.TestNotAvailableException;
import com.cg.iter.questions.repository.QuestionsRepository;
import com.cg.iter.questions.repository.TestRepository;

/*******************************************************************************************************************************
-Author                   :     ShirshakPanda
-Created/Modified Date    :     24-09-2020
-Description              :     QuestionServiceImpl Class implements QuestionService for OnlineExam Management System
*******************************************************************************************************************************/
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionsRepository qrepo;
	@Autowired
	TestRepository trepo;

	/*******************************************************************************************************************************
	-Function Name            :     addQuestion
	-Input Parameters         :     Question Object and testId
	-Return Type              :     String
	-Throws                   :     TestNotAvailableException
	-Author                   :     ShirshakPanda
	-Created/Modified Date    :     24-09-2020
	-Description              :     adding Question to the database 
	*******************************************************************************************************************************/

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
	
	/*******************************************************************************************************************************
    -Function Name            :     deleteQuestion
    -Input Parameters         :     questionId
    -Return Type              :     String
    -Throws                   :     QuestionNotFoundException
    -Author                   :     ShirshakPanda
    -Created/Modified Date    :     24-09-2020
    -Description              :     removing Question from the database
    *******************************************************************************************************************************/
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
	/*******************************************************************************************************************************
    -Function Name            :     UpdateQuestion
    -Input Parameters         :     questionId and Question object
    -Return Type              :     String
    -Throws                   :     QuestionNotFoundException
    -Author                   :     ShirshakPanda
    -Created/Modified Date    :     24-09-2020
    -Description              :     Updating the Question in the database
    *******************************************************************************************************************************/
	
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
	

	/*******************************************************************************************************************************
	-Function Name            :     viewAll
	-Input Parameters         :     -
	-Return Type              :     List of Question
	-Throws                   :     QuestionNotfoundException
	-Author                   :     ShirshakPanda 
	-Created/Modified Date    :     24-09-2020
	-Description              :     getting all Questions from the database 
	*******************************************************************************************************************************/
	@Override
	public List<Question> viewAll() {
		if(qrepo.findAll().isEmpty())
			throw new  QuestionNotFoundException("List is empty..Please add some Questions");
		else
		return qrepo.findAll();
	}

	@Override
	public Question findById(int questionId) {
	Optional<Question>	findQuestion=qrepo.findById(questionId);
		if(findQuestion.isPresent())
			return findQuestion.get();
		
		else
			throw new QuestionNotFoundException("question not found"); 
	}

	@Override
	public String addQuestion(Question question) {
		int id=question.getQuestionId();
		Optional<Question> findbyid=qrepo.findById(id);
		if(findbyid.isPresent())
			return "Question already available";
		else
			qrepo.save(question);
		return "Question saved";
	}

	
	
}























