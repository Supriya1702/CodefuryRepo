package com.admin.factory;

import com.admin.DAO.impl.AdminDAOImpl;

public class AdminFactory {
	public static  AdminDAOImpl getAdminImpl() {
		return new AdminDAOImpl();
	}
}
