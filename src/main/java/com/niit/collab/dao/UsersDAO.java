package com.niit.collab.dao;

import java.util.List;

import com.niit.collab.model.Users;

public interface UsersDAO {

	public boolean save(Users users);
	public boolean update(Users users);
	public boolean delete(Users users);
	public Users get(int userID);
	public List<Users> getAllUsers();
	public Users validate(int userID, String password);
}
