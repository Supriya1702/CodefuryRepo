package com.contactandnetworkingapplication.utility;

import com.contactandnetworkingapplication.dao.FriendRequestsDao;
import com.contactandnetworkingapplication.dao.RegistrationDao;
import com.contactandnetworkingapplication.dao.RegistrationDaoInterface;

public class DaoFactory {

	private DaoFactory() {
		
	}

	public static RegistrationDaoInterface createRegistrationObject() {
		return new RegistrationDao();
	}

	public static FriendRequestsDao createFriendRequestsObject() {
		return new FriendRequestsDao();
	}
	
}
