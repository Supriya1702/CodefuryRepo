<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@page import="com.contactandnetworkingapplication.model.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Friends</title>
</head>
<body>
	<h1> Friends list</h1>
	
	<c:url var="logout" value="Logout.jsp">
	</c:url>
	<div align="right">
	<input type="button" value = "Profile"/>
	<input type="button" value = "Logout" onclick="window.location.href='${logout}'"/>
	</div>
	
	<% 
		List<User> list = (List<User>)request.getAttribute("list");
		String message = (String)request.getAttribute("message");
		if(list!=null) {%>
			<center>
			<table border="5px">
	<%			for(User u : list) {
	%>
				<c:url var="remove" value="FriendServlet">
  						<c:param name="option" value="remove"></c:param>
  						<c:param name="friend_id" value="<%=Integer.toString(u.getId()) %>"></c:param>
				</c:url>
				<tr><td><%= u.getName() %></td>
					<td><input type="button" onclick="window.location.href='${remove}'" value="Unfriend"><td/>
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
</body>
</html>