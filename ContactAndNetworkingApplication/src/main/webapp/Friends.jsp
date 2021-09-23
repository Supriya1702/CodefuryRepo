<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@page import="com.contactandnetworkingapplication.model.Friend"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Friends</title>
</head>
<body>
	<h1> Friends</h1>
	
	<% 
		List<Friend> list = (List<Friend>)request.getAttribute("list");
		String message = (String)request.getAttribute("message");
		if(list!=null) {%>
			<center>
			<table border="5px">
	<%			for(Friend u : list) {
	%>
				<c:url var="accept" value="FriendServlet">
  						<c:param name="option" value="remove"></c:param>
  						<c:param name="id" value="<%=Integer.toString(u.getFriend_pk()) %>"></c:param>
  						<c:param name="friend_id" value="<%=Integer.toString(u.getFriend_id()) %>"></c:param>
				</c:url>
				<tr><td></td>
					<td><input type="button" onclick="window.location.href='${remove}'" value="Remove"><td/>
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