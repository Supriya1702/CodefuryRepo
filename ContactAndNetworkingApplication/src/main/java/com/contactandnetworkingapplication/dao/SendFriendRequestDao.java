package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.contactandnetworkingapplication.model.FriendRequest;
import com.contactandnetworkingapplication.model.User;

public class SendFriendRequestDao implements SendFriendRequestDaoInterface {

	@Override
	public int sendFriendRequest(FriendRequest f) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		PreparedStatement p=null;
		int res=0;
		try {
			p = c.prepareStatement("select u.fullname from user u where u.id=?");
			p.setInt(1, f.getSender_id());
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				f.setSender_name(rs.getString(1));
			}
			p=c.prepareStatement("insert into friendrequest(receiver_id,sender_id,sender_name) values(?,?,?)");
			p.setInt(1, f.getReceiver_id());
			p.setInt(2, f.getSender_id());
			p.setString(3, f.getSender_name());
			
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
