package com.capgemini.onlineexammanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlineexammanagementsystem.entities.User;
import com.capgemini.onlineexammanagementsystem.exception.UserException;
import com.capgemini.onlineexammanagementsystem.service.OnlineExamManagementSystemServiceInterface;


/************************************************************************************
 * @author 			Princy Pandey
 * Description 		It is a controller class that process
 *         			action for adding new users, login users and admin, view users and
 *         			deleting users, verify user and updating password. 
 * Version 			1.0
 * Created 			Date 22-APR-2020
 ************************************************************************************/

@CrossOrigin(origins = "http://localhost:4204")
@RestController
public class OnlineExamManagementSystemController {
	@Autowired
	 OnlineExamManagementSystemServiceInterface serviceInterfaceObject;

	/************************************************************************************
	 * Method: 					deleteUser 
	 * Description: 			To delete the user/admin details by Admin.
	 * @param deleteUser 		Delete user/admin details.
	 * @mapping DeleteMapping 	Make HTTP request to delete selected user/admin.
	 * @throws TestException 	It is raised if the user details not present.
	 *************************************************************************************/

	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") int userId) throws UserException {
		Boolean status = serviceInterfaceObject.deleteUser(userId);
		if (!status)
			throw new UserException("User not found.");

		return new ResponseEntity<Boolean>(status, HttpStatus.OK);
	}

	/**************************************************************************************
	 * Method: 					updatePassword 
	 * Description: 			To update the password provided by the user.
	 * @param updatePassword 	Updates the password in the database.
	 * @mapping PutMapping 		Make HTTP request to put the value of the password.
	 * @throws TestException 	It is raised when the user cannot be updated.
	 ***************************************************************************************/

	@PutMapping("/updatepassword/{userMail}")
	public ResponseEntity<Object> updatePassword(@PathVariable("userMail") String userMail, @RequestBody User user)
			throws UserException {
		try {
			serviceInterfaceObject.updatePassword(userMail, user.getUserPassword(), user.getUserId());
			return new ResponseEntity<>(" User Updated ", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new UserException(" Cannot Update User! ");
		}
	}

	/*************************************************************************************
	 * Method: 					addRegistration 
	 * Description: 			To add new user details by user.
	 * @param registration 		Add user details.
	 * @mapping PostMapping 	Make HTTP request to post user details.
	 * @throws TestException	 It is raised if the user details already exists.
	 **************************************************************************************/

	@PostMapping("/registration")
	public String addRegistration(@RequestBody User user) throws UserException {
		try {
			serviceInterfaceObject.addRegistration(user);
			return "You're Registered! Tap on login to go further.";
		} catch (DataIntegrityViolationException ex) {
			throw new UserException(" MAIL ID ALREADY EXISTS! Login or Register with new mail.");
		}
	}

	/*************************************************************************************
	 * Method: 					addAdmin 
	 * Description: 			To add new admin details by admin.
	 * @param addadmin 			Add admin details.
	 * @mapping PostMapping 	Make HTTP request to post admin details.
	 * @throws TestException 	It is raised if the admin details already exists.
	 **************************************************************************************/

	@PostMapping("/addadmin")
	public String addAdmin(@RequestBody User user) throws UserException {
		try {
			serviceInterfaceObject.addRegistration(user);
			return "New Admin added!";
		} catch (DataIntegrityViolationException ex) {
			throw new UserException(" This admin exists! ");
		}
	}

	/*************************************************************************************
	 * Method: 					viewUserByMail 
	 * Description: 			To get the details of the user by the help of mail.
	 * @param viewuserbymail 	Get user details.
	 * @mapping GetMapping 		Make HTTP request to get user details by mail.
	 * @throws TestException 	It is raised if the admin details already exists.
	 **************************************************************************************/

	@GetMapping("/viewuserbymail/{userMail}")
	public ResponseEntity<Object> viewUserByMail(@PathVariable("userMail") String userMail) throws UserException {
		User user = serviceInterfaceObject.viewUserByMail(userMail);
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: 				viewUsers 
	 * Description: 		To get details of user present
	 * @param viewUsers 	Display user details
	 * @mapping GetMapping 	Make HTTP request to get all user
	 ************************************************************************************/

	@GetMapping("/viewusers")
	public ResponseEntity<Object> viewUsers() throws UserException {
		return new ResponseEntity<>(serviceInterfaceObject.viewUser(), HttpStatus.OK);
	}

	/*******************************************************************************************
	 * Method: 					validateLogin 
	 * Description: 			To verify username and password.
	 * @param login 			Login the user into user/admin page according to the role.
	 * @mapping GetMapping 		Make HTTP request to get particular user.
	 ********************************************************************************************/

	@GetMapping("/login/{userMail}/{userPassword}")
	public int validateLogin(@PathVariable String userMail, @PathVariable String userPassword) {
		return serviceInterfaceObject.validateLogin(userMail, userPassword);
	}

	/*******************************************************************************************
	 * Method: 					verifyUser 
	 * Description: 			To verify username and secretWord.
	 * @param verifyuser 		Verify the user to let the user changes it password.
	 * @mapping GetMapping 		Make HTTP request to get a particular user.
	 ********************************************************************************************/

	@GetMapping("/verifyuser/{userMail}/{secretWord}")
	public int verifyUser(@PathVariable("userMail") String userMail, @PathVariable("secretWord") String secretWord)
			throws UserException {
		return serviceInterfaceObject.verifyUserSecretWord(userMail, secretWord);
	}

}
