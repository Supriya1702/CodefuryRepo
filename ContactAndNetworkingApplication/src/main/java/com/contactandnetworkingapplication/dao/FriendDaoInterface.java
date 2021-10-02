package com.contactandnetworkingapplication.dao;

import java.util.HashMap;
import java.util.List;

import com.contactandnetworkingapplication.model.User;
import com.contactandnetworkingapplication.exception.DeleteFriendException;
import com.contactandnetworkingapplication.exception.FetchFriendException;
import com.contactandnetworkingapplication.model.Friend;
public interface FriendDaoInterface {
	List<User> viewFriendsDao(User u) throws FetchFriendException;
	int removeFriend(Friend f) throws DeleteFriendException;
	HashMap<Integer , String> viewBlocked(int id);
	int confirmBlocked(int user_id , int blocked_id);
}
