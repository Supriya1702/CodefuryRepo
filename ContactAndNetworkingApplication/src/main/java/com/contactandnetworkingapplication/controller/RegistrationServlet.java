package com.contactandnetworkingapplication.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactandnetworkingapplication.dao.RegistrationDaoInterface;
import com.contactandnetworkingapplication.model.User;
import com.contactandnetworkingapplication.utility.DaoFactory;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");		//getting user details for registration
		String email= request.getParameter("email");
		long phoneno = Long.parseLong(request.getParameter("phoneno"));
		String gender= request.getParameter("gender");
		Date dob = Date.valueOf(request.getParameter("dob"));
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String company = request.getParameter("company");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RegistrationDaoInterface ud = DaoFactory.createRegistrationObject();	//accessing Dao Layer
		int res = ud.checkUserDao(email);
		if(res == 1) {
			User u = new User();
			u.setName(name);
			u.setEmail(email);
			u.setPhoneno(phoneno);
			u.setGender(gender);
			u.setDob(dob);
			u.setAddress(address);
			u.setCity(city);
			u.setState(state);
			u.setCountry(country);
			u.setCompany(company);
			u.setUsername(username);
			u.setPassword(password);
			
			
			int res1= ud.registerUserDao(u);
			
			if(res1>0) {			//if registration is successful
				request.setAttribute("message","Registration successful. <a href=Login.jsp>Sign In</a>");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegistrationPage.jsp");
				rd.forward(request, response);
			}
			else {				//if unable to register
				request.setAttribute("message","Could not register.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegistrationPage.jsp");
				rd.forward(request, response);
			}
		}
		else if(res == -1){					// if user is disabled
				request.setAttribute("message","Could not register.This email has been disabled");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegistrationPage.jsp");
				rd.forward(request, response);
		}
		else { 								// if user with email is already present
			request.setAttribute("message","Could not register.This email is already registered with us.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegistrationPage.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
