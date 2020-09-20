package com.capgemini.onlineexammanegmentsystem.dao;

import java.util.List;

import com.capgemini.onlineexammanegmentsystem.entity.User;


public interface IUserDao {

	public User getUserByName(String username);
	
	public User findById(Integer id);
	public void createUser(User user);
	public void signUp(User customer);
	public int SignUpEmailValidate(String email);
	public int userExistsOrNot(String userName);
	public List<User> getAllCustomers();
	public List<User> getallAdmins();
	public void createAdmin(User admin);

	public Long getUsrId(String username);
	
	
}
