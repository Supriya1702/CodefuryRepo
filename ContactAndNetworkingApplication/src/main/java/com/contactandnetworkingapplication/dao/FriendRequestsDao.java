package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.contactandnetworkingapplication.model.FriendRequest;
import com.contactandnetworkingapplication.model.User;

public class FriendRequestsDao implements FriendRequestsDaoInterface {

	@Override
	public List<FriendRequest> viewFriendRequestsDao(User u) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		PreparedStatement p=null;
		List<FriendRequest> list = new ArrayList<FriendRequest>();
		try {
			p = c.prepareStatement("select f.friend_request_pk,f.receiver_id,f.sender_id,f.sender_name f from friendrequest f join user u on f.receiver_id=u.id where receiver_id=?;");
			p.setInt(1, u.getId());
			
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				FriendRequest res = new FriendRequest();
				res.setFriend_request_pk(rs.getInt(1));
				res.setReceiver_id(rs.getInt(2));
				res.setSender_id(rs.getInt(3));
				res.setSender_name(rs.getString(4));
				System.out.println(res.getFriend_request_pk()+ " " + res.getReceiver_id() + " " + res.getSender_id() + " " + res.getSender_name());
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
	public int acceptFriendRequestDao(FriendRequest f) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		try {
			c.setAutoCommit(false);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		PreparedStatement p=null;
		int res1=0,res2=0;
		try {
			p = c.prepareStatement("delete from friendrequest where friend_request_pk=?");
			p.setInt(1,f.getFriend_request_pk());
			
			res1 = p.executeUpdate();
			if(res1==1) {
				p=c.prepareStatement("insert into friends(user_id,friend_id) values(?,?)");
				p.setInt(1, f.getReceiver_id());
				p.setInt(2, f.getSender_id());
				
				res2=p.executeUpdate();
			}
			if(res1==1 && res2==1)
				return res2;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.commit();
				c.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res2;
	}

	@Override
	public int ignoreFriendRequestDao(FriendRequest f) {
		int res=0;
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		PreparedStatement p=null;
		try {
			p = c.prepareStatement("delete from friendrequest where friend_request_pk=?");
			p.setInt(1,f.getFriend_request_pk());
			
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
	public int blockFriendRequestDao(FriendRequest f) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		try {
			c.setAutoCommit(false);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		PreparedStatement p=null;
		int res1=0,res2=0;
		try {
			p = c.prepareStatement("delete from friendrequest where friend_request_pk=?");
			p.setInt(1,f.getFriend_request_pk());
			
			res1 = p.executeUpdate();
			if(res1==1) {
				p=c.prepareStatement("insert into blockedusers(user_id,blocked_id) values(?,?)");
				p.setInt(1, f.getReceiver_id());
				p.setInt(2, f.getSender_id());
				
				res2=p.executeUpdate();
			}
			if(res1==1 && res2==1)
				return res2;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.commit();
				c.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res2;
	}

}
