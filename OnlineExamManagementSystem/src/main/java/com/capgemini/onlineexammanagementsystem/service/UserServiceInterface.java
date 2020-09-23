package com.capgemini.onlineexammanagementsystem.service;

import java.util.List;

import com.capgemini.onlineexammanagementsystem.entities.User;
import com.capgemini.onlineexammanagementsystem.exception.UserException;


/**********************Service Interface******************************/

public interface UserServiceInterface {
	
	public Boolean addUser(User user) throws UserException;
	
	public List<User> retrieveAll();
	
	public Boolean deleteUser(Long userId) throws UserException;
	
	public Boolean updateUser(User user) throws UserException;
}
