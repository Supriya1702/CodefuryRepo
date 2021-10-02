package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.contactandnetworkingapplication.model.User;

public class UpdateDao implements UpdateDaoInterface{

	@Override
	public int UpdateUserDao(User u) {	
			
		int res=0;
			ConnectionUtil a = new ConnectionUtil();
			Connection c=a.createConnection();
			PreparedStatement p;
			try {
				
				
				String query="UPDATE user SET fullname = ?, phone_no = ?,gender=?,dob=?,address=?,city=?,state=?,country=?,company=? WHERE id = ?;";
				p=c.prepareStatement(query);
				p.setString(1, u.getName());
				p.setLong(2,u.getPhoneno());
				p.setString(3, u.getGender());
				p.setDate(4,u.getDob());
				p.setString(5,u.getAddress());
				p.setString(6,u.getCity());
				p.setString(7,u.getState());
				p.setString(8,u.getCountry());
				p.setString(9,u.getCompany());
				p.setInt(10,u.getId());
					
				res = p.executeUpdate();
					
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

}
