package com.cg.iter.questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.questions.entities.Answer;
@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer>{

}
