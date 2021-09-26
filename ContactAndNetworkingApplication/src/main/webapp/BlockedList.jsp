<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Blocked List</title>
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css"> 
<link rel="stylesheet" type="text/css" href="css/footerstyles.css"> 
<link href="css/background.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
	if(session.getAttribute("id") == null)
	{
		response.sendRedirect("Login.jsp");
		return ;
	}
	
	%>
	<ul>
	  <li><a class="active" href="LoginServlet">Home</a></li>
	  <li style="float:right"><a href="Logout.jsp">Logout</a></li>
	  <li style="float:right"><a href="ViewProfile.jsp">Profile</a></li>
	</ul>
		<% 
			HashMap <Integer , String> hp = (HashMap <Integer , String>)request.getAttribute("info");
			String message = (String)request.getAttribute("message");
			if(hp != null){
				%>
				<center>
				<h1>Blocked Users</h1>
				<table border="5px">
		<%			for(HashMap.Entry<Integer, String> entry : hp.entrySet()) {
					Integer id = entry.getKey();
					String Name = entry.getValue();
		%>
					<c:url var="accept" value="FriendServlet">
	  						<c:param name="option" value="blocked"></c:param>
	  						<c:param name="blocked_id" value= "<%= id.toString() %>"></c:param>
					</c:url>
					<tr></td><td><%=Name %></td>
					<td><input type="button" onclick="window.location.href='${accept}'" value="Unblock"></td>
				</tr>
	<% 		} %>
			</table>
			</center>
	<%
				}
				else {
		 	
		%>
		<h4><%= message  %></h4>
	<% }
	%>
	<footer id="footer">
	  <small id="footer-text">&copy; CodeFury App Monsters</small>
	</footer>
</body>
</html>