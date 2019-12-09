package com.own.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.own.dao.UserDao;
import com.own.model.User;

public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	public void addUser(User user) {
		  
		userDao.addUser(user);
		 
	}

	public User checkUser(String username, String password) {
		
		return userDao.checkUser(username,password);
		
	}

}
