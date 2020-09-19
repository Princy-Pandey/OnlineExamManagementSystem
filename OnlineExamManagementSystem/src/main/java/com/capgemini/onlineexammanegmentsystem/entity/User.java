package com.capgemini.onlineexammanegmentsystem.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/************************************************************************************
 *          @author      :    Princy Pandey
 *          Description  :    It is an Entity class which is used to generate Users Table into the database and
 *          				  stored all the user details & related information.	   
 *          Version      :    
 *          Created Date :    19-SEPT-2020
 ************************************************************************************/

@Entity
@Table(name="Users")
public class User{
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "user_seq")
	private Long userId;
	
	@Column(length = 512)
	private String userName;
	
	@Column(length = 512)
	private String userPassword;
	
	private Boolean isAdmin;

	public User() {
		super();
	}

	public User(String userName, String userPassword, Boolean isAdmin) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.isAdmin = isAdmin;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
