package com.niit.collab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.dao.UserDAO;
import com.niit.collab.model.User;

@RestController
public class UserController {
	
@Autowired
private UserDAO userDAO;

@PostMapping(value="/register")
public ResponseEntity<User> adduser(@RequestBody User users){
	System.out.println("hello");
	/*user.setStatus('n');*/
	userDAO.saveOrUpdate(users);
	return new ResponseEntity<User>(users, HttpStatus.OK);
	
}
@GetMapping(value="/users")
public ResponseEntity<List<User>> listuser(){
	System.out.println("list of users");
	List<User> user =userDAO.list();
	return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	
	
}


@GetMapping(value="/oneuser/{id}")
public ResponseEntity<List<User>> oneuser(@PathVariable("id") int id){
	List<User> oneuser=userDAO.getuser(id);
	return new ResponseEntity<List<User>>(oneuser,HttpStatus.OK);
}


}























/*package com.niit.collab.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.dao.UsersDAO;
import com.niit.collab.model.Users;
import com.niit.collab.dao.UsersDAOImpl;
import com.niit.collab.model.BaseDomain;


@RestController
public class UserController 
{
@Autowired
private UsersDAO usersDAO;

@Autowired
private Users users;

@PostMapping(value="/register")
public ResponseEntity<Users> adduser( Users users){
	System.out.println("hello");
	usersDAO.save(users);
	return new ResponseEntity<Users>(users, HttpStatus.OK);
	
}

@PostMapping(value="/register")
public ResponseEntity<Users> register(@RequestBody Users users){
	System.out.println("hello");
	if(UsersDAO.get(users.getId())!=null)
	{
		users.setErrorCode("404");
		users.setErrorMessage("user already exit with the id :" +users.getId());
	}
	else
	{
		users.setIsOnline('N');
		users.setIsOnline('N');
		boolean flag=usersDAO.save(users)
		if(flag.save(users)==false)
		{
			users.setErrorCode("404");
			users.setErrorMessage("not able to register.please contact admin");
		}
			
	}
	
	return new ResponseEntity<Users>(users, HttpStatus.OK);
	
}


@GetMapping(value="/users")
public ResponseEntity<List<Users>> getAllUsers(){
	System.out.println("list of users");
	List<Users> userList =usersDAO.getAllUsers();
	if(userList.isEmpty())
	{
		users.setErrorCode("404");
		users.setErrorMessage("users are not available");
		userList.add(users);
		
		
	}
	return new ResponseEntity<List<Users>>(userList,HttpStatus.OK);
	
	
}

@PostMapping(value="/login")
public ResponseEntity<Users> login(@RequestBody Users Users,HttpSession htppSession)
{
	users=UsersDAO.validate(users.getId(),users.getPassword());
	if(users==null)
	{
		users=new Users();//to avoid nullpointerException
		users.setErrorCode("404");
		users.setErrorMessage("invalid Credentials please try again");
		
	}
	else
	{
		httpSession.setAttribute("loggedInUserID",users.getId());
		users.setIsOnline('Y');
		friendDAO.setOnline(users.getId());
		friendDAO.update(friend);
		UsersDAO.update(users);
	}
}
}




















}
*/