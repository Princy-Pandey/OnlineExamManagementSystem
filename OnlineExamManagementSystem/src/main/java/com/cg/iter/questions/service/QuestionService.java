package com.cg.iter.questions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.iter.questions.entities.Question;

public interface QuestionService {

	
	
	public String addQuestion(int testId,Question question);
	public String deleteQuestion(int questionId);
	public String UpdateQuestion(int questionId,Question question);
	public List<Question> viewAll();
	//public Optional<Question> findbyid(int id);
}









































//public Question addQuestion(Question question,int testid) ;//done
//public boolean deleteQuestion(Question question) ;//done
//public boolean deleteQuestionFromTest(int questionId, int testId);
//public Question getQuestionByName(String name);//done
//public Question getQuestion(int questionId);//done
//public boolean updateQuestion(Question question);
//public boolean addQuestionToTest(int questionId, int testId);
//public List<Question> getAllQuestion();