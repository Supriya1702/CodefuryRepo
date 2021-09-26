<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Blocked List</title>
<link href="css/background.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<c:url var="logout" value="Logout.jsp">
	</c:url>
	<div align="right">
	<input type="button" value = "Profile"/>
	<input type="button" value = "Logout" onclick="window.location.href='${logout}'"/>
	</div>

		<% 
			HashMap <Integer , String> hp = (HashMap <Integer , String>)request.getAttribute("info");
			String message = (String)request.getAttribute("message");
			if(hp != null){
				%>
				<center>
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
</body>
</html>