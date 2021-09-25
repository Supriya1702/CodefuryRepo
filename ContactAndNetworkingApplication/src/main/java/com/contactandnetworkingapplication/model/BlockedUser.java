package com.contactandnetworkingapplication.model;

public class BlockedUser {
	int user_id;
	int blocked_id;
	int blocked_users_pk;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBlocked_id() {
		return blocked_id;
	}
	public void setBlocked_id(int blocked_id) {
		this.blocked_id = blocked_id;
	}
	public int getBlocked_users_pk() {
		return blocked_users_pk;
	}
	public void setBlocked_users_pk(int blocked_users_pk) {
		this.blocked_users_pk = blocked_users_pk;
	}
}
