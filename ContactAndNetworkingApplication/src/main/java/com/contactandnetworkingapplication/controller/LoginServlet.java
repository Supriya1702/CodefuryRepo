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
		HttpSession session = request.getSession();		//getting session object
		String email;
		String password;
		
		//if session is available 
		if(session.getAttribute("user")!=null) {
			User p = (User) session.getAttribute("user");
			email=p.getEmail();
			password =p.getPassword();
		}
		else {	//if session is not available
			email = request.getParameter("email");
			password = request.getParameter("password");
		}
		
		User u = new User();
		u.setEmail(email);
		u.setPassword(password);
		
		RegistrationDaoInterface ud = DaoFactory.createRegistrationObject();	//accessing dao layer
		User res=ud.loginUserDao(u);
		if(res!=null) {				//valid user
			session.setAttribute("id",res.getId());
			session.setAttribute("user", res);
			
			request.setAttribute("User",res);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/MainPage.jsp");
			rd.forward(request, response);
		}
		else {					//invalid user
			request.setAttribute("message","Invalid Username or password.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
		
	}

}
