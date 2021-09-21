<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
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
	
	<% 
		List<FriendRequest> list =(List<FriendRequest>)request.getAttribute("list");
		String message = (String)request.getAttribute("message");
		if(list.size() >0) {%>
			<table border=5>
	<%			for(FriendRequest u : list) {
	%>
				<c:url var="accept" value="FriendRequestsServlet">
  						<c:param name="option" value="accept"></c:param>
  						<c:param name="id" value="<%=Integer.toString(u.getFriend_request_pk()) %>"></c:param>
  						<c:param name="sender_id" value="<%=Integer.toString(u.getSender_id()) %>"></c:param>
  						<c:param name="receiver_id" value="<%=Integer.toString(u.getReceiver_id()) %>"></c:param>
				</c:url>
			
				<tr><td><%=u.getSender_name() %></td><td><input type="button" onclick="window.location.href='${accept}'">Accept<td/></tr>
	<% 		} %>
			</table>
	<%
		}
		else {
		
	%>
		<h4><%=message  %></h4>
	<% }%>
</body>
</html>