package com.contactApplication.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactApplication.dao.RegistrationDaoInterface;
import com.contactApplication.model.User;
import com.contactApplication.utility.DaoFactory;

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
		String name = request.getParameter("name");
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
		
		System.out.println(name+email+phoneno+gender+ dob + address +city+state+country+company+username + password);

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
		
		RegistrationDaoInterface ud = DaoFactory.createObject();
		int res=ud.registerUserDao(u);
		
		if(res>0) {
			request.setAttribute("message","Registration successful. <a href=Login.jsp>Sign In</a>");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegistrationPage.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("message","Could not register.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegistrationPage.jsp");
			rd.forward(request, response);
		}
		
	}

}
