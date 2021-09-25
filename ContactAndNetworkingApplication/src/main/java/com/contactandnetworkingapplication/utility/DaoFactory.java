package com.contactandnetworkingapplication.utility;

import com.contactandnetworkingapplication.dao.AdminDAO;
import com.contactandnetworkingapplication.dao.AdminDaoInterface;
import com.contactandnetworkingapplication.dao.BlockeUserdDaoInterface;
import com.contactandnetworkingapplication.dao.BlockedUserDao;
import com.contactandnetworkingapplication.dao.FriendDao;
import com.contactandnetworkingapplication.dao.FriendDaoInterface;
import com.contactandnetworkingapplication.dao.FriendRequestsDao;
import com.contactandnetworkingapplication.dao.RegistrationDao;
import com.contactandnetworkingapplication.dao.RegistrationDaoInterface;
import com.contactandnetworkingapplication.dao.SearchDao;
import com.contactandnetworkingapplication.dao.SearchDaoInterface;
import com.contactandnetworkingapplication.dao.SendFriendRequestDao;
import com.contactandnetworkingapplication.dao.SendFriendRequestDaoInterface;

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
	public static SearchDaoInterface createSearchObject() {
		return new SearchDao();
	}

	public static SendFriendRequestDaoInterface createSendFriendRequestDao() {
		return new SendFriendRequestDao();
	}

	public static BlockeUserdDaoInterface createBlockedDaoObject() {
		return new BlockedUserDao();
	}
}
