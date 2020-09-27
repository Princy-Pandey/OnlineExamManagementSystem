package com.capgemini.onlineexammanagementsystem.service;

import java.util.List;

import com.capgemini.onlineexammanagementsystem.entities.User;
import com.capgemini.onlineexammanagementsystem.exception.UserException;



/***************** Interface of HealthCareSystem Service ********************/

public interface OnlineExamManagementSystemServiceInterface {
	List<User> viewUser() throws UserException;

	Boolean deleteUser(int userId);

	User viewUserByMail(String userMail);

	boolean existsByMail(String userMail) throws UserException;

	void updatePassword(String userMail, String userPassword, int userId);

	boolean addRegistration(User user);

	int validateLogin(String userMail, String userPassword);

	int verifyUserSecretWord(String userMail, String secretWord) throws UserException;
}
