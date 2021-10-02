package com.contactandnetworkingapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.contactandnetworkingapplication.dao.RegistrationDaoInterface;
import com.contactandnetworkingapplication.dao.UpdateDaoInterface;
import com.contactandnetworkingapplication.model.Admin;
import com.contactandnetworkingapplication.model.User;
import com.contactandnetworkingapplication.utility.DaoFactory;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession(true);
		int id =  (int) session.getAttribute("id");
		String email = request.getParameter("user-email");
		System.out.println(email);
		String name = request.getParameter("user-name");
		System.out.println(name);
		long phoneno = Long.parseLong(request.getParameter("user-phone"));
		System.out.println(phoneno);
		String gender= request.getParameter("user-gender");
		Date dob = Date.valueOf(request.getParameter("user-dob"));
		String address = request.getParameter("user-address");
		System.out.println(address);
		String city = request.getParameter("user-city");
		System.out.println(city);
		String state = request.getParameter("user-state");
		System.out.println(state);
		String country = request.getParameter("user-country");
		System.out.println(country);
		String company = request.getParameter("user-company");
		String username = request.getParameter("user-username");
		String password = request.getParameter("user-password");
		

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
		u.setId(id);
		u.setUsername(username);
		u.setPassword(password);
		
		
		UpdateDaoInterface ud = DaoFactory.createUpdateObject();	
		int res = ud.UpdateUserDao(u);
		if(res>0) {
			session.setAttribute("user", u);
			request.setAttribute("message","Successfully updated");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewProfile.jsp");
			rd.forward(request, response);
		}
		else {			
			request.setAttribute("message","Could not update. Please try again.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewProfile.jsp");
			rd.forward(request, response);
		}
		
	}

}
