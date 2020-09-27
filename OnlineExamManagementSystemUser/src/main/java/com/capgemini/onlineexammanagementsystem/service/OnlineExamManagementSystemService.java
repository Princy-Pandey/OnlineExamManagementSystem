package com.capgemini.onlineexammanagementsystem.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlineexammanagementsystem.dao.UserDaoInterface;
import com.capgemini.onlineexammanagementsystem.entities.User;
import com.capgemini.onlineexammanagementsystem.exception.UserException;


/************************************************************************************
 * @author Maneesh Kumar Description It is a service class that provides the
 *         services for adding,removing and displaying user and admin details.
 *         Also to validate the user/admin for login and verify users to change
 *         the password and update password. Version 1.0 Created Date
 *         20-APR-2020
 ************************************************************************************/

@Service("healtcaresystemservice")
@Transactional
public class OnlineExamManagementSystemService implements OnlineExamManagementSystemServiceInterface {
	@Autowired
	 UserDaoInterface userDaoInterface;

	/************************************************************************************
	 * Method: 					viewUser 
	 * Description: 			To view user registered
	 * @param viewUser 			Display user's details
	 * @throws UserException 	It is raised due to user id not present.
	 ************************************************************************************/

	@Override
	public List<User> viewUser() throws UserException {
		// TODO Auto-generated method stub
		if (userDaoInterface.getUser() == null)
			throw new UserException("User Id does not exist for ");
		else
			return userDaoInterface.getUser();
	}

	/************************************************************************************
	 * Method: 				deleteUser 
	 * Description: 		To delete user registered
	 * @param deleteUser 	Deletes user's details
	 ************************************************************************************/

	@Override
	public Boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return userDaoInterface.delete(userId);
	}

	/************************************************************************************
	 * Method: 					existsByMail 
	 * Description: 			To check existed user by mail
	 * @param existsByMail 		Checks users.
	 * @throws UserException 	It is raised due to mail id not present
	 ************************************************************************************/

	@Override
	public boolean existsByMail(String userMail) throws UserException {
		// TODO Auto-generated method stub
		if (userDaoInterface.findMail(userMail) == false)
			throw new UserException("userMail doesn't exist");
		else
			return (userDaoInterface.findMail(userMail));
	}

	/************************************************************************************
	 * Method: 					viewUserByMail 
	 * Description: 			To view user registered by using mail
	 * @param viewUserByMail 	Display user's details
	 ************************************************************************************/

	@Override
	public User viewUserByMail(String userMail) {
		// TODO Auto-generated method stub
		User user = userDaoInterface.getUserByMail(userMail);
		return user;
	}

	/************************************************************************************
	 * Method: 					updatePassword 
	 * Description: 			To update existed user's password.
	 * @param updatePassword 	Updates user password.
	 ************************************************************************************/

	@Override
	public void updatePassword(String userMail, String userPassword, int userId) {
		// TODO Auto-generated method stub
		userDaoInterface.updateUser(userMail, userPassword, userId);

	}

	/************************************************************************************
	 * Method: 					addRegistration 
	 * Description: 			To add users details
	 * @param addRegistration 	Add user detail
	 * @throws UserException 	It is raised due to user id not present
	 ************************************************************************************/

	@Override
	public boolean addRegistration(User user) {
		// TODO Auto-generated method stub
		return userDaoInterface.addRegistration(user);
	}

	/************************************************************************************
	 * Method: 					validateLogin 
	 * Description:	 			To login user registered
	 * @param validateLogin 	Login user into the userpage.
	 ************************************************************************************/

	@Override
	public int validateLogin(String userMail, String userPassword) {
		return userDaoInterface.validateLogin(userMail, userPassword);
	}

	/************************************************************************************
	 * Method: 						verifyUserSecretWord 
	 * Description: 				To verify user's secretWord
	 * @param verifyUserSecretWord 	Logs in ro update new password.
	 * @throws UserException 		It is raised due to mail id not present.
	 ************************************************************************************/

	@Override
	public int verifyUserSecretWord(String userMail, String secretWord) throws UserException {
		// TODO Auto-generated method stub
		if (userDaoInterface.checkUserByMail(userMail) == false)
			throw new UserException(" This Mail Id doesn't exist, Please enter correct Mail Id! ");

		User user = userDaoInterface.getUserByMail(userMail);
		if (user.getSecretWord().equals(secretWord) == false || user.getUserRole().equals("admin"))
			return 0;
		else
			return 1;
	}
}
