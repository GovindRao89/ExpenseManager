package com.expensemanager.utils;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private ErrorMessage() {
		// private constructor
	}

	private static class ErrorMessageHolder {
		public static final ErrorMessage INSTANCE = new ErrorMessage();
	}

	public static ErrorMessage getInstance() {
		return ErrorMessageHolder.INSTANCE;
	}

	protected Object readResolve() {
		return getInstance();
	}
	
}
