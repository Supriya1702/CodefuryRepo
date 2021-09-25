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
</head>
<body>
	<h1> Pending Friend Requests</h1>
	<c:url var="logout" value="Logout.jsp">
	</c:url>
	<div align="right">
	<input type="button" value = "Profile"/>
	<input type="button" value = "Logout" onclick="window.location.href='${logout}'"/>
	</div>
	
	<% 
		List<FriendRequest> list=(List<FriendRequest>)request.getAttribute("list");
		String message = (String)request.getAttribute("message");
		if(list!=null) {%>
			<center>
			<table border="5px">
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
					<td><input type="button" onclick="window.location.href='${accept}'" value="Accept"><td/>
					<td><input type="button" onclick="window.location.href='${ignore}'" value="Ignore"><td/>
					<td><input type="button" onclick="window.location.href='${block}'" value="Block"><td/>
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