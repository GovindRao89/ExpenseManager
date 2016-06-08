package com.expensemanager.test;

import org.junit.Test;

import com.expensemanager.entities.User;
import com.expensemanager.service.UserService;

import static org.junit.Assert.*;

public class UserTest {

	@Test
	public void testUserRegistration() throws Exception {
		UserService userService = new UserService();
		User user = new User();
		user.setPassword("AgreeYa!@#$");
		user.setPasswordConfirm("AgreeYa!@#$");
		user.setUsername("Govind Rao");
		String userToString = userService.setUser(user);
		assertNotNull(userToString);
	}

	@Test
	public void testUserWRTUserName() throws Exception {
		UserService userService = new UserService();
		User user = userService.getUserWRTUserName("Govind Rao");
		assertEquals("Govind Rao", user.getUsername());
	}

}
