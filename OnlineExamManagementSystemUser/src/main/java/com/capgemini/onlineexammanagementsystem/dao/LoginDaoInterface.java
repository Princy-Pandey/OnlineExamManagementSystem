package com.capgemini.onlineexammanagementsystem.dao;

import java.util.List;

import com.capgemini.onlineexammanagementsystem.entities.Login;

public interface LoginDaoInterface 
{
	Login getLogin(String loginId);
	public List<Login> getLogin();
	public void addLogin(Login login);
	boolean checkUserByMail(String user_mail);
	Login getUserByMail(String user_mail);
	
}
