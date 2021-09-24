<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link href="AdminLoginCss.css" rel="stylesheet" type="text/css" /> -->
<title>Admin Page</title>
</head>
<body>
	<h2> The Details are : <br>
	<% 
	out.println(request.getAttribute("name"));
	out.println(request.getAttribute("email"));
	out.println(request.getAttribute("phone"));
	%>
	 </h2>
	 <h2>
	 	The Count of Active users are :
	 </h2>
	 <%
	 out.println(request.getAttribute("count"));
	  %>
	  <br>
	  <br>
	  <a href = "AdminServlet?option=disabled"> View can be disabled users</a>
	<!--   <h2>
	 	<a href="/AdminServlet?option=disabled"> View Statistics </a>
	 </h2>
	  <h2>
	 	<a href="/AdminServlet?option=deleted"> View Statistics </a>
	 </h2> -->
	 
</body>
</html>