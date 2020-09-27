package com.capgemini.onlineexammanagementsystem.dao;

import java.util.List;

import com.capgemini.onlineexammanagementsystem.entities.User;
import com.capgemini.onlineexammanagementsystem.exception.UserException;



/***************** Interface of User Dao ********************/

public interface UserDaoInterface {
	public List<User> getUser();

	User getUser(String userId) throws UserException;

	boolean findMail(String userMail);

	Boolean delete(int userId);

	void updateUser(String userMail, String userPassword, int userId);

	boolean addRegistration(User user);

	boolean checkUserByMail(String email);

	User getUserByMail(String email);

	public int validateLogin(String userMail, String userPassword);

	int validateSecretWord(String userMail, String secretWord);

	User viewUserByMail(String userMail);
}
