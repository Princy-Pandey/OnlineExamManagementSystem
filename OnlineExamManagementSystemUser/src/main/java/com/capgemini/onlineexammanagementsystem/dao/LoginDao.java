package com.capgemini.onlineexammanagementsystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.capgemini.onlineexammanagementsystem.entities.Login;

@Transactional
@Repository
public class LoginDao implements LoginDaoInterface
{
	@PersistenceContext
	EntityManager em;

	@Override
	public Login getLogin(String loginId) 
	{
		// TODO Auto-generated method stub
		Login login = em.find(Login.class, loginId);
			//if(user==null) 
			//throw new userException("User Id does not exist for "+ userId);
		return login;
	}

	@Override
	public List<Login> getLogin() 
	{
		// TODO Auto-generated method stub
		TypedQuery<Login> query = em.createQuery("from Login", Login.class);
		List<Login> loginList = query.getResultList();
		return loginList;
	}

	@Override
	public void addLogin(Login login) 
	{
		// TODO Auto-generated method stub
		em.persist(login);
	}

	@Override
	public boolean checkUserByMail(String userMail) 
	{
		// TODO Auto-generated method stub
		String Qstr = "SELECT login.user.user_mail FROM Login login WHERE login.user.user_mail = :user.user_mail";
   		TypedQuery<String> query = em.createQuery(Qstr,String.class).setParameter("userMail",userMail);
   		try
   		{
   			query.getSingleResult();
   		}
   		catch(Exception ex)
   		{
   			return false;
   		}
   		return true;
	}
	
	@Override
	public Login getUserByMail(String userMail) 
	{
		// TODO Auto-generated method stub
		String Qstr = "SELECT login FROM Login login WHERE login.user.user_mail = :user.user_mail";
   		TypedQuery<Login> query = em.createQuery(Qstr,Login.class).setParameter("userMail",userMail);
   		return query.getSingleResult();
	}
	
}
