package com.contactandnetworkingapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.contactandnetworkingapplication.dao.SendFriendRequestDaoInterface;
import com.contactandnetworkingapplication.model.FriendRequest;
import com.contactandnetworkingapplication.utility.DaoFactory;

/**
 * Servlet implementation class SendFriendRequestServlet
 */
@WebServlet("/SendFriendRequestServlet")
public class SendFriendRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendFriendRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int receiver_id = Integer.parseInt(request.getParameter("receiver_id"));
		HttpSession session = request.getSession();
		int sender_id=(int) session.getAttribute("id");
		FriendRequest f = new FriendRequest();
		f.setReceiver_id(receiver_id);
		f.setSender_id(sender_id);
		
		SendFriendRequestDaoInterface fd = DaoFactory.createSendFriendRequestDao(); 	//accessing Dao Layer
		int res = fd.sendFriendRequest(f);
		if(res==1) {		//if successful
			request.setAttribute("message","Friend Request Sent");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchUser.jsp");
			rd.forward(request, response);
		}
		else {				//if unsuccessful
			request.setAttribute("message","Was unable to Send Friend Request. Please try again.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchUser.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
