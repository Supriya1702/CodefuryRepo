<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@page import="com.contactandnetworkingapplication.model.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Main page</title>
<link href="css/background.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css"> 
<link rel="stylesheet" type="text/css" href="css/footerstyles.css"> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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
		User res = (User)request.getAttribute("User");
	%>
	<div>
		<h1>Welcome <%= res.getName() %></h1><br>
		<%
			Date date1 = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String s = formatter.format(date1);
			String current_date = formatter.format(res.getDob());
			if(s.equals(current_date)) {
				
		%>
				<h1>Wish you a very Happy Birthday <%= res.getName() %></h1>
		<%  } %>
	<br/>
	</div>
	<br/><br/><br/><br/>
	<table style="margin-left:20%;">
	<tr>
	<div class="cards" >
		<td>
		<div class="card">
			<img src="https://cdn0.iconfinder.com/data/icons/business-dual-color-glyph-set-2/128/Address_book-512.png" style="width:20%;height:20%" class="card_image">
			<div class="content">
				<a href="ContactDetailsJsp.jsp">View Contacts</a>
			</div>
		</div>
		</td>
		
		<td>
		<div class="card">
			<img src="https://cdn2.iconfinder.com/data/icons/bussiness-management-supersolid/24/add_add_contact_create_new_person_user_add_friend-512.png" style="width:25%;height:10%" class="card_image">
			<div class="content">
				<a href="AddContactJsp.jsp">Add New Contact</a>
			</div>
		</div>
		</td>
		
		<td>
		<div class="card">
			<img src="https://library.kissclipart.com/20180829/ike/kissclipart-search-user-icon-clipart-computer-icons-user-761033d83b6b74f8.png" style="width:20%;height:10%" class="card_image">
			<div class="content">
				<a href="SearchUser.jsp">Search Users</a>
			</div>
		</div>
		</td>
	</tr>
	
	<tr>
		
		<td>
		<div class="card">
			<img src="https://icon-library.com/images/connect-icon-png/connect-icon-png-18.jpg" style="width:20%;height:20%" class="card_image">
			<div class="content">
				<a href="FriendServlet?option=view">View Friends</a>
			</div>
		</div>
		</td>
		
		<td>
		<div class="card">
			<img src="https://static.thenounproject.com/png/2714894-200.png" style="width:20%;height:20%" class="card_image">
			<div class="content">
				<a href="FriendRequestsServlet?option=view">View Friend Requests</a>
			</div>
		</div>
		</td>
		
		<td>
		<div class="card">
			<img src="https://cdn.iconscout.com/icon/premium/png-512-thumb/block-person-1446662-1222337.png" style="width:20% ;height:20%" class="card_image">
			<div class="content">
				<a href="FriendServlet?option=block">Blocked Users</a>
			</div>
		</div>
		</td>
		
	</tr>

	</div>
	
	</table>
	  <div class=" text-right fixed-bottom" style="background-color:#0066A2;height:30px; color:white;padding-right:20px;" >
             <small>&copy; 2021 CodeFury App Monsters</small> 
      </div> 
</body>
</html>
