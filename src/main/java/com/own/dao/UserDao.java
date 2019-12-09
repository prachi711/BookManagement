package com.own.dao;

import com.own.model.User;

public interface UserDao {
	
	public void addUser(User user);
	public User checkUser(String username,String password);

}
