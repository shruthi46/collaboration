package com.niit.collab.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.dao.UserDAO;
import com.niit.collab.dao.FriendDAO;
import com.niit.collab.model.Friend;
import com.niit.collab.model.User;

@RestController
public class LoginController {
	
	@Autowired 
	UserDAO userDAO;
	FriendDAO friendDAO;

@RequestMapping(value ="/loginuser/{username}/{password}",method=RequestMethod.GET)
public ResponseEntity<User> login( @PathVariable("username") String username,@PathVariable("password") String password ,HttpSession session){
	User user = userDAO.authuser(username,password);
	if(user==null)
		{	
		return null;
}else{
	session.setAttribute("userLogged", user);
	session.setAttribute("uid", user.getUserid());
	session.setAttribute("username", user.getUsername());
	user.setStatus('o');
	userDAO.saveOrUpdate(user);
	return new ResponseEntity<User>(user,HttpStatus.OK);
}
}
@PostMapping("/logout")
public ResponseEntity<User> logout(HttpSession session){
	int uid =  (Integer) session.getAttribute("uid");
	User user =userDAO.logout(uid);
	user.setStatus('f');
	userDAO.saveOrUpdate(user);
	session.invalidate();
	return new ResponseEntity<User>(user,HttpStatus.OK);
}
}
