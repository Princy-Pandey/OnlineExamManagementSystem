package com.capgemini.onlinetestmanagementsystem.app.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "QuestionBank")
public class QuestionBank implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
	@SequenceGenerator(sequenceName = "question_seq", allocationSize = 1, name = "question_seq")	
	BigInteger questionId;
	
	String questionTitle;
	
	String questionOptions;
	
	BigDecimal questionMarks;
	
	Integer correctOptionIndex;
	
	String questionTag;
	
	String questionDifficulty;

	public QuestionBank() {
		super();
	}
	

	public QuestionBank(String questionTitle, String questionOptions, BigDecimal questionMarks,
			Integer correctOptionIndex, String questionTag, String questionDifficulty) {
		super();
		this.questionTitle = questionTitle;
		this.questionOptions = questionOptions;
		this.questionMarks = questionMarks;
		this.correctOptionIndex = correctOptionIndex;
		this.questionTag = questionTag;
		this.questionDifficulty = questionDifficulty;
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

	public String getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(String questionOptions) {
		this.questionOptions = questionOptions;
	}

	public BigDecimal getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(BigDecimal questionMarks) {
		this.questionMarks = questionMarks;
	}

	public Integer getCorrectOptionIndex() {
		return correctOptionIndex;
	}

	public void setCorrectOptionIndex(Integer correctOptionIndex) {
		this.correctOptionIndex = correctOptionIndex;
	}

	public String getQuestionTag() {
		return questionTag;
	}

	public void setQuestionTag(String questionTag) {
		this.questionTag = questionTag;
	}

	public String getQuestionDifficulty() {
		return questionDifficulty;
	}

	public void setQuestionDifficulty(String questionDifficulty) {
		this.questionDifficulty = questionDifficulty;
	}
}
