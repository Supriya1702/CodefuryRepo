package com.contactandnetworkingapplication.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactandnetworkingapplication.dao.AdminDaoInterface;
import com.contactandnetworkingapplication.dao.ContactDAOImpl;
import com.contactandnetworkingapplication.utility.DaoFactory;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option = request.getParameter("option");
		if(option.equals("disabled")) {
			AdminDaoInterface a= DaoFactory.createAdminObject();
			HashMap<Integer, String> hp = a.getDisabledUsers();
			
			
			if(hp.size() == 0) {
				request.setAttribute("message","No users to show.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminDisabledPage.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("info",hp);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminDisabledPage.jsp");
				rd.forward(request, response);
			}
		} else if(option.equals("disable")) {
			String selectedUsers = request.getParameter("labelcon");
			String[] listOfUsers = selectedUsers.split(",");
			if(selectedUsers=="") {
				request.setAttribute("message","No user selected");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminDisabledPage.jsp");
				rd.include(request, response);
			}else {
				
				System.out.println("selectedUsers ... "+selectedUsers);
				System.out.println("selectedUers length... "+listOfUsers.length);
				AdminDaoInterface a = DaoFactory.createAdminObject();
				int flag = 0;
				for (String s: listOfUsers) {
					int id = Integer.parseInt(s);
					int res = a.confirmDisabled(id);
					if(res != 1) {
						request.setAttribute("message","Was unable to disable user. Please try again.");
						flag = 1;
						break;
					}
				}
				if(flag == 0) {
					request.setAttribute("message","Disabled Successfully");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminServlet?option=disabled");
					rd.forward(request, response);
				}
				else {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminServlet?option=disabled");
					rd.forward(request, response);
				}
			
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
