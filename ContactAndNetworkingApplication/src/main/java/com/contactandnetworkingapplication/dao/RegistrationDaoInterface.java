package com.contactandnetworkingapplication.dao;

import com.contactandnetworkingapplication.model.User;

public interface RegistrationDaoInterface {

	int registerUserDao(User u);
	int checkUserDao(String email);
	User loginUserDao(User u);
}
