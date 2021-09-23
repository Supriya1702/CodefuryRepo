package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.contactandnetworkingapplication.model.Friend;
import com.contactandnetworkingapplication.model.User;

public class FriendDao implements FriendDaoInterface {

	@Override
	public List<User> viewFriendsDao(User u) {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		PreparedStatement p=null;
		List<User> list = new ArrayList<User>();
		String sql="select u.id,u.fullname from user u where u.id in (select friend_id  from friends where user_id = ?) or u.id in (select user_id  from friends where friend_id = ?);";
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, u.getId());
			p.setInt(2, u.getId());
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				User res = new User();
				res.setId(rs.getInt(1));
				res.setName(rs.getString(2));
				
				System.out.println(res.getId() + " " + res.getName());
				list.add(res);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public int removeFriend(Friend f) {
		ConnectionUtil a = new ConnectionUtil();
		Connection con = a.createConnection();
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement p = null;
		int res=0;
		try {
			p = con.prepareStatement("delete from friends where (user_id=? and friend_id=?) or (user_id=? and friend_id=?)");
			p.setInt(1, f.getUser_id());
			p.setInt(2, f.getFriend_id());
			p.setInt(3, f.getFriend_id());
			p.setInt(4, f.getUser_id());
			res=p.executeUpdate();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.commit();
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
}
