package com.maneesh.dao;

import java.util.List;

import com.maneesh.model.User;

public interface UserDao {
	boolean addUser(User user);
	void updateUser(User user);
	void deleteUser(int userId);
	User getUser(int userId);
	List<User>getAllUsers();
	
	public User validateUser(String email, String password);
	public boolean isEmailExists(String email);
	boolean registerUser(User user);

}
