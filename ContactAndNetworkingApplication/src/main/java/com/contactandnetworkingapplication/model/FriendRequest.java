package com.contactandnetworkingapplication.model;

public class FriendRequest {
	int friend_request_pk;
	int receiver_id;
	int sender_id;
	String sender_name;
	public int getFriend_request_pk() {
		return friend_request_pk;
	}
	public void setFriend_request_pk(int friend_request_pk) {
		this.friend_request_pk = friend_request_pk;
	}
	public int getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}
	public int getSender_id() {
		return sender_id;
	}
	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}
	public String getSender_name() {
		return sender_name;
	}
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
}
