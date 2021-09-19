package com.contactApplication.dao;

import com.contactApplication.model.User;

public interface RegistrationDaoInterface {

	int registerUserDao(User u);

	User loginUserDao(User u);

}
