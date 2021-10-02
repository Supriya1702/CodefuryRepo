package com.contactandnetworkingapplication.exception;

public class FetchFriendRequestsException extends Exception {
	@Override
	public String toString() {
		return "There was some error while fetching friend requests. Please try again.";
	}
}
