package com.contactandnetworkingapplication.dao;

import java.util.List;

import com.contactandnetworkingapplication.model.FriendRequest;
import com.contactandnetworkingapplication.model.User;

public interface FriendRequestsDaoInterface {

	List<FriendRequest> viewFriendRequestsDao(User u);

	int acceptFriendRequestDao(FriendRequest f);

}
