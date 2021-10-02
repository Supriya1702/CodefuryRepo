package com.contactandnetworkingapplication.exception;

public class EmailAlreadyExistsException extends Exception {
	@Override
	public String toString() {
		return "User with this email is already registered. Please use a different email id.";
	}
}
