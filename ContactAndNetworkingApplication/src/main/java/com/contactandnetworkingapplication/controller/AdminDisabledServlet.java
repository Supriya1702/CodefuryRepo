package com.contactandnetworkingapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactandnetworkingapplication.dao.AdminDaoInterface;
import com.contactandnetworkingapplication.utility.DaoFactory;

/**
 * Servlet implementation class AdminDisabledFunctionality
 */
@WebServlet("/AdminDisabledFunctionality")
public class AdminDisabledServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDisabledServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option = request.getParameter("option");
		if(option.equals("accept")) {
			int id = Integer.parseInt(request.getParameter("id"));
			AdminDaoInterface a = DaoFactory.createAdminObject();
			int res = a.confirmDisabled(id);
			if(res==1) {
				request.setAttribute("message","Disabled Successfully");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminServlet?option=disabled");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("message","Was unable to disable user. Please try again.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminServlet?option=disabled");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
