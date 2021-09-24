package com.contactandnetworkingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.contactandnetworkingapplication.model.Admin;
import com.contactandnetworkingapplication.model.User;

public class AdminDAO implements AdminDaoInterface {
	

	

	@Override
	public Admin getAdminByCredentials(String username, String password) {
		ConnectionUtil a = new ConnectionUtil();
		Connection conn=a.createConnection();
		final String SQL = "select * from admin where admin_username = ? and admin_password = ?";
		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminName(rs.getString("admin_name"));
				admin.setAdminEmail(rs.getString("admin_email"));
				admin.setAdminPhone(rs.getInt("admin_phoneno"));
				System.out.println(admin);
				return admin;
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
		return null;
		
	}

	@Override
	public int getCount() {
		final String SQL = "select count(*) from user";
		ConnectionUtil a = new ConnectionUtil();
		Connection conn=a.createConnection();
		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int count  = (int) rs.getInt("count(*)");
				return count;
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
		return 0;
	}

	@Override
	public HashMap <Integer , String> getDisabledUsers() {
		final String SQL = "SELECT blocked_id, COUNT(*) as counter FROM blockedusers GROUP BY blocked_id HAVING counter >= 3";
		ConnectionUtil a = new ConnectionUtil();
		Connection conn=a.createConnection();
		PreparedStatement ps;
		List <Integer> idList = new ArrayList();
		try {
			
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				int id = (int) rs.getInt("blocked_id");
				idList.add(id);
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
			HashMap<Integer , String> hp = getUserLocation(idList);
			if(hp != null) return hp;
			return null;
	}
	
	private HashMap<Integer,  String> getUserLocation(List <Integer> idList) {
		HashMap<Integer , String> hp = new HashMap<>();
		for(Integer id : idList) {
			final String SQL1 = "Select state from user where id = ?";
			ConnectionUtil a = new ConnectionUtil();
			Connection conn=a.createConnection();
			PreparedStatement ps;
			try {
				
				ps = conn.prepareStatement(SQL1);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					String location  =  rs.getString("state");
					hp.put(id, location);
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
	public int confirmDisabled(int id) {
		ConnectionUtil a = new ConnectionUtil();
		Connection c=a.createConnection();
		System.out.println("From here everything starts" + id);
		try {
			c.setAutoCommit(false);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		PreparedStatement p=null;
		int res1=0,res2=0;
		try {
			p = c.prepareStatement("delete from blockedusers where user_id=?");
			p.setInt(1,id);
			
			res1 = p.executeUpdate();
			System.out.println("1st " + res1);
			
			if(res1!= -1) {
				p = c.prepareStatement("delete from blockedusers where blocked_id=?");
				p.setInt(1,id);
				
				res1 = p.executeUpdate();
				System.out.println("2nd " + res1);
			}
			if(res1  != -1) {
				p = c.prepareStatement("delete from contacts where contact_id=?");
				p.setInt(1,id);
				
				res1 = p.executeUpdate();
				System.out.println("3rd " + res1);
			}if(res1 != -1) {
				p = c.prepareStatement("delete from contacts where user_id=?");
				p.setInt(1,id);
				
				res1 = p.executeUpdate();
				System.out.println("4th " + res1);
			}if(res1 != -1) {
				p = c.prepareStatement("delete from friendrequest where sender_id=?");
				p.setInt(1,id);
				
				res1 = p.executeUpdate();
				System.out.println("5th " + res1);
			}if(res1 != -1) {
				p = c.prepareStatement("delete from friendrequest where receiver_id=?");
				p.setInt(1,id);
				
				res1 = p.executeUpdate();
				System.out.println("6th " + res1);
			}if(res1 != -1) {
				p = c.prepareStatement("delete from friends where user_id=?");
				p.setInt(1,id);
				
				res1 = p.executeUpdate();
				System.out.println("7th " + res1);
			}if(res1 != -1) {
				p = c.prepareStatement("delete from friends where friend_id=?");
				p.setInt(1,id);
				
				res1 = p.executeUpdate();
				System.out.println("8th " + res1);
			}if(res1 != -1) {
				p=c.prepareStatement("insert into disabledusers value (?)");
				p.setInt(1, id);
				
				res2=p.executeUpdate();
				System.out.println("9th " + res1);
			}if(res2 != -1) {
				p = c.prepareStatement("delete from user where id=?");
				p.setInt(1,id);
				
				res1 = p.executeUpdate();
				System.out.println("10th " + res1);
			}
			if(res1!=-1 && res2 != -1)
				return 1;
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
		return 1;
	}
	
	
	
}
