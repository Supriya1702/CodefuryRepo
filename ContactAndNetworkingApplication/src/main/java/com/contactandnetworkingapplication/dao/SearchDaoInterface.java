package com.contactandnetworkingapplication.dao;

import java.util.List;

import com.contactandnetworkingapplication.model.User;

public interface SearchDaoInterface {

	List<User> searchByCityDao(User u);

	List<User> searchbyStateDao(User u);

	List<User> searchbyCompanyDao(User u);

}
