package com.capgemini.onlineexammanegmentsystem.entity;

import java.io.Serializable;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/************************************************************************************
*	@author      :  Krishna Sharma 
*	Description  :  It is an Entity class which is used to generate QuestionBank Table into the database and
				  	stored all the Question details and related information.	   
*	Version      :    
*	Created Date :  19-SEPT-2020
 ************************************************************************************/

@Entity
@Table(name = "QuestionBank")
public class QuestionBank implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
	@SequenceGenerator(sequenceName = "question_seq", allocationSize = 1, name = "question_seq")	
	BigInteger questionId;
	
	@Column(length = 512)
	String questionTitle;
	
	@Column(length = 100)
	String questionOptionA;
	
	@Column(length = 100)
	String questionOptionB;
	
	@Column(length = 100)
	String questionOptionC;
	
	@Column(length = 100)
	String questionOptionD;
	
	@Column(length = 100)
	String correctOption;
	
	@Column(length = 100)
	String chosenOption;
	
	Double questionMarks;

	public QuestionBank() {
		super();
	}

	public QuestionBank(String questionTitle, String questionOptionA, String questionOptionB, String questionOptionC,
			String questionOptionD, String correctOption, Double questionMarks) {
		super();
		this.questionTitle = questionTitle;
		this.questionOptionA = questionOptionA;
		this.questionOptionB = questionOptionB;
		this.questionOptionC = questionOptionC;
		this.questionOptionD = questionOptionD;
		this.correctOption = correctOption;
		this.questionMarks = questionMarks;
	}

	public BigInteger getQuestionId() {
		return questionId;
	}

	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionOptionA() {
		return questionOptionA;
	}

	public void setQuestionOptionA(String questionOptionA) {
		this.questionOptionA = questionOptionA;
	}

	public String getQuestionOptionB() {
		return questionOptionB;
	}

	public void setQuestionOptionB(String questionOptionB) {
		this.questionOptionB = questionOptionB;
	}

	public String getQuestionOptionC() {
		return questionOptionC;
	}

	public void setQuestionOptionC(String questionOptionC) {
		this.questionOptionC = questionOptionC;
	}

	public String getQuestionOptionD() {
		return questionOptionD;
	}

	public void setQuestionOptionD(String questionOptionD) {
		this.questionOptionD = questionOptionD;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public Double getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(Double questionMarks) {
		this.questionMarks = questionMarks;
	}

	public String getChosenOption() {
		return chosenOption;
	}

	public void setChosenOption(String chosenOption) {
		this.chosenOption = chosenOption;
	}

}
