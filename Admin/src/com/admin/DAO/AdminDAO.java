package com.admin.DAO;

import com.admin.model.Admin;

public interface AdminDAO {
	void createConnection();
	Admin getAdminByCredentials(String username , String password);
	void closeConnection();
}
