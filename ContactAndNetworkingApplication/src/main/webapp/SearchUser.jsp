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

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/background.css">
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css"> 
<link rel="stylesheet" type="text/css" href="css/footerstyles.css"> 
<script src="js/searchUser.js"></script>

<style>
table{ opacity:0.8;}
td, th {
	text-align: center;

    }
</style>

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
	<h1 align ="center" style="color:#0066A2; font-weight:bold;">Search Users</h1>
	<form action="SearchServlet" method="post" style="margin-left:37%;margin-bottom:10px;">

	    <select name="select" id="select"  style="width:20%;height:30px;" >
		    <option value="city">City</option>
		    <option value="state">State</option>
		    <option value="company">Company</option>
	    </select>
	    <input type="text" name="search" style="width:20%;height:30px;" >
	 	<input class="btn btn-primary" type="submit" value="Search" >
	</form>
	<center>
	
	<%
		
		List<User> list = (List<User>)request.getAttribute("list");
		if(list!=null && list.size()>0) {
	%>
	<table class="table table-dark table-bordered table-hover" style="width: 80%; margin: auto;">
		<tr>
	    	<th>Name</th>
	    	<th>Send Friend Request</th>
	    	<th>Block User</th>
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
				<input class="btn btn-primary" type="button" onclick="window.location.href='${send}'" value="Send Friend Request">
			</td>
			<td>
				<input class="btn btn-primary" type="button" onclick="window.location.href='${block}'" value="Block User">
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


	   <div class=" text-right fixed-bottom" style="background-color:#0066A2;height:30px; color:white;padding-right:20px;" >
             <small>&copy; 2021 CodeFury App Monsters</small>
           </div>

</body>
</html>