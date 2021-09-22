package com.contactandnetworkingapplication.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.contactandnetworkingapplication.dao.FriendDaoInterface;
import com.contactandnetworkingapplication.model.User;
import com.contactandnetworkingapplication.utility.DaoFactory;


@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FriendServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FriendDaoInterface ud = DaoFactory.createFriend();
		
		HttpSession session = request.getSession(true);
		int id=(int) session.getAttribute("id");
		User u = new User();
		u.setId(id);
		System.out.println("user id " + session.getAttribute("id"));
		List<User> list=ud.friendDao(u);
		
		if(list.size()>0) {
			request.setAttribute("list",list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Friends.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("message","No friends to show.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Friends.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
