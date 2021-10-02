package com.contactandnetworkingapplication.exception;

public class DeleteFriendException extends Exception{
	@Override
	public String toString() {
		return "There was some error while unfriending. Please try again.";
	}
}
