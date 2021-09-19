package com.contactApplication.utility;

import com.contactApplication.dao.RegistrationDao;
import com.contactApplication.dao.RegistrationDaoInterface;

public class DaoFactory {

	private DaoFactory() {
		
	}

	public static RegistrationDaoInterface createObject() {
		return new RegistrationDao();
	}
	
}
