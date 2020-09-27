package com.capgemini.onlineexammanagementsystem.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/************************************************************************************
 *          @author      :    Princy Pandey
 *          Description  :    It is an Entity class which is used to generate Users Table into the database and
 *          				  stored all the user details & related information.	   
 *          Version      :    
 *          Created Date :    20-Sept-2020
 ************************************************************************************/

@Entity
@Table(name = "USERDATA")
public class User {
	/********** User Id **********/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int userId;

	/********** User Role **********/
	@Column(name = "USER_ROLE", columnDefinition = "varchar(255) default 'User'")
	private String userRole;

	/********** User Name **********/
	@Column(name = "USER_NAME", length = 25)
	private String userName;

	/********** User Mail **********/
	@Column(name = "USER_MAIL", unique = true, length = 50)
	private String userMail;

	/********** User Password **********/
	@Column(name = "USER_PASSWORD", length = 50)
	private String userPassword;

	/********** User Contact **********/
	@Column(name = "USER_CONTACT", length = 10)
	private long userContact;

	/********** User Gender **********/
	@Column(name = "USER_GENDER", length = 10)
	private String userGender;

	/********** User Age **********/
	@Column(name = "USER_AGE", length = 4)
	private int userAge;

	/********** Secret Word **********/
	// This is used in the case, if the user forgets it password.
	// Secret word will be used with userMail to check the validity
	// and show the existing password to the user on frontend.
	@Column(name = "SECRET_WORD", length = 10)
	private String secretWord;

	public enum login {
		loggedIn, LoggedOut
	};

	@Enumerated(EnumType.STRING)
	private login loginStatus = login.LoggedOut;

	/********** Default Constructor **********/
	public User() {

	}

	/********** Parameterized Constructor **********/
	public User(String userRole, String userName, String userMail, String userPassword, long userContact,
			String userGender, int userAge, String secretWord) {
		super();
		this.userRole = userRole;
		this.userName = userName;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userContact = userContact;
		this.userGender = userGender;
		this.userAge = userAge;
		this.secretWord = secretWord;
	}

	/********** Getters and Setters **********/
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
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

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public long getUserContact() {
		return userContact;
	}

	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getSecretWord() {
		return secretWord;
	}

	public void setSecretWord(String secretWord) {
		this.secretWord = secretWord;
	}

	public login getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(login loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userRole=" + userRole + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userMail=" + userMail + ", userContact=" + userContact + ", userGender="
				+ userGender + ", userAge=" + userAge + ", secretWord=" + secretWord + "]";
	}
}
