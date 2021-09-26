<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.contactandnetworkingapplication.model.User"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Users</title>
<link rel="stylesheet" type="text/css" href="css/background.css">
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css"> 
<link rel="stylesheet" type="text/css" href="css/footerstyles.css"> 
<script src="js/searchUser.js"></script>
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
	<h1>Search Users</h1>
	<form action="SearchServlet" method="post">  
	    <input type="text" name="search"> 
	    <select name="select" id="select">
		    <option value="city">City</option>
		    <option value="state">State</option>
		    <option value="company">Company</option>
	    </select>
	 	<input type="submit" value=Submit >
	</form>
	<center>
	
	<%
		
		List<User> list = (List<User>)request.getAttribute("list");
		if(list!=null && list.size()>0) {
	%>
	<table >
		<tr>
	    	<th>Name</th>
	  	</tr>
	<%	
			for(User u:list) {
	%>
		
		<c:url var="send" value="SendFriendRequestServlet">
  			<c:param name="receiver_id" value="<%=Integer.toString(u.getId()) %>"></c:param>
		</c:url>
		<c:url var="block" value="BlockUserServlet">
  			<c:param name="blocked_id" value="<%=Integer.toString(u.getId()) %>"></c:param>
		</c:url>
		
		<tr>
			<td><%=u.getName() %></td>
			<td>
				<input type="button" onclick="window.location.href='${send}'" value="Send Friend Request">	
			</td>
			<td>
				<input type="button" onclick="window.location.href='${block}'" value="Block User">
			</td>
		</tr>
	
	<%
			} %>
	</table>		
	<% 	}
		else {
			System.out.println("asbsds");
			String message = (String)request.getAttribute("message");
			if(message==null) 
				message="please enter search criteria above.";
			System.out.println(message);
	%>
	<h4><%=message %></h4>
	<% } %>
	
	</center> 
	<footer id="footer">
	  <small id="footer-text">&copy; CodeFury App Monsters</small>
	</footer>
</body>
</html>