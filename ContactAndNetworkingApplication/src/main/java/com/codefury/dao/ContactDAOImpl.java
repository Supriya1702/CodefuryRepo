package com.codefury.dao;

//import java.sql.Blob;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.codefury.beans.Contacts;



public class ContactDAOImpl implements ContactDAO{
	private static String conURL;
	private static String dbDriver;
	private static String dbUsername;
	private static String dbPassword;
	
	
	static {
		conURL ="jdbc:mysql://85.10.205.173:3306/codefury_contact";
		dbDriver="com.mysql.cj.jdbc.Driver";
		dbUsername="app_monsters";
		dbPassword="student1234";
	}
	

	@Override
	public int addContact(Contacts contact) throws ClassNotFoundException {
		String INSERT_INTO_CONTACTS ="Insert into contacts(user_id, fullname,email, phoneno, gender, dob, address, city, state, country, company) values"+"(?,?,?,?,?,?,?,?,?,?,?);";
		
		int result=0;
		System.out.println("In add Contacts -- Value is initialized");
		Class.forName(dbDriver);
		
		try (Connection con = DriverManager.getConnection(conURL, dbUsername,dbPassword);

	            // Step 2:Create a statement using connection object
	            PreparedStatement ps = con.prepareStatement(INSERT_INTO_CONTACTS)) {
			    ps.setString(1, "0001");
	            ps.setString(2, contact.getFullName());
	            ps.setString(3, contact.getEmail());
	            ps.setString(4, contact.getPhone_no());
	            ps.setString(5, contact.getGender());
	            ps.setDate(6, contact.getDateOfBirth());
	            ps.setString(7, contact.getAddress());
	            ps.setString(8, contact.getCity());
	            ps.setString(9, contact.getState());
	            ps.setString(10, contact.getCountry());
	            ps.setString(11, contact.getCompany());
	           // ps.setBlob(12,(Blob) contact.getContactImage());

	            System.out.println(ps);
	            // Step 3: Execute the query or update query
	            result = ps.executeUpdate();
	            if(result>0)
					System.out.println(result + " record/records inserted");

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	   }
	   return result;
	   
	}
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
	

	@Override
	public void updateContactDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contacts> getContacts() throws ClassNotFoundException {
		String SELECT_FROM_CONTACTS ="Select * from contacts;"; 
		int result=0;
		System.out.println("In add Contacts -- Value is initialized");
		Class.forName(dbDriver);
		
		try (Connection con = DriverManager.getConnection(conURL, dbUsername,dbPassword);
				Statement stmt = con.createStatement();){
				ResultSet rs = stmt.executeQuery(SELECT_FROM_CONTACTS);
	            while(rs.next()) {
					System.out.println(rs.getString("fullName") + rs.getString("email") +" record/records inserted");
	            }
	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	   }
		return null;
	}

	@Override
	public void deleteContact() {
		// TODO Auto-generated method stub
		
	}

}
