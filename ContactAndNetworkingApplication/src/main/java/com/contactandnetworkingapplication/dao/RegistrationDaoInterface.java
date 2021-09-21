package com.contactandnetworkingapplication.dao;

import com.contactandnetworkingapplication.model.User;

public interface RegistrationDaoInterface {

	int registerUserDao(User u);

	User loginUserDao(User u);

}
