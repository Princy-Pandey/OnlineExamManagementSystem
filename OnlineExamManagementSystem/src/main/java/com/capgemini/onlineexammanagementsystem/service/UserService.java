package com.capgemini.onlineexammanagementsystem.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.onlineexammanagementsystem.dao.UserDaoInterface;
import com.capgemini.onlineexammanagementsystem.entities.User;
import com.capgemini.onlineexammanagementsystem.exception.UserException;



/************************************************************************************
 * @author       Princy Pandey 
 * Description : It is a service class that provides the services for adding,removin  
 *               and displaying centre,test,user and appointments 
 * Version     : 1.0 
 * Created Date: 21-SEPT-2020
 ************************************************************************************/

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	UserDaoInterface userDaoInterfaceReferenceObject;
	
	/************************************************************************************
	 * Method: addUser
     * Description: To Add User Details into the User Table in database.
	 * @param from addUser            - User Object Containing User Details.
	 * @returns Boolean               - true, if transferred otherwise throws AddUserException
	 * @throws UserException       - It is raised if User already Exists / Use Cannot be added. 
     * Created By                     - Princy PAndey
     * Created Date                   - 21-Sept-2020                           
	 ************************************************************************************/

	
	@Override
	public Boolean addUser(User user) throws UserException {
		
		if(user.equals(null))
			throw new UserException("User Cannot be Empty"); 
			
		return userDaoInterfaceReferenceObject.addUser(user);
	}
	
	/************************************************************************************
	 * Method: retrieveAll 
     * Description: To fetch all Users Details from the User Table in database.
     * @param from retrieveAll            - void.
	 * @returns List<User>                - return List of Object where each object contains details of a particular User. 
	 * @throws UserException           -  
     * Created By                         - Princy Pandey
     * Created Date                   -     21-Sept-2020                           
	 ************************************************************************************/

	@Override
	public List<User> retrieveAll() {
		return userDaoInterfaceReferenceObject.retrieveAll();
	}
	
	/************************************************************************************
	 * Method: deleteUser
     * Description: To Delete a User from the User Table in database.
     * @param from deleteUser        - user ID of that user.
	 * @returns List<User>           - returns true if User deleted Successfully. 
	 * @throws UserException      -  
     *Created By                     - Princy Pandey
     * Created Date                   - 21-Sept-2020                          
	 ************************************************************************************/

	@Override
	public Boolean deleteUser(Long userId) throws UserException {
		return userDaoInterfaceReferenceObject.deleteUser(userId);
	}

	/************************************************************************************
	 * Method: UpdateUser
     * Description: To update/modify  User Details into the User Table in database.
     * @param from deleteUser        - user ID of that user.
	 * @returns List<User>           - returns true if User Updation Successful. 
	 * @throws UserException      -  
     *Created By                     - Princy Pandey
     * Created Date                   - 21-Sept-2020                           
	 ************************************************************************************/
	
	@Override
	public Boolean updateUser(User user) throws UserException {
		return userDaoInterfaceReferenceObject.updateUser(user);
	}
}
