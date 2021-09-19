package com.admin.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.admin.DAO.AdminDAO;
import com.admin.helpers.PropertiesHelper;
import com.admin.model.Admin;

public class AdminDAOImpl implements AdminDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static String conURL;
	private static String dbDriver;
	private static String dbUserName;
	private static String dbPassword;
	
	static {
		PropertiesHelper helper = new PropertiesHelper();
		conURL = helper.getProperty("CONURL");
		dbDriver = helper.getProperty("DRIVERCLASSNAME");
		dbUserName = helper.getProperty("DBUSERNAME");
		dbPassword = helper.getProperty("DBPASSWORD");
		try {
			Class c = Class.forName(dbDriver);
			System.out.println("Loaded The" + c.getName() + "Class");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void createConnection() {
		try {
			conn = DriverManager.getConnection(conURL, dbUserName, dbPassword);
			System.out.println("Connected To DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Admin getAdminByCredentials(String username, String password) {
		final String SQL = "select * from admin where admin_username = ? and admin_password = ?";
		createConnection();
		try {
			
			ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminName(rs.getString("admin_name"));
				admin.setAdminEmail(rs.getString("admin_email"));
				admin.setAdminPhone(rs.getInt("admin_phoneno"));
				return admin;
			}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				closeConnection();
			}
		return null;
			
		
	}

	@Override
	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Connection to DB is closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
