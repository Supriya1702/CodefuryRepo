package com.contactandnetworkingapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.contactandnetworkingapplication.dao.BlockeUserdDaoInterface;
import com.contactandnetworkingapplication.model.BlockedUser;
import com.contactandnetworkingapplication.utility.DaoFactory;

/**
 * Servlet implementation class BlockUserServlet
 */
@WebServlet("/BlockUserServlet")
public class BlockUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BlockUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int blocked_id = Integer.parseInt(request.getParameter("blocked_id"));
		HttpSession session = request.getSession();
		int user_id=(int) session.getAttribute("id");
		BlockedUser b = new BlockedUser();
		b.setBlocked_id(blocked_id);
		b.setUser_id(user_id);
		
		BlockeUserdDaoInterface bd = DaoFactory.createBlockedDaoObject();
		int res = bd.blockUser(b);
		if(res==1) {
			request.setAttribute("message","User blocked.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchUser.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("message","Was unable to block User. Please try again.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchUser.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
