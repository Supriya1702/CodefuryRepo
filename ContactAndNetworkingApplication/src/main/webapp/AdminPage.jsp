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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
	  </form>
	  <a style="padding:10px; color:green;" href="AdminDeletePage.jsp" >Inactive Users</a>
	 <!--  <a href = "AdminServlet?option=disabled"> Users to be Disabled </a> -->
	  </center>
	   <div class=" text-right fixed-bottom" style="background-color:#0066A2;height:30px; color:white;padding-right:20px;" >
             <small>&copy; 2021 CodeFury App Monsters</small>
           </div>
           

</body>
</html>