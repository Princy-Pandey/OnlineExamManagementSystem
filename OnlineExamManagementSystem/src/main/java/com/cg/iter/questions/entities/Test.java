package com.cg.iter.questions.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TEST_TAB")
public class Test {

	@Id
	//@Column(name = "Test_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;
	
	//@Column(name = "Test_Title")
	private String testTitle;
	
	@Column(name = "Test_Duration")
	private int testDuration;
	
	
	//@Column(name = "Total_Question")
	//private long totalQuestion;
	@OneToMany(targetEntity = Question.class,cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "testId")
	private List<Question> testQuestions;
	
	
	//@Column(name = "Test_Total_Marks")
	private int testTotalMarks;
	
	@Column(name = "Start_Time")
	private Timestamp startDate;
	
	@Column(name = "End_Time")
	private Timestamp endDate;
	
	//@OneToMany(mappedBy="testQuestions")
	//@JsonIgnore
	//private List<Question> allQuestion = new ArrayList<>();
	
	@Column(name = "Test_Status")
	private int testStatus;	
	
	public Test(int testId, String testTitle, int testDuration, List<Question> testQuestions, int testTotalMarks,
			Timestamp startDate, Timestamp endDate) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	/*
	 * @OneToMany(mappedBy = "test")
	 * 
	 * @JsonBackReference private Set<User_Test> userTest = new HashSet<>();
	 */
	
	
	
	
	public List<Question> getTestQuestions() {
		return testQuestions;
	}



	public void setTestQuestions(List<Question> testQuestions) {
		this.testQuestions = testQuestions;
	}



	public int getTestStatus() {
		return testStatus;
	}



	public void setTestStatus(int testStatus) {
		this.testStatus = testStatus;
	}


	/*
	 * public Set<User_Test> getUserTest() { return userTest; }
	 * 
	 * 
	 * 
	 * public void setUserTest(Set<User_Test> userTest) { this.userTest = userTest;
	 * }
	 */


//	public long getTotalQuestion() {
//		return totalQuestion;
//	}
//	
//
//
//	public void setTotalQuestion(long totalQuestion) {
//		this.totalQuestion = totalQuestion;
//	}


//	public List<Question> getAllQuestion() {
//		return allQuestion;
//	}
//
//
//	public void setAllQuestion(List<Question> allQuestion) {
//		this.allQuestion = allQuestion;
//	}
//
//	
//	
//	public Test(int testId, String testTitle, int testDuration, long totalQuestion, int testTotalMarks,
//			Timestamp startDate, Timestamp endDate) {
//		super();
//		this.testId = testId;
//		this.testTitle = testTitle;
//		this.testDuration = testDuration;
//	//	this.totalQuestion = totalQuestion;
//		this.testTotalMarks = testTotalMarks;
//		this.startDate = startDate;
//		this.endDate = endDate;
//	}



	public int getTestDuration() {
		return testDuration;
	}



	public void setTestDuration(int testDuration) {
		this.testDuration = testDuration;
	}



	public int getTestTotalMarks() {
		return testTotalMarks;
	}



	public void setTestTotalMarks(int testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}



	public Timestamp getStartDate() {
		return startDate;
	}



	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}



	public Timestamp getEndDate() {
		return endDate;
	}



	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}



	public Test() {
		
	}
	

	


	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
}
