package com.cg.iter.questions.entities;

//import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "QUESTIONS_TAB")
public class Question {



	//private static final long serialVersionUID = 1L;
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	
	
 @OneToMany(targetEntity = Answer.class,cascade = CascadeType.ALL)
 @JoinColumn(name = "qp_id",referencedColumnName = "questionId")
 
	private List<Answer> questionOptions;
	
	@Column(name = "Question_Title")
	private String questionTitle;
	
	@Column(name = "Question_Answer")
	private int questionAnswer;
	
	@Column(name = "Question_Marks")
	private int questionMarks;
	
//	
//	@ManyToOne(fetch =  FetchType.EAGER)
//	@JoinColumn(name="Test_Id")
//	@JsonBackReference
//	private Test testQuestions;
	
	public Question() {
		
	}

	public Question(int questionId, List<Answer> questionOptions, String questionTitle, int questionAnswer,
			int questionMarks) {
		super();
		this.questionId = questionId;
		this.questionOptions = questionOptions;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		//this.questionCategory = questionCategory;
	}

	
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public List<Answer> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(List<Answer> questionOptions) {
		this.questionOptions = questionOptions;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public int getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public int getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(int questionMarks) {
		this.questionMarks = questionMarks;
	}


	/*
	 * public Category getQuestionCategory() { return questionCategory; }
	 * 
	 * public void setQuestionCategory(Category questionCategory) {
	 * this.questionCategory = questionCategory; }
	 */

//	public Test getTestQuestions() {
//		return testQuestions;
//	}
//
//	public void setTestQuestions(Test testQuestions) {
//		this.testQuestions = testQuestions;
//	}

	
    
}
