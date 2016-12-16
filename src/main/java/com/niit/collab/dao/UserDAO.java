package com.niit.collab.dao;

import java.util.List;

import com.niit.collab.model.User;

public interface UserDAO {

	public boolean saveOrUpdate(User user);
	
	public boolean delete(User user);
	public User getuser(int id);
	public List<User> list();
	public User authuser(String username,String password);
	public User logout(int id);
	public User profileof(String username);
	/*public User oneuser(int id);*/
	public List<User> nonfriends(int id);

}
