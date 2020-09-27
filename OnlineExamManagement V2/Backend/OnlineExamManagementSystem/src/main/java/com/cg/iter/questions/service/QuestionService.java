package com.cg.iter.questions.service;

import java.util.List;

import com.cg.iter.questions.entities.Question;
import com.cg.iter.questions.entities.Test;

public interface QuestionService {



/*******************************************************************************************************************************
-Author                   :     ShirshakPanda
-Created/Modified Date    :     24-09-2020
-Description              :     QuestionService Interface with services for OnlineExam Management System Question Module
*******************************************************************************************************************************/
	
	public String addQuestion(int testId,Question question);
	public String deleteQuestion(int questionId);
	public String UpdateQuestion(int questionId,Question question);
	public List<Question> viewAll();
	public Question findById(int questionId);
	public String addQuestion(Question question);
	
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