package com.contactandnetworkingapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactandnetworkingapplication.dao.ContactDAOImpl;


@WebServlet("/DeleteContact")
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteContact() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String selectedContacts = request.getParameter("labelcon");
		String[] listOfSelectedContacts = selectedContacts.split(",");
		if(selectedContacts=="") {
			request.setAttribute("message","No contact selected");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ContactDetailsJsp.jsp");
			rd.forward(request, response);
		}else {
			
			System.out.println("selectedContacts ... "+selectedContacts);
			System.out.println("selectedContacts ... "+listOfSelectedContacts.length);
			List<Integer> deletedContactsList = new ArrayList<>();
			for (String s: listOfSelectedContacts) {
				deletedContactsList.add(Integer.parseInt(s));
			}
			ContactDAOImpl contactdaoImpl= new ContactDAOImpl();
			try {
				contactdaoImpl.deleteContact(deletedContactsList); 
			}catch(ClassNotFoundException e) 
			{ e.printStackTrace(); }
			request.setAttribute("message","Could not add, Try Again!");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ContactDetailsJsp.jsp");
			rd.forward(request, response);
		}	
	}

}
