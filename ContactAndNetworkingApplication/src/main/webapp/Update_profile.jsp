<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.contactandnetworkingapplication.model.User" %>
<%@ page session="false" language="java" import="java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<title>Update Profile</title>
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css"> 
<link rel="stylesheet" type="text/css" href="css/footerstyles.css">
<link rel="stylesheet" type="text/css" href="css/registrationStyles.css">  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="css/background.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css"> 
<link rel="stylesheet" type="text/css" href="css/footerstyles.css"> 
</head>
<body>
<%
		//User p = new User();	
	HttpSession session = request.getSession();
	User p = (User) session.getAttribute("user");
	%>
	<ul>
	  <li><a class="active" href="LoginServlet">Home</a></li>
	  <li style="float:right"><a href="Logout.jsp">Logout</a></li>
	  <li style="float:right"><a href="ViewProfile.jsp">Profile</a></li>
	</ul>
	<center>
           <h3>Update Profile</h3>
           <form action="UpdateServlet" method="post">
           <table>
			<tr>
				<input type="hidden" value="<%=p.getEmail() %>" name="user-email">
				<input type="hidden" value="<%=p.getUsername() %>" name="user-username">
				<input type="hidden" value="<%=p.getPassword() %>" name="user-password">				
				<td>Full Name</td>
				<td>
				<input type="text" id="fname" value="<%=p.getName() %>" name="user-name">
				</td>
			</tr>
			<tr>
				<td>Phone Number </td>
				<td>
					<input type="text" id="fname" value="<%=p.getPhoneno() %>" name="user-phone">
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<input style="background:lightgrey" type="text" id="fname" value="<%=p.getGender() %>" name="user-gender" readonly>
				</td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td>
					<input style="background:lightgrey" type="text" id="fname" value="<%=p.getDob() %>" name="user-dob" readonly>
				</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
					<input type="text" id="fname" value="<%=p.getAddress() %>" name="user-address">
				</td>
			</tr>
			<tr>
				<td>City</td>
				<td>
				<input type="text" id="fname" value="<%=p.getCity() %>" name="user-city">
				</td>
			</tr>
			<tr>
				<td>State</td>
				<td>
				<input type="text" id="fname" value="<%=p.getState() %>" name="user-state">
				</td>
			</tr>
			<tr>
				<td>Country</td>
				<td>
				<input type="text" id="fname" value="<%=p.getCountry() %>" name="user-country">
				</td>
			</tr>
			<tr>
				<td>Company</td>
				<td>
					<input type="text" id="fname" value="<%=p.getCompany() %>" name="user-company">
				</td>
			</tr>
		</table>
			<br>
            <input type="submit"  value="Confirm"></input>
            <c:url var="cancel" value="ViewProfile.jsp">
			</c:url>
			<input type="button" onclick="window.location.href='${cancel}'" value="Cancel">
        </form> 
        
        
        </center>        
    <footer id="footer">
 		<small id="footer-text">&copy; CodeFury App Monsters</small>
	</footer>
<script src="js/registrationValidations.js"></script> 
</body>
</html> 