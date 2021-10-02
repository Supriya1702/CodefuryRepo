package com.contactandnetworkingapplication.dao;

import java.util.HashMap;
import java.util.List;

import com.contactandnetworkingapplication.model.Admin;
import com.contactandnetworkingapplication.model.User;

public interface AdminDaoInterface {

	
		
		Admin getAdminByCredentials(String username , String password);
		int getCount();
		HashMap<Integer , String> getDisabledUsers();
		int confirmDisabled(int id);
		HashMap<Integer , String> getDeleteUser();
		int confirmDelete(int id);

}
