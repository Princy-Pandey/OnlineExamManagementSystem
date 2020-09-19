package com.capgemini.onlineexammanegmentsystem.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/************************************************************************************
 *          @author      :    Shirshak Panda
 *          Description  :    It is an Entity class which stores all data about the Test.
 *          Version      :    
 *          Created Date :    19-SEPT-2020
 ************************************************************************************/


@Entity
@Table(name="TestBank")
public class TestBank implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "test_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")
	@SequenceGenerator(sequenceName = "test_seq", allocationSize = 1, name = "test_seq")
	private BigInteger testId;
	
	@Column(length = 512)
	private String testTitle;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	@ManyToMany
	private Set<QuestionBank> testQuestions;

	public TestBank() {
		super();
	}

	public TestBank(String testTitle, LocalDateTime startTime, LocalDateTime endTime,
			Set<QuestionBank> testQuestions){
		super();
		this.testTitle = testTitle;
		this.startTime = startTime;
		this.endTime = endTime;
		this.testQuestions = testQuestions;
	}

	public BigInteger getTestId() {
		return testId;
	}

	public void setTestId(BigInteger testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Set<QuestionBank> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(Set<QuestionBank> testQuestions) {
		this.testQuestions = testQuestions;
	}
	
}
