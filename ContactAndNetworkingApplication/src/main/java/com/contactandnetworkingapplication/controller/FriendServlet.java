package com.contactandnetworkingapplication.controller;

import java.util.HashMap;
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
import com.contactandnetworkingapplication.model.Friend;
import com.contactandnetworkingapplication.model.FriendRequest;
import com.contactandnetworkingapplication.model.User;
import com.contactandnetworkingapplication.utility.DaoFactory;


@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FriendServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		System.out.println(option);
		if(option.equals("view")) {		//if view friends is selected
			FriendDaoInterface ud = DaoFactory.createFriend();
			
			HttpSession session = request.getSession(true);
			int id=(int) session.getAttribute("id");
			User u = new User();
			u.setId(id);
			System.out.println("user id a ");
			List<User> list=ud.viewFriendsDao(u);
			
			if(list!=null && list.size()>0) {
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
		else if(option.equals("remove")){		//if unFriend option is selected
			HttpSession session = request.getSession(true);
			int id=(int) session.getAttribute("id");
	
			FriendDaoInterface ud = DaoFactory.createFriend();
			int friend_id = Integer.parseInt(request.getParameter("friend_id"));
			Friend f = new Friend();
			f.setFriend_id(friend_id);
			f.setUser_id(id);
			    
			System.out.println(f.getUser_id() + " "+ f.getFriend_id());
			int res=ud.removeFriend(f);
			
			if(res==1) {
				request.setAttribute("message","Friend Removed");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/FriendServlet?option=view");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("message","Was unable to Remove Friend. Please try again.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/FriendServlet?option=view");
				rd.forward(request, response);
			}
		}
		else if(option.equals("block")){	//if block user is selected
			HttpSession session = request.getSession(true);
			int id=(int) session.getAttribute("id");
			
			System.out.println("user id a ");
			FriendDaoInterface ud = DaoFactory.createFriend();
			HashMap<Integer, String> hp = ud.viewBlocked(id);
			
			if(hp.size() == 0) {
				request.setAttribute("message","No friends to show.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/BlockedList.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("info",hp);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/BlockedList.jsp");
				rd.forward(request, response);
			}
			
			
			
		}
		else if(option.equals("blocked")){		//if blocked user is selected
			HttpSession session = request.getSession(true);
			int user_id=(int) session.getAttribute("id");
			int blocked_id = Integer.parseInt(request.getParameter("blocked_id"));
			
			System.out.println("user id a " + user_id);
			System.out.println("blocked id a " + blocked_id);
			FriendDaoInterface ud = DaoFactory.createFriend();
			int res = ud.confirmBlocked(user_id, blocked_id);
			
			if(res==1) {
				request.setAttribute("message","Friend Removed");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/FriendServlet?option=block");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("message","Was unable to Remove Friend. Please try again.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/FriendServlet?option=block");
				rd.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}