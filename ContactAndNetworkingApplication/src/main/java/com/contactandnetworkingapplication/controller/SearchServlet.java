package com.contactandnetworkingapplication.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.contactandnetworkingapplication.dao.SearchDaoInterface;
import com.contactandnetworkingapplication.model.User;
import com.contactandnetworkingapplication.utility.DaoFactory;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		String select = request.getParameter("select");
		HttpSession session = request.getSession();
		int user_id=(int) session.getAttribute("id");
		
		if(select.equals("city")) {
			String search = request.getParameter("search");
			User u = new User();
			u.setId(user_id);
			u.setCity(search);
			
			SearchDaoInterface sd = DaoFactory.createSearchObject();
			List<User> list = sd.searchByCityDao(u);
			if(list.size()>0) {
				request.setAttribute("list",list);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchUser.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("message","No users found");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchUser.jsp");
				rd.forward(request, response);
			}
		}
		else if(select.equals("state")) {
			String search = request.getParameter("search");
			User u = new User();
			u.setId(user_id);
			u.setState(search);
			
			SearchDaoInterface sd = DaoFactory.createSearchObject();
			List<User> list = sd.searchbyStateDao(u);
			if(list.size()>0) {
				request.setAttribute("list",list);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchUser.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("message","No users found");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchUser.jsp");
				rd.forward(request, response);
			}
		}
		else if(select.equals("company")) {
			String search = request.getParameter("search");
			User u = new User();
			u.setId(user_id);
			u.setCompany(search);
			
			SearchDaoInterface sd = DaoFactory.createSearchObject();
			List<User> list = sd.searchbyCompanyDao(u);
			if(list.size()>0) {
				request.setAttribute("list",list);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchUser.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("message","No users found");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchUser.jsp");
				rd.forward(request, response);
			}
		}
	
	}

}
