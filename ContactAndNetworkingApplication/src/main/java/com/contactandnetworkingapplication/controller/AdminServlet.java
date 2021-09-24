package com.contactandnetworkingapplication.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactandnetworkingapplication.dao.AdminDaoInterface;
import com.contactandnetworkingapplication.utility.DaoFactory;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDaoInterface a;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        a = DaoFactory.createAdminObject();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option = request.getParameter("option");
		if(option.equals("disabled")) {
			HashMap<Integer, String> hp = a.getDisabledUsers();
			request.setAttribute("info",hp);
			System.out.println("Size : " + hp.size());
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/DisabledPage.jsp");
			rd.forward(request, response);
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
