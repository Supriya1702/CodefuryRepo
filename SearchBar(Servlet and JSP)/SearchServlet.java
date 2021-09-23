package com.Webhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
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
		String selectedItem=request.getParameter("select");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<html><body>");
		if(selectedItem.equals("state"))
		{
			String state=request.getParameter("search");  
			try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://85.10.205.173:3306/codefury_contact","app_monsters","student1234");  
		              
		PreparedStatement ps=con.prepareStatement("select fullname from user where state=?");  
		ps.setString(1,state);  
		out.print("<table width=40% border=1>"); 
		out.print("<caption>Result:</caption>");
		ResultSet rs=ps.executeQuery();  
		while(rs.next()) {
				out.print("<tr><td>" + rs.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ "<a href=\"#\"><button type=\"button\">Send Friend Request</button></a>"+" "+"<a href=\"#\"><button type=\"button\">Block User</button></a>"+"</td></tr>");
			} 
		out.print("</table>");
			}
			catch(ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
			finally
			{
				out.close();
			}
			}
		else 
			if(selectedItem.equals("city"))
			{
				String state=request.getParameter("search");  
				try {
				Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://85.10.205.173:3306/codefury_contact","app_monsters","student1234");  
			              
			PreparedStatement ps=con.prepareStatement("select fullname from user where city=?");  
			ps.setString(1,state);  
			out.print("<table width=40% border=1>"); 
			out.print("<caption>Result:</caption>");
			ResultSet rs=ps.executeQuery();  
			while(rs.next()) {
					out.print("<tr><td>" + rs.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ "<a href=\"#\"><button type=\"button\">Send Friend Request</button></a>"+" "+"<a href=\"#\"><button type=\"button\">Block User</button></a>"+"</td></tr>");
				} 
			out.print("</table>");
				}
				catch(ClassNotFoundException|SQLException e) {
					e.printStackTrace();
				}
				finally
				{
					out.close();
				}
				}
			else
				if(selectedItem.equals("company"))
				{
					String state=request.getParameter("search");  
					try {
					Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://85.10.205.173:3306/codefury_contact","app_monsters","student1234");  
				              
				PreparedStatement ps=con.prepareStatement("select fullname from user where company=?");  
				ps.setString(1,state);  
				out.print("<table width=40% border=1>"); 
				out.print("<caption>Result:</caption>");
				ResultSet rs=ps.executeQuery();  
				while(rs.next()) {
						out.print("<tr><td>" + rs.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ "<a href=\"#\"><button type=\"button\">Send Friend Request</button></a>"+" "+"<a href=\"#\"><button type=\"button\">Block User</button></a>"+"</td></tr>");
					} 
				out.print("</table>");
					}
					catch(ClassNotFoundException|SQLException e) {
						e.printStackTrace();
					}
					finally
					{
						out.close();
					}
					}
		out.print("</body><html>");
		}
	}

