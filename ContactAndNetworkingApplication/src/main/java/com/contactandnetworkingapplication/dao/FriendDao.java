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
	public List<Friend> viewFriendsDao(User u) {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		PreparedStatement p=null;
		List<Friend> list = new ArrayList<Friend>();
		String sql="select u.id,u.fullname from user u where u.id in (select friend_id  from friends where user_id = ?) or id in (select user_id  from friends where friend_id = ?);";
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, u.getId());
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				Friend res = new Friend();
				res.setUser_id(rs.getInt(1));
				res.setFriend_id(rs.getInt(2));
				res.setFriend_pk(rs.getInt(3));
				
				System.out.println(res.getFriend_id() + " " + res.getUser_id() + " " + res.getFriend_pk());
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
		int res1=0;
		try {
			p = con.prepareStatement("delete from friends where friend_pk=?");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.commit();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res1;
	}
	
}
