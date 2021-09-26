package com.contactandnetworkingapplication.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.contactandnetworkingapplication.model.Contacts;
import com.contactandnetworkingapplication.model.User;
import com.contactandnetworkingapplication.dao.ContactDAOImpl;

@WebServlet("/ContactServlet")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddContact() {
        super();
        // TODO Auto-generated constructor stub
    }

    ContactDAOImpl contactdaoImpl ;
    public void init(){
    	contactdaoImpl= new ContactDAOImpl();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		int id=(int) session.getAttribute("id");
		User u = new User();
		u.setId(id);
		System.out.println("user id a ");
		
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
		int uniqueId=id;
		System.out.println(id);		
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
		
		int res=0;
		try {
			res=contactdaoImpl.addContact(contact);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			request.setAttribute("message","Contact Added!");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddContactJsp.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("message","Could not add, Try Again!");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddContactJsp.jsp");
			rd.forward(request, response);
		}
		
	}

}
