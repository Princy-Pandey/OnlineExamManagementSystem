package com.cg.iter.questions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.iter.questions.entities.Question;



/*******************************************************************************************************************************
-Author                   :     ShirshakPanda
-Created/Modified Date    :     24-09-2020
-Description              :     Questions Repository Interface with Question as Type and integer as Key
*******************************************************************************************************************************/

@Repository
public interface QuestionsRepository extends JpaRepository<Question, Integer> {

	//@Query("Select question from Question question")
	//List<Question> allQuestions();
	
	//@Query("select question from Question question where question.questionTitle=:name")
	//List<Question> findByName(@Param("name") String name);
	
}