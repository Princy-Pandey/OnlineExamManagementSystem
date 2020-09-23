package com.capgemini.onlineexammanagementsystem.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.onlineexammanagementsystem.entities.User;
import com.capgemini.onlineexammanagementsystem.exception.UserException;


/************************************************************************************
 *          @author          Princy Pandey
 *          Description      It is a dao class that provides the methods to fetch 
 *                           user's details
 *          Version          1.0
 *          Created Date     21-SEPT-2020
 ************************************************************************************/

@Transactional 
@Repository
public class UserDao implements UserDaoInterface{
	
	@PersistenceContext
	EntityManager myManager;
    
	/************************************************************************************
	 * Method: addUser
     * Description: To Add User Details into the User Table in database.
	 * @param from addUser            - User Object Containing User Details.
	 * @returns Boolean               - true, if transferred otherwise throws AddUserException
	 * @throws UserException       - It is raised if User already Exists / Use Cannot be added. 
     * Created By                     - Princy Pandey
     * Created Date                   - 21-Sept-2020                          
	 ************************************************************************************/

	
	@Override
	public Boolean addUser(User user) throws UserException{
		
		User checkTest;
		
		myManager.persist(user);
		
		checkTest = myManager.find(User.class, user.getUserId());
		
		if(checkTest == null)
			throw new UserException("Adding User Failed");
		return true;
	}
	
	/************************************************************************************
	 * Method: retrieveAll 
     * Description: To fetch all Users Details from the User Table in database.
     * @param from retrieveAll            - void.
	 * @returns List<User>                - return List of Object where each object contains details of a particular User. 
	 * @throws UserException           -  
     * Created By                         - Princy PAndey
     * Created Date                   - 21-Sept-2020                           
	 ************************************************************************************/
	
	@Override
	public List<User> retrieveAll(){
		String queryString = "SELECT users FROM User users";
		TypedQuery<User> query = myManager.createQuery(queryString , User.class);
		return query.getResultList();
	}
	
	/************************************************************************************
	 * Method: deleteUser
     * Description: To Delete a User from the User Table in database.
     * @param from deleteUser        - user ID of that user.
	 * @returns List<User>           - returns true if User deleted Successfully. 
	 * @throws UserException      -  
     *Created By                     - Princy PAndey
     * Created Date                   - 21-Sept-2020                          
	 ************************************************************************************/


	@Override
	public Boolean deleteUser(Long userId) throws UserException{
		User user = myManager.find(User.class, userId);
		if(user == null) {
			throw new UserException("User with userID + " + userId + " not Found");
		}
		else {
			System.out.println(user.getUserId() +" "+user.getUserName() + " deleted");
			myManager.remove(user);
		}
		return true;
	}
	
	/************************************************************************************
	 * Method: UpdateUser
     * Description: To update/modify  User Details into the User Table in database.
     * @param from deleteUser        - user ID of that user.
	 * @returns List<User>           - returns true if User Updation Successful. 
	 * @throws UserException      -  
     *Created By                     - Princy PAndey
     * Created Date                   - 21-Sept-2020                           
	 ************************************************************************************/


	@Override
	public Boolean updateUser(User user) throws UserException{
		User userUpdate = myManager.find(User.class, user.getUserId());
		if(userUpdate == null)
			throw new UserException("User with userID + " + user.getUserId() + " not Found");
		else {
			userUpdate.setUserName(user.getUserName());
			userUpdate.setUserPassword(user.getUserPassword());
		}
		return true;
	}
}
