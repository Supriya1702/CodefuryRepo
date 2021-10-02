package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.contactandnetworkingapplication.model.User;

public class RegistrationDao implements RegistrationDaoInterface {

	@Override
	public int registerUserDao(User u) {		//new user registration
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
	public User loginUserDao(User u) {		//checking whether user is registered to login or not
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		PreparedStatement p , selectStats;
		try {
			
			p = c.prepareStatement("select * from user where email = ? and password = ?");
			p.setString(1, u.getEmail());
			p.setString(2,u.getPassword());
			
			ResultSet rs = p.executeQuery();
			
			if(rs.next()) {
				User res = new User();
				res.setId(rs.getInt("id"));
				res.setName(rs.getString("fullname"));
				res.setEmail(rs.getString("email"));
				res.setPhoneno(rs.getLong("phone_no"));
				res.setGender(rs.getString("gender"));
				res.setDob(rs.getDate("dob"));
				res.setAddress(rs.getString("address"));
				res.setCity(rs.getString("city"));
				res.setState(rs.getString("state"));
				res.setCountry(rs.getString("country"));
				res.setCompany(rs.getString("company"));
				res.setUsername(rs.getString("username"));
				res.setPassword(rs.getString("password"));
				//System.out.println(res.toString());
				
				try {
					int id=rs.getInt("id");
					selectStats= c.prepareStatement("Select * from userstats where userid = "+id+";");	
					ResultSet rss= selectStats.executeQuery();
					if(rss.next()) {
						PreparedStatement ps = c.prepareStatement("Update userstats set intime=CURRENT_TIMESTAMP where userid=?;");
						try {
							ps.setInt(1,rs.getInt("id"));
							ps.executeUpdate();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}
					else {
						PreparedStatement ps = c.prepareStatement("Insert into userstats(userid,intime) values(?,CURRENT_TIMESTAMP);");
						ps.setInt(1,rs.getInt("id"));
						ps.executeUpdate();
					}
				}catch(SQLException ee){
					ee.printStackTrace();
				}
				
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

	@Override
	public int checkUserDao(String email) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		PreparedStatement p;
		try {
			p = c.prepareStatement("select * from disabledusers where email = ?");
			p.setString(1,email);
			ResultSet rs = p.executeQuery();
			if(rs.next()) {
				return -1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			p = c.prepareStatement("select * from user where email = ?");
			p.setString(1,email);
			ResultSet rs = p.executeQuery();
			if(rs.next()) {
				return -2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

}
