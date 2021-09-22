package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.contactandnetworkingapplication.model.User;

public class FriendDao implements FriendDaoInterface {

	@Override
	public List<User> friendDao(User u) {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		PreparedStatement p;
		List<User> list = new ArrayList<User>();
		String sql="select id,fullname,profileImage from user where id in (select friend_id from friends where user_id = ?) or id in (select user_id from friends where friend_id = ?);";
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, u.getId());
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				User res = new User();
				res.setName(rs.getString(1));
				System.out.println(res.getName());
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
	
}
