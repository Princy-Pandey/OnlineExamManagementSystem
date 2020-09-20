package com.capgemini.onlineexammanegmentsystem.dao;

import java.util.List;

import com.capgemini.onlineexammanegmentsystem.entity.Category;
import com.capgemini.onlineexammanegmentsystem.entity.Question;


public interface QuestionTestDao {

	Boolean addQuestion(Question question, long cat_id);

	
	Boolean deleteQuestion(Long questionId);
	
	List<Question> getAllQuestions();
	
	Boolean addCategory(Category category);
	
	Category getCategory(Long categoryId);
	boolean updateQuestion(long questionId, String questionTitle, List<String> option, int questionAnswer,
			long questionMarks, Category category);


	


}
