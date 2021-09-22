package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.contactandnetworkingapplication.model.User;

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
			p = c.prepareStatement("select * from user where email = ? and password = ?");
			p.setString(1, u.getEmail());
			p.setString(2,u.getPassword());
			
			ResultSet rs = p.executeQuery();
			
			if(rs.next()) {
				User res = new User();
				res.setId(rs.getInt(1));
				res.setName(rs.getString(2));
				res.setEmail(rs.getString(3));
				res.setPhoneno(rs.getLong(4));
				res.setGender(rs.getString(5));
				res.setDob(rs.getDate(6));
				res.setAddress(rs.getString(7));
				res.setCity(rs.getString(8));
				res.setState(rs.getString(9));
				res.setCountry(rs.getString(10));
				res.setCompany(rs.getString(11));
				res.setUsername(rs.getString(13));
				res.setPassword(rs.getString(14));;
				System.out.println(res.toString());
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
