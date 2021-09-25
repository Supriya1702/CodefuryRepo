package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.contactandnetworkingapplication.model.BlockedUser;

public class BlockedUserDao implements BlockeUserdDaoInterface {

	@Override
	public int blockUser(BlockedUser b) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		PreparedStatement p=null;
		int res=0;
		try {
			p=c.prepareStatement("insert into blockedusers(user_id,blocked_id) values(?,?)");
			p.setInt(1, b.getUser_id());
			p.setInt(2, b.getBlocked_id());
			
			res=p.executeUpdate();
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
