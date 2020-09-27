package com.capgemini.onlineexammanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.onlineexammanagementsystem.entities.User;
import com.capgemini.onlineexammanagementsystem.exception.UserException;



/************************************************************************************
 * @author Maneesh Kumar Description It is a dao class that provides the methods
 *         to fetch user's details Version 1.0 Created Date 20-APR-2020
 ************************************************************************************/

@Transactional
@Repository("UserDao")
public class UserDao implements UserDaoInterface {
	@PersistenceContext
	EntityManager em;

	public UserDao userDao;

	/************************************************************************************
	 * Method: 				getUser 
	 * Description: 		To get user list details
	 * @param getUSer 		Get list of user details.
	 ************************************************************************************/

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("from User", User.class);
		List<User> userList = query.getResultList();
		return userList;
	}

	/************************************************************************************
	 * Method: 					getUser 
	 * Description: 			To get user detail by Id.
	 * @param getUser 			Get users details by Id. 
	 ************************************************************************************/

	@Override
	public User getUser(String userId) throws UserException {
		// TODO Auto-generated method stub
		User user = em.find(User.class, userId);
		return user;
	}

	/************************************************************************************
	 * Method: 				 findMail 
	 * Description:          To find mail in user.
	 * @param findMail       Finds mail in the user.
	 ************************************************************************************/

	@Override
	public boolean findMail(String userMail) {
		// TODO Auto-generated method stub
		if (em.contains(em.find(User.class, userMail))) {
			return true;
		}
		return false;
	}

	/************************************************************************************
	 * Method: 					delete 
	 * Description: 			To delete the details of the user by userId. 
	 * @param delete	 		Delete user details.
	 ************************************************************************************/

	@Override
	public Boolean delete(int userId) {
		// TODO Auto-generated method stub
		User user = em.find(User.class, userId);
		if (user != null) {
			em.remove(user);
			return true;
		}
		return false;
	}

	/************************************************************************************
	 * Method: 					updateUser 
	 * Description: 			To update password in user details.
	 * @param updateUser 		Update user
	 ************************************************************************************/

	@Override
	public void updateUser(String userMail, String userPassword, int userId) {
		// TODO Auto-generated method stub
		User userUpdate = em.find(User.class, userId);
		userUpdate.setUserPassword(userPassword);
	}

	/************************************************************************************
	 * Method: 					viewUserByMail 
	 * Description: 			To view user with the help of mail.
	 * @param viewUserByMail 	View User.
	 * 
	 ************************************************************************************/

	@Override
	public User viewUserByMail(String userMail) {
		// TODO Auto-generated method stub
		return em.find(User.class, userMail);
	}

	/************************************************************************************
	 * Method:               addRegistration 
	 * Description: 		 To add new user in user.
	 * @param updateCentre 	 Add user.
	 ************************************************************************************/

	@Override
	public boolean addRegistration(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
		return true;
	}

	/************************************************************************************
	 * Method: 					checkUserByMail 	
	 * Description: 			To check user with the help of mail.
	 * @param checkUserByMail 	Check user.
	 ************************************************************************************/

	@Override
	public boolean checkUserByMail(String userMail) {
		// TODO Auto-generated method stub
		String Qstr = "SELECT user.userMail FROM User user WHERE user.userMail = :USER_MAIL";
		TypedQuery<String> query = em.createQuery(Qstr, String.class).setParameter("USER_MAIL", userMail);
		try {
			query.getSingleResult();
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	/************************************************************************************
	 * Method: 				  getUserByMail 
	 * Description: 		  To user details with the help of mail
	 * @param getUserByMail   Get user
	 ************************************************************************************/

	@Override
	public User getUserByMail(String userMail) {
		// TODO Auto-generated method stub
		String Qstr = "SELECT user FROM User user WHERE user.userMail = :USER_MAIL";
		TypedQuery<User> query = em.createQuery(Qstr, User.class).setParameter("USER_MAIL", userMail);
		return query.getSingleResult();
	}

	/************************************************************************************
	 * Method: 					validateLogin
	 * Description: 			To valid the user with userMail and userPassword
	 * @param validateLogin 	Validate user
	 ************************************************************************************/

	@Override
	public int validateLogin(String userMail, String userPassword) {
		List<User> loginList = new ArrayList();
		String Qstr = "SELECT user FROM User user WHERE user.userMail= :USER_MAIL";
		TypedQuery<User> query = em.createQuery(Qstr, User.class).setParameter("USER_MAIL", userMail);
		loginList = query.getResultList();

		if (loginList.size() > 0) {
			if (loginList.get(0).getUserPassword().equals(userPassword)
					&& loginList.get(0).getUserRole().equals("user"))
				return 1;
			else if (loginList.get(0).getUserPassword().equals(userPassword)
					&& loginList.get(0).getUserRole().equals("admin"))
				return 2;
			else
				return 0;
		} else
			return 0;
	}

	/************************************************************************************
	 * Method: 						validateSecretWord 
	 * Description: 				To validate user with using userMail and secretWord
	 * @param validateSecretWord 	Validate user for updating password.
	 ************************************************************************************/

	@Override
	public int validateSecretWord(String userMail, String secretWord) {
		List<User> verifyList = new ArrayList();
		String Qstr = "SELECT user FROM User user WHERE user.userMail= :USER_MAIL";
		TypedQuery<User> query = em.createQuery(Qstr, User.class).setParameter("USER_MAIL", userMail);
		verifyList = query.getResultList();

		if (verifyList.size() > 0) {
			if (verifyList.get(0).getSecretWord().equals(secretWord) && verifyList.get(0).getUserRole().equals("user"))
				return 1;
			else
				return 0;
		} else
			return 0;
	}
}
