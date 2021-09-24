package com.contactandnetworkingapplication.utility;

import com.contactandnetworkingapplication.dao.AdminDAO;
import com.contactandnetworkingapplication.dao.AdminDaoInterface;
import com.contactandnetworkingapplication.dao.FriendDao;
import com.contactandnetworkingapplication.dao.FriendDaoInterface;
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
	public static FriendDaoInterface createFriend() {
		return new FriendDao();
	}
	public static AdminDaoInterface createAdminObject() {
		return new AdminDAO();
	}
}
