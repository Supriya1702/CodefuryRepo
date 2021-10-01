<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link href="AdminLoginCss.css" rel="stylesheet" type="text/css" /> -->
<link href="css/background.css" rel="stylesheet" type="text/css" />
<title>Admin Page</title>
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css"> 
<link rel="stylesheet" type="text/css" href="css/footerstyles.css"> 

</head>

<body>
	<ul>
	  <li><a class="active" href="AdminLoginServlet">Home</a></li>
	  <li style="float:right"><a href="AdminLogout.jsp">Logout</a></li>
	</ul>
	<center>
	<h2>	Hello <%= request.getAttribute("name")%> : <br>
	
	Your Details : <br>
	Email : <%= request.getAttribute("email") %> <br>
	Phone No : <%= request.getAttribute("phone") %> <br>
	 </h2>
	 <h2>
	 	The Count of Active users are : <%= request.getAttribute("count") %>
	 </h2>
	  <br>
	  <br>
	  <form action="AdminServlet?option=disabled" method="post">
	  <br> <br>	<button  type="submit" >Disable Users</button>
	 <!--  <a href = "AdminServlet?option=disabled"> Users to be Disabled </a> -->
	  </center>
	 <footer id="footer">
	  <small id="footer-text">&copy; CodeFury App Monsters</small>
	</footer>
</body>
</html>