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
</head>


<body>
<c:url var="logout" value="AdminLogout.jsp">
</c:url>
<input type="button" value = "Logout" onclick="window.location.href='${logout}'"/>
	<h2>	Hello <%= request.getAttribute("name")%>  <br>
	
	Your Details : <br>
	Email : <%= request.getAttribute("email") %> <br>
	Phone No : <%= request.getAttribute("phone") %> <br>
	 </h2>
	 <h2>
	 	The Count of Active users are : <%= request.getAttribute("count") %>
	 </h2>
	<%--  <%
	 out.println(request.getAttribute("count"));
	  %> --%>
	  <br>
	  <br>
	  <a href = "AdminServlet?option=disabled"> Users to disable </a>
	<!--   <h2>
	 	<a href="/AdminServlet?option=disabled"> View Statistics </a>
	 </h2>
	  <h2>
	 	<a href="/AdminServlet?option=deleted"> View Statistics </a>
	 </h2> -->
	 
</body>
</html>