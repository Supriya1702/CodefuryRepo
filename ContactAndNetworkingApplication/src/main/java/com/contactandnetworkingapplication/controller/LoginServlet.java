package com.contactandnetworkingapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.contactandnetworkingapplication.dao.RegistrationDaoInterface;
import com.contactandnetworkingapplication.model.User;
import com.contactandnetworkingapplication.utility.DaoFactory;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(email + password);
		
		User u = new User();
		u.setEmail(email);
		u.setPassword(password);
		
		RegistrationDaoInterface ud = DaoFactory.createRegistrationObject();
		User res=ud.loginUserDao(u);
		if(res!=null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("id",res.getId());
			
			System.out.println("user id " + session.getAttribute("id"));
			System.out.println(res.getDob());
			request.setAttribute("User",res);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/MainPage.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("message","Invalid Username or password.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
		
	}

}
