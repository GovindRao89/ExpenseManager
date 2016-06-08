package com.expensemanager.service;

import com.expensemanager.dao.user.UserDaoImpl;
import com.expensemanager.entities.User;

public class UserService {

	public String setUser(User user) throws Exception {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.beginTransaction();
		userDaoImpl.persist(user);
		userDaoImpl.commitTransection();
		userDaoImpl.close();
		String userOutPut = user.toString();
		return userOutPut;
	}
	
	public User getUserById(Long userId) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.beginTransaction();
		User user = (User) userDaoImpl.findById(userId);
		userDaoImpl.close();
		return user;
	}

	public User getUserWRTUserName(String userName)
			throws Exception {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.beginTransaction();
		User user = userDaoImpl.getUserWRTUserName(userName);
		userDaoImpl.close();
		return user;
	}
}
