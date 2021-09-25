package com.Webhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*; 
  
public class ProfileServlet extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
	
String a=request.getParameter("ac");	
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
if(a.equals("view"))
{
String username=request.getParameter("username");
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://85.10.205.173:3306/codefury_contact","app_monsters","student1234");  
              
PreparedStatement ps=con.prepareStatement("select * from user where username=?");  
ps.setString(1,username);  
              
out.print("<table width=50% border=1>");  
out.print("<caption>Profile:</caption>");  
  
ResultSet rs=ps.executeQuery();  
ResultSetMetaData rsmd=rs.getMetaData();  

  out.print("<tr>"); 
  for(int i=1;i<=11;i++) {
  out.print("<th>"+rsmd.getColumnName(i)+"</th>"); }
  
  out.print("</tr>");
  
while(rs.next())  
{  
out.print("<tr><td>"+rs.getInt(1)+ "</td><td>"+rs.getString(2)+ "</td><td>"+rs.getString(3)+"</td><td>"+rs.getLong(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getDate(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td>"+"Password:"+rs.getString(14)+ "</td></tr>");  
                  
}  
  
out.print("</table>");          
} 
catch(Exception e)
{
    out.println(e);
}

finally
{
	out.close();
}
}  
}  
}
