package com.contactandnetworkingapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.contactandnetworkingapplication.model.Admin;



import com.contactandnetworkingapplication.dao.AdminDAO;
import com.contactandnetworkingapplication.dao.AdminDaoInterface;
import com.contactandnetworkingapplication.utility.DaoFactory;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		System.out.println(username + password);
		AdminDaoInterface a = DaoFactory.createAdminObject();
		Admin admin = a.getAdminByCredentials(username, password);
		int count = a.getCount();
		if(admin != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("id" , admin.getAdminId());
			
			request.setAttribute("name", admin.getAdminName());
			request.setAttribute("email", admin.getAdminEmail());
			request.setAttribute("phone", admin.getAdminPhone());
			request.setAttribute("count", count);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminPage.jsp");
			rd.forward(request, response);
			
		}
		else {
//			request.setAttribute("message","Invalid Username or password.");
			PrintWriter out = response.getWriter();
			out.print("Invalid Username or Password");
			RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin.jsp");
			rd.include(request, response);
		}
	}

}
