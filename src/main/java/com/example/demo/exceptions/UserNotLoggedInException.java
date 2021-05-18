package com.example.demo.exceptions;

public class UserNotLoggedInException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8059759011659574949L;

	public UserNotLoggedInException(String message) {
		super(message);
	}

	public UserNotLoggedInException() {
		super();
	}
}
