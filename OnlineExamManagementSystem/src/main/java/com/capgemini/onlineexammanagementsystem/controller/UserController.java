package com.capgemini.onlineexammanagementsystem.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.onlineexammanagementsystem.entities.User;
import com.capgemini.onlineexammanagementsystem.exception.UserException;
import com.capgemini.onlineexammanagementsystem.service.UserServiceInterface;



/************************************************************************************
 * @author     Princy Pandey 
 * Description It is a controller class that process
 *             action for adding,removing and displaying user 
 * Version     1.0 
 * Created Date 22-SEPT-2020
 ************************************************************************************/


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	/************************************************************************************
	 * Method: addUser
	 * Description: To add details of user
	 * @param addUser Add user details
	 * @mapping PostMapping Make HTTP request to post onto user
	 * @throws UserException It is raised due to user id not present
	 ************************************************************************************/
	
	@PostMapping("/addUser")
	public ResponseEntity<Object> addUser(@RequestBody User user) throws UserException{	
		
		try {

			userServiceInterface.addUser(user);
			return new ResponseEntity<>("User Added", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new UserException("User Id already exists");
		}
	}
	
	/************************************************************************************
	 * Method: getUserDetails
	 * Description: To get details of user
	 * @param getUserDetails Display user details
	 * @mapping GetMapping Make HTTP request to get all user
	 ************************************************************************************/
	
	@GetMapping("/getUserDetails")
    public ResponseEntity<List<User>> getUserDetails(){
			List<User> userList = userServiceInterface.retrieveAll();
			return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	
	/************************************************************************************
	 * Method: deleteUserId
	 * Description: To delete details of user
	 * @param deleteUserId Delete user details
	 * @mapping @DeleteMapping Make HTTP request to delete user by user id
	 * @throws CentreException It is raised due to user id not present
	 ************************************************************************************/
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable("userId") Long userId) throws UserException{
		try {
			userServiceInterface.deleteUser(userId);
			return new ResponseEntity<>("User Deleted", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new UserException("Can't delete user");
		}
	}
	
	/************************************************************************************
	 * Method: updateUser
	 * Description: To update details of user
	 * @param updateUser Update user details
	 * @mapping @DeleteMapping Make HTTP request to update user by user id
	 * @throws CentreException It is raised due to user id not present
	 ************************************************************************************/
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<Object> updateUser(@RequestBody User user) throws UserException {
		/*Boolean response = userServiceInterface.updateUser(user);
		if(response==true)
			return new ResponseEntity<User>(user,HttpStatus.OK);
		else
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);*/
		
		try {
			userServiceInterface.updateUser(user);
			return new ResponseEntity<>("User Updated", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new UserException("Can't update ser");
		}
	}
}
