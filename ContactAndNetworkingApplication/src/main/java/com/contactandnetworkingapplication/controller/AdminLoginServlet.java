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
import com.contactandnetworkingapplication.model.User;
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
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username;
		String password;
		if(session.getAttribute("p")!=null) {	//if session is available
			Admin p = (Admin) session.getAttribute("p");
			username=p.getAdminUserName();
			password =p.getAdminPassword();
		}
		else {					//is session is not available
			username = request.getParameter("username");
			password = request.getParameter("password");
		}
		AdminDaoInterface a = DaoFactory.createAdminObject();		//accessing Dao Layer
		Admin admin = a.getAdminByCredentials(username, password);
		int count = a.getCount();
		if(admin != null) {				//if valid details are entered for login by admin
			session.setAttribute("id" , admin.getAdminId());
			session.setAttribute("p", admin);
			request.setAttribute("name", admin.getAdminName());
			request.setAttribute("email", admin.getAdminEmail());
			request.setAttribute("phone", admin.getAdminPhone());
			request.setAttribute("count", count);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminPage.jsp");
			rd.forward(request, response);
			
		}
		else {							//if invalid details are entered for login by admin
//			request.setAttribute("message","Invalid Username or password.");
			PrintWriter out = response.getWriter();
			out.print("<html><body>Invalid Username or Password</body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin.jsp");
			rd.include(request, response);
		}
	}

}
