package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");		//getting the driver
			Connection c = DriverManager.getConnection("jdbc:mysql://85.10.205.173:3306/codefury_contact","app_monsters","student1234");  //creating connection to database
			return c;		//returning connection object
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
