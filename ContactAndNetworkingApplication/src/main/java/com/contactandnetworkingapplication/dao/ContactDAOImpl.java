package com.contactandnetworkingapplication.dao;

//import java.sql.Blob;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.contactandnetworkingapplication.dao.ContactDAO;
import com.contactandnetworkingapplication.model.Contacts;
import com.contactandnetworkingapplication.model.User;

//Implementing the functionalities for contact class.
public class ContactDAOImpl implements ContactDAO{
	private static String conURL;
	private static String dbDriver;
	private static String dbUsername;
	private static String dbPassword;
	
	//initializing the values for database connection.
	static {
		conURL ="jdbc:mysql://85.10.205.173:3306/codefury_contact"; //database hosted on db4free.net 
		dbDriver="com.mysql.cj.jdbc.Driver";       
		dbUsername="app_monsters";
		dbPassword="student1234";
	}
	

	//Using Contacts class to insert data in 'contacts' table of database.
	@Override
	public int addContact(Contacts contact) throws ClassNotFoundException {
		//Storing the database query into aString variable.
		String INSERT_INTO_CONTACTS ="Insert into contacts(user_id, fullname,email, phoneno, gender, dob, address, city, state, country, company) values"+"(?,?,?,?,?,?,?,?,?,?,?);";
		
		int result=0;
		Class.forName(dbDriver);
		
		//Creating connection to db and executing the Insert query.
		try (Connection con = DriverManager.getConnection(conURL, dbUsername,dbPassword);

	            // Creating a statement using connection object
	            PreparedStatement ps = con.prepareStatement(INSERT_INTO_CONTACTS)) {
			    ps.setInt(1, contact.getUniqueId());
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
	            //Executing the query.
	            result = ps.executeUpdate();
	            if(result>0)
					System.out.println(result + " record/records inserted");

	        } catch (SQLException e) {
	            // processing sql exception
	            printSQLException(e);
	   }
	   return result;
	   
	}
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
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

	
	//function to get a list of Contacts for the user from database.
	@Override
	public List<Contacts> getContacts(int id) throws ClassNotFoundException {
		
		//Storing the database query into a String variable.
		String SELECT_FROM_CONTACTS ="Select * from contacts where user_id= "+id+";"; 
		Class.forName(dbDriver);
		
		ArrayList<Contacts> contactList = new ArrayList<>();
		
		//Creating connection to db and executing the Select query.
		try (Connection con = DriverManager.getConnection(conURL, dbUsername,dbPassword);
				Statement stmt = con.createStatement();){
				ResultSet rs = stmt.executeQuery(SELECT_FROM_CONTACTS);
	            while(rs.next()) {
	            	//Creating Contacts object to store in a list.  
					Contacts contact = new Contacts();
					contact.setFullName(rs.getString("fullName"));
					contact.setEmail(rs.getString("email"));
					contact.setPhone_no(rs.getString("phoneno"));
					contact.setGender(rs.getString("gender"));
					System.out.println(rs.getString("dob"));
					if(rs.getString("dob")!=null) {
						contact.setDateOfBirth(rs.getString("dob"));						
					}else {
						contact.setDateOfBirth("Not Found!");						
					}
					contact.setAddress(rs.getString("address"));
					contact.setCity(rs.getString("city"));
					contact.setState(rs.getString("state"));
					contact.setCountry(rs.getString("country"));
					contact.setCompany(rs.getString("company"));
					//contact.setFullName(rs.getString("contactImage"));
					contact.setContact_id(rs.getInt("contact_id"));
					
					//adding the contact object to the list.
					contactList.add(contact);
	            }
	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	   }
		return contactList;
	}

	//function to delete contacts from the database.
	@Override
	public void deleteContact(List<Integer> contact_ids) throws ClassNotFoundException {
		//Storing the database query into a String variable.
		String DELETE_CONTACT ="DELETE FROM contacts WHERE contact_id=?";
		
		int result=0;
		Class.forName(dbDriver);
		
		//Creating connection to db and executing the Select query.
		try (Connection con = DriverManager.getConnection(conURL, dbUsername,dbPassword);
			PreparedStatement ps = con.prepareStatement(DELETE_CONTACT)) {
			
			//for deleting multiple contacts at a time.
			for (int deletedContact : contact_ids) {
			    ps.setInt(1, deletedContact);
			    result=ps.executeUpdate();
			}
		}catch (SQLException e) {
            // processing sql exception
            printSQLException(e);
		}

	    	
	}

}
