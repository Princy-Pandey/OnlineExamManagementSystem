package com.capgemini.onlineexammanagementsystem.dao;

import java.util.List;
import com.capgemini.onlineexammanagementsystem.entities.User;
import com.capgemini.onlineexammanagementsystem.exception.UserException;


/*****************Interface of User ********************/

public interface UserDaoInterface{

	public Boolean addUser(User user) throws UserException;
	
	public List<User> retrieveAll();
	
	public Boolean deleteUser(Long userId) throws UserException;
	
	public Boolean updateUser(User user) throws UserException;
}
