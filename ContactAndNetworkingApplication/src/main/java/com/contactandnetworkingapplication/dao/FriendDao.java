package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.contactandnetworkingapplication.exception.DeleteFriendException;
import com.contactandnetworkingapplication.exception.FetchFriendException;
import com.contactandnetworkingapplication.model.Friend;
import com.contactandnetworkingapplication.model.User;

public class FriendDao implements FriendDaoInterface {

	@Override
	public List<User> viewFriendsDao(User u) throws FetchFriendException {		//fetching friends from friends table 
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
		} 
		catch (SQLException e) {
			throw new FetchFriendException();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int removeFriend(Friend f) throws DeleteFriendException {		//removing from friend table
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
			throw new DeleteFriendException();
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

	@Override
	public HashMap<Integer, String> viewBlocked(int id) {	//viewing blocked users
		final String SQL = "Select blocked_id from blockedusers where user_id = ?";
		ConnectionUtil a = new ConnectionUtil();
		Connection conn=a.createConnection();
		PreparedStatement ps;
		List <Integer> idList = new ArrayList();
		try {
			
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				int blocked_id = (int) rs.getInt("blocked_id");
				idList.add(blocked_id);
			}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("List Size : " + idList.size());
			HashMap<Integer , String> hp = getUserName(idList);
			if(hp != null) return hp;
			return null;
	}
	private HashMap<Integer,  String> getUserName(List <Integer> idList) {
		HashMap<Integer , String> hp = new HashMap<>();
		for(Integer id : idList) {
			final String SQL1 = "Select fullname from user where id = ?";
			ConnectionUtil a = new ConnectionUtil();
			Connection conn=a.createConnection();
			PreparedStatement ps;
			try {
				
				ps = conn.prepareStatement(SQL1);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					String name  =  rs.getString("fullname");
					hp.put(id, name);
				}
				else
				{
					return null;
				}
			}catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return hp;
	}

	@Override
	public int confirmBlocked(int user_id , int blocked_id) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		try {
			c.setAutoCommit(false);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		PreparedStatement p=null;
		int res1=0;
		try {
			p = c.prepareStatement("delete from blockedusers where (user_id=? and blocked_id=?)");
			p.setInt(1,user_id);
			p.setInt(2,blocked_id);
			
			res1 = p.executeUpdate();
			System.out.println("1st " + res1);
			if(res1 != -1) return 1;
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
		return 0;
	}
	
}