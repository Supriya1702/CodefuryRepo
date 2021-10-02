package com.contactandnetworkingapplication.dao;

import java.util.List;

import com.contactandnetworkingapplication.exception.FetchFriendRequestsException;
import com.contactandnetworkingapplication.model.FriendRequest;
import com.contactandnetworkingapplication.model.User;

public interface FriendRequestsDaoInterface {

	List<FriendRequest> viewFriendRequestsDao(User u) throws FetchFriendRequestsException;

	int acceptFriendRequestDao(FriendRequest f);

	int ignoreFriendRequestDao(FriendRequest f);

	int blockFriendRequestDao(FriendRequest f);

}
