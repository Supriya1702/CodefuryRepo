package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.contactandnetworkingapplication.model.FriendRequest;
import com.contactandnetworkingapplication.model.User;

public class SearchDao implements SearchDaoInterface {

	@Override
	public List<User> searchByCityDao(User u) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		PreparedStatement p=null;
		List<User> list = new ArrayList<User>();
		try {
			p = c.prepareStatement("select u.id,u.fullname from user u where city=? and u.id<>? and u.id not in (select blocked_id from blockedusers b where b.user_id=?) "
					+ "and u.id not in (select friend_id  from friends where user_id = ?) and u.id not in (select user_id  from friends where friend_id = ?);");
			p.setString(1, u.getCity());
			p.setInt(2, u.getId());
			p.setInt(3, u.getId());
			p.setInt(4, u.getId());
			p.setInt(5, u.getId());
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				User res = new User();
				res.setId(rs.getInt(1));
				res.setName(rs.getString(2));
				System.out.println(res.getId() + " " + res.getName());
				list.add(res);
			}
			return list;
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
	public List<User> searchbyStateDao(User u) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		PreparedStatement p=null;
		List<User> list = new ArrayList<User>();
		try {
			p = c.prepareStatement("select u.id,u.fullname from user u where state=? and u.id<>? and u.id not in (select blocked_id from blockedusers b where b.user_id=?) "
					+ "and u.id not in (select friend_id  from friends where user_id = ?) and u.id not in (select user_id  from friends where friend_id = ?);");
			p.setString(1, u.getState());
			p.setInt(2, u.getId());
			p.setInt(3, u.getId());
			p.setInt(4, u.getId());
			p.setInt(5, u.getId());
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				User res = new User();
				res.setId(rs.getInt(1));
				res.setName(rs.getString(2));
				System.out.println(res.getId() + " " + res.getName());
				list.add(res);
			}
			return list;
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
	public List<User> searchbyCompanyDao(User u) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		PreparedStatement p=null;
		List<User> list = new ArrayList<User>();
		try {
			p = c.prepareStatement("select u.id,u.fullname from user u where company=? and u.id<>? and u.id not in (select blocked_id from blockedusers b where b.user_id=?) "
					+ "and u.id not in (select friend_id  from friends where user_id = ?) and u.id not in (select user_id  from friends where friend_id = ?);");
			p.setString(1, u.getCompany());
			p.setInt(2, u.getId());
			p.setInt(3, u.getId());
			p.setInt(4, u.getId());
			p.setInt(5, u.getId());
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				User res = new User();
				res.setId(rs.getInt(1));
				res.setName(rs.getString(2));
				System.out.println(res.getId() + " " + res.getName());
				list.add(res);
			}
			return list;
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
