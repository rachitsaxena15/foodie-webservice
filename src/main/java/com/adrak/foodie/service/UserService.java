package com.adrak.foodie.service;

import java.util.List;

import com.adrak.foodie.entity.User;

public interface UserService {
	
	public User addUser(User user);
	public User getUser(long id);
	public User getUser(String name);
	public User updateUser(User user);
	public void deleteUser(User user);
	public List<User> getAllUsers();
	public boolean isUserExist(User user);

}
