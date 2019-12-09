package com.own.service;

import com.own.model.User;

public interface UserService {
	
	public void addUser(User user);
	public User checkUser(String username, String password);

}
