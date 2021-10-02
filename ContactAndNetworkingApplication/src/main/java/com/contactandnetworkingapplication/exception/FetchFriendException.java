package com.contactandnetworkingapplication.exception;

public class FetchFriendException extends Exception{
	@Override
	public String toString() {
		return "There was some error while fetching friends. Please try again.";
	}
}
