package com.codefury.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codefury.beans.Contacts;
import com.codefury.dao.ContactDAOImpl;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    ContactDAOImpl contactdaoImpl ;
    public void init(){
    	contactdaoImpl= new ContactDAOImpl();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			contactdaoImpl.getContacts();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("NewFile.html");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		String fullName =request.getParameter("fullName");
		String email =request.getParameter("email");
		String phone_no =request.getParameter("phone_no");
		String gender =request.getParameter("gender");
		String dateOfBirth =request.getParameter("dateOfBirth");
		String address =request.getParameter("address");
		String city =request.getParameter("city");
		String state =request.getParameter("state");
		String country =request.getParameter("country");
		String company =request.getParameter("company");
		int uniqueId=001;
		
		Contacts contact = new Contacts();
		contact.setFullName(fullName);
		contact.setEmail(email);
		contact.setPhone_no(phone_no);
		contact.setGender(gender);
		contact.setDateOfBirth(dateOfBirth);
		contact.setAddress(address);
		contact.setCity(city);
		contact.setState(state);
		contact.setCountry(country);
		contact.setCompany(company);
		contact.setUniqueId(uniqueId);
		
		try {
			contactdaoImpl.addContact(contact);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("NewFile.html");
		rd.forward(request, response);
		
		
	}

}
