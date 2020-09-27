package com.cg.iter.questions.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "USER_Tab")
@Inheritance(strategy=InheritanceType.JOINED) 
public class User {
	@Id
	@Column(name = "User_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name = "User_name")
	private String userName;
	
	@Column(name = "IS_Admin")
	private boolean isAdmin;
	
	@Column(name = "Password")
	private String userPassword;
	
	@Column(name = "Email_Id")
	private String emailId;
	
	@Column(name = "IsActiveTest")
	private boolean isActiveTest = false;
	
	/*
	 * @OneToMany(mappedBy = "user")
	 * 
	 * @JsonIgnore private Set<User_Test> userTest = new HashSet<>();
	 */
	
	
	public User() {
		
	}
	
	
	

	public boolean isActiveTest() {
		return isActiveTest;
	}




	public void setActiveTest(boolean isActiveTest) {
		this.isActiveTest = isActiveTest;
	}




	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

	


}
