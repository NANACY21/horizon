package com.personal.dao;

import java.util.List;

import com.personal.pojo.User;

public interface UserDao {

	public int save(User user);
	
	public void deleteUserById(int id);
	
	public void updateUser(User user);
	
	public User getUserById(int id);
	
	public List<User> getUsers();
}