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
	.aligned { margin-left: 43%;
            display: flex;
            align-items: center;
        }
           
        h1 {
            padding: 10px;
        }
        
           td, th {
	text-align: center;
	</style>
	

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
				
				<div  class="aligned" align="center" ><img src="images/disabled_users.png" style="width:70px;"><h1 style="color:#0066A2; font-weight:bold;">Disabled Users</h1></div>
				
				<center>
				<table class="table table-dark table-bordered table-hover" style="width: 80%; margin: auto; opacity:0.8;">
	

	
		<%			for(HashMap.Entry<Integer, String> entry : hp.entrySet()) {
					Integer id = entry.getKey();
					String location = entry.getValue();
		%>
					<c:url var="accept" value="AdminServlet">
	  						<c:param name="option" value="accept"></c:param>
	  						<c:param name="id" value= "<%= id.toString() %>"></c:param>
					</c:url>
					<tr><td><%=id%></td><td><%=location %></td>
					<td><input type="button" class="btn btn-primary" onclick="window.location.href='${accept}'" value="Disable"></td>
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