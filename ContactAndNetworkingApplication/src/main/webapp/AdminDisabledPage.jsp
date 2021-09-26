<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Disabled List</title>
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css">
<link rel="stylesheet" type="text/css" href="css/footerstyles.css">
<link href="css/background.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<ul>
	  <li><a class="active" href="AdminLoginServlet">Home</a></li>
	  <li style="float:right"><a href="AdminLogout.jsp">Logout</a></li>
	</ul>
		<% 
			HashMap <Integer , String> hp = (HashMap <Integer , String>)request.getAttribute("info");
			String message = (String)request.getAttribute("message");
			if(hp != null){
				%>
				<center>
				<table border="5px">
		<%			for(HashMap.Entry<Integer, String> entry : hp.entrySet()) {
					Integer id = entry.getKey();
					String location = entry.getValue();
		%>
					<c:url var="accept" value="AdminServlet">
	  						<c:param name="option" value="accept"></c:param>
	  						<c:param name="id" value= "<%= id.toString() %>"></c:param>
					</c:url>
					<tr><td><%=id%></td><td><%=location %></td>
					<td><input type="button" onclick="window.location.href='${accept}'" value="Disable"></td>
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
	<footer id="footer">
	  <small id="footer-text">&copy; CodeFury App Monsters</small>
	</footer>
</body>
</html>