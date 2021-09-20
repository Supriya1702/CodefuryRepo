package com.Webhtml.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
    
public class EServlet extends HttpServlet  
{    
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
         PrintWriter out = res.getWriter();  
         res.setContentType("text/html");  
         out.println("<html><body>");  
         try 
         {  
             Class.forName("com.mysql.jdbc.Driver");  
             Connection con = DriverManager.getConnection("jdbc:mysql://85.10.205.173:3306/codefury_contact","app_monsters","student1234");
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from user");  
             out.println("<table border=1 width=50% height=50%>"); 
             out.println("All Users");
             out.println("<tr><th>Name</th><th>Email</th><th>Phone No.</th><th>Gender</th><th>DOB</th><th>Adddress</th><th>City</th><th>State</th><th>Country</th><th>Company</th><th>Username</th><th>Password</th><tr>");  
             while (rs.next()) 
             {  
                 String nam = rs.getString("fullname");  
                 String em= rs.getString("email");
                 Long ph = rs.getLong("phone_no"); 
                 String gen = rs.getString("gender"); 
                 Date d = rs.getDate("dob"); 
                 String ad = rs.getString("address"); 
                 String city = rs.getString("city"); 
                 String st = rs.getString("state"); 
                 String cou = rs.getString("country");
                 String com = rs.getString("company"); 
                 String un= rs.getString("username"); 
                 String pass = rs.getString("password");
                 out.println("<tr><td>" +nam+ "</td><td>" +em+ "</td><td>" +ph+ "</td><td>" +gen+ "</td><td>" +d+ "</td><td>" +ad+ "</td><td>" + city +"</td><td>" +st+ "</td><td>" +cou+ "</td><td>" +com+ "</td><td>" +un+ "</td><td>" +pass+ "</td></tr>");   
             }  
             out.println("</table>");
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  
     }  
 }  