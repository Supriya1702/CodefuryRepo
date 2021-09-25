package com.contactandnetworkingapplication.dao;

import java.util.HashMap;
import java.util.List;

import com.contactandnetworkingapplication.model.User;
import com.contactandnetworkingapplication.model.Friend;
public interface FriendDaoInterface {
	List<User> viewFriendsDao(User u);
	int removeFriend(Friend f);
	HashMap<Integer , String> viewBlocked(int id);
	int confirmBlocked(int user_id , int blocked_id);
}
