package com.contactApplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.contactApplication.model.User;

public class RegistrationDao implements RegistrationDaoInterface {

	@Override
	public int registerUserDao(User u) {
		int res=0;
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		PreparedStatement p;
		try {
			p = c.prepareStatement("insert into user(fullname,email,phone_no,gender,dob,address,city,state,country,company,username,password) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?)");
			p.setString(1, u.getName());
			p.setString(2,u.getEmail());
			p.setLong(3,u.getPhoneno());
			p.setString(4,u.getGender());
			p.setDate(5,u.getDob());
			p.setString(6,u.getAddress());
			p.setString(7,u.getCity());
			p.setString(8,u.getState());
			p.setString(9,u.getCountry());
			p.setString(10,u.getCompany());
			p.setString(11,u.getUsername());
			p.setString(12,u.getPassword());
			
			
			res = p.executeUpdate();
			if(res>0)
				System.out.println(res + " record/records inserted");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
		
	}

	@Override
	public User loginUserDao(User u) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		PreparedStatement p;
		try {
			p = c.prepareStatement("select id from user where email = ? and password = ?");
			p.setString(1, u.getEmail());
			p.setString(2,u.getPassword());
			
			ResultSet rs = p.executeQuery();
			
			if(rs.next()) {
				User res = new User();
				u.setId(rs.getInt(1));
				System.out.println(u.getId());
				return res;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	
	}

}
