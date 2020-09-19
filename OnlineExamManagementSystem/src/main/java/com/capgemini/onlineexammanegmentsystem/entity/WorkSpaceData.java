package com.capgemini.onlineexammanegmentsystem.entity;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/************************************************************************************
 *          @author      :    Princy Pandey
 *          Description  :    It is an Entity class which stores all data about the User activity.
 *          Version      :    
 *          Created Date :    19-SEPT-2020
 ************************************************************************************/

@Entity
@Table(name = "WorkSpaceData")
public class WorkSpaceData implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(sequenceName = "seq", allocationSize = 1, name = "seq")
	private Long sequence;
	
	private Long userId;
	
	private BigInteger testId;
	
	private Double marksScored;
	
	private LocalTime testDuration;
	
	private Integer testStatus;
	/*
	 * status :  1   // If Test is Attempted Successfully.
	 * status :  0   // If Test not Attempted Yet (Test Pending).
	 * status : -1   // If test fail in between due any issue
	 * status : -10  // If test is deleted from database before attempting it. 
	 */
	
	@Column(length = 1024)
	private String userFeedback;

	public WorkSpaceData() {
		super();
	}

	public WorkSpaceData(Long userId, BigInteger testId, Integer testStatus) {
		super();
		this.userId = userId;
		this.testId = testId;
		this.testStatus = testStatus;
	}
	
	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigInteger getTestId() {
		return testId;
	}

	public void setTestId(BigInteger testId) {
		this.testId = testId;
	}

	public Double getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(Double marksScored) {
		this.marksScored = marksScored;
	}

	public LocalTime getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}

	public Integer getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(Integer testStatus) {
		this.testStatus = testStatus;
	}

	public String getUserFeedback() {
		return userFeedback;
	}

	public void setUserFeedback(String userFeedback) {
		this.userFeedback = userFeedback;
	}
}
