package com.expensemanager.utils;

import com.expensemanager.entities.User;

public class UserValidator {

	private ErrorMessage errorMessage;
	private final static String USER_NAME_SIZE = "User name should not be less then 6 or grater then 32";
	private final static String USER_PASSWORD_SIZE = "Password should not be less then 8 or grater then 32";
	private final static String USER_PASSWORD_CONFIRM = "User password and confirm password does not match";
	private final static String USER_PASSWORD_EMPTY = "User & password should not be empty or should not contaions white space";

	public boolean checkIFUserClass(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	public ErrorMessage validate(Object o) {
		User user = (User) o;
		errorMessage = ErrorMessage.getInstance();

		if (rejectIfEmptyOrWhitespace(user.getUsername()) != null) {
			return rejectIfEmptyOrWhitespace(user.getUsername());
		}

		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errorMessage.setMessage(USER_NAME_SIZE);
			return errorMessage;
		}

		if (rejectIfEmptyOrWhitespace(user.getPassword()) != null) {
			return rejectIfEmptyOrWhitespace(user.getUsername());
		}

		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errorMessage.setMessage(USER_PASSWORD_SIZE);
			return errorMessage;
		}

		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errorMessage.setMessage(USER_PASSWORD_CONFIRM);
			return errorMessage;
		}
		errorMessage.setMessage(null);
		return errorMessage;
	}

	private ErrorMessage rejectIfEmptyOrWhitespace(String targetString) {
		if (targetString.trim().length() > 0
				&& !targetString.matches(".*\\w.*")) {
			errorMessage.setMessage(USER_PASSWORD_EMPTY);
			return errorMessage;
		}
		return null;
	}

}
