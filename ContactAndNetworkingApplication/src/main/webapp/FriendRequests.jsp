<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@page import="com.contactandnetworkingapplication.model.FriendRequest"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending Friend Requests</title>
<link href="css/background.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css"> 
<link rel="stylesheet" type="text/css" href="css/footerstyles.css"> 
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
<style>
table{opacity:0.8;}
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
	<h1 align ="center" style="color:#0066A2; font-weight:bold;"> Pending Friend Requests</h1>
	
	<% 
		List<FriendRequest> list=(List<FriendRequest>)request.getAttribute("list");
		String message = (String)request.getAttribute("message");
		if(list!=null) {%>
			<center>
			<table border="5px" class="table table-dark table-bordered table-hover" style="width: 80%; margin: auto;">
	<%			for(FriendRequest u : list) {
	%>
				<c:url var="accept" value="FriendRequestsServlet">
  						<c:param name="option" value="accept"></c:param>
  						<c:param name="id" value="<%=Integer.toString(u.getFriend_request_pk()) %>"></c:param>
  						<c:param name="sender_id" value="<%=Integer.toString(u.getSender_id()) %>"></c:param>
  						<c:param name="receiver_id" value="<%=Integer.toString(u.getReceiver_id()) %>"></c:param>
				</c:url>
				<c:url var="ignore" value="FriendRequestsServlet">
  						<c:param name="option" value="ignore"></c:param>
  						<c:param name="id" value="<%=Integer.toString(u.getFriend_request_pk()) %>"></c:param>
				</c:url>
				<c:url var="block" value="FriendRequestsServlet">
  						<c:param name="option" value="block"></c:param>
  						<c:param name="id" value="<%=Integer.toString(u.getFriend_request_pk()) %>"></c:param>
  						<c:param name="sender_id" value="<%=Integer.toString(u.getSender_id()) %>"></c:param>
  						<c:param name="receiver_id" value="<%=Integer.toString(u.getReceiver_id()) %>"></c:param>
				</c:url>
				<tr><td><%=u.getSender_name() %></td>
					<td><input  class="btn btn-primary" type="button" onclick="window.location.href='${accept}'" value="Accept"><td/>
					<td><input  class="btn btn-primary" type="button" onclick="window.location.href='${ignore}'" value="Ignore"><td/>
					<td><input  class="btn btn-primary" type="button" onclick="window.location.href='${block}'" value="Block"><td/>
				</tr>
	<% 		} %>
			</table>
			</center>
	<%
		}
		else {
		
	%>
		<h4><%=message  %></h4>
	<% }%>
	<footer id="footer">
	  <small id="footer-text">&copy; CodeFury App Monsters</small>
	</footer>
</body>
</html>