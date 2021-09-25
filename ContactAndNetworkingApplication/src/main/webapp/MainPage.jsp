<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@page import="com.contactandnetworkingapplication.model.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!--
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome </h1>
	<a href="FriendRequestsServlet?option=view"> View FriendRequests </a>
	<a href=""> View Friends </a>
</body>
</html>
-->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Main page</title>
</head>
<body>
	<%
		User res = (User)request.getAttribute("User");
		
	%>
	<c:url var="logout" value="Logout.jsp">
	</c:url>
	<div align="right">
	<input type="button" value = "Profile"/>
	<input type="button" value = "Logout" onclick="window.location.href='${logout}'"/>
	</div>
	<div>
		<h1>Welcome <%= res.getName() %></h1><br>
		<%
			System.out.println(res.getDob());
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
	<table>
	<tr>
	<div class="cards">
		<td>
		<div class="card">
			<img src="https://cdn0.iconfinder.com/data/icons/business-dual-color-glyph-set-2/128/Address_book-512.png" style="width:20%","height:20%" class="card_image">
			<div class="content">
				<a href="#">View Contacts</a>
			</div>
		</div>
		</td>
		
		<td>
		<div class="card">
			<img src="https://cdn2.iconfinder.com/data/icons/bussiness-management-supersolid/24/add_add_contact_create_new_person_user_add_friend-512.png" style="width:25%","height:10%" class="card_image">
			<div class="content">
				<a href="#">Add New Contact</a>
			</div>
		</div>
		</td>
		
		<td>
		<div class="card">
			<img src="https://library.kissclipart.com/20180829/ike/kissclipart-search-user-icon-clipart-computer-icons-user-761033d83b6b74f8.png" style="width:20%","height:10%" class="card_image">
			<div class="content">
				<a href="#">Search Users</a>
			</div>
		</div>
		</td>
	</tr>
	
	<tr>
		
		<td>
		<div class="card">
			<img src="https://icon-library.com/images/connect-icon-png/connect-icon-png-18.jpg" style="width:20%","height:20%" class="card_image">
			<div class="content">
				<a href="FriendServlet?option=view">View Friends</a>
			</div>
		</div>
		</td>
		
		<td>
		<div class="card">
			<img src="https://static.thenounproject.com/png/2714894-200.png" style="width:20%","height:20%" class="card_image">
			<div class="content">
				<a href="FriendRequestsServlet?option=view">View Friend Requests</a>
			</div>
		</div>
		</td>
		
		<td>
		<div class="card">
			<img src="https://cdn.iconscout.com/icon/premium/png-512-thumb/block-person-1446662-1222337.png" style="width:20%","height:20%" class="card_image">
			<div class="content">
				<a href="#">Blocked Users</a>
			</div>
		</div>
		</td>
		
	</tr>

	</div>
	
	</table>

</body>
</html>