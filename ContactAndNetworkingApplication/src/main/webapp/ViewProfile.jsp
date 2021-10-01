<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.contactandnetworkingapplication.model.User"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
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
	
    }
   


	</style>
	
</head>
<body>
	<%
	if(session.getAttribute("id") == null)
	{
		response.sendRedirect("Login.jsp");
		return ;
	}
	
	%>
	<ul>
	  <li><a class="active" href="LoginServlet">Home</a></li>
	  <li style="float:right"><a href="Logout.jsp">Logout</a></li>
	  <li style="float:right"><a href=#>Profile</a></li>
	</ul>
	<%
		User p = (User) session.getAttribute("user");		
	%>
	 <div  class="aligned" align="center" ><img src="images/profile_img.png" style="width:70px;"><h1 style="color:#0066A2; font-weight:bold;">Profile</h1></div>
	<center>
	<div>
		<table class="table table-dark table-bordered table-hover" style="width: 60%; margin: auto; opacity:0.8;">
			<tr>
				<td>Full Name</td>
				<td>
					<%
						if(p.getName()!=null) {
					%>
					<%=p.getName() %>
					<% }
						else {
					%>
					Not Available
					<% } %>
				</td>
			</tr>
			<tr>
				<td>Email </td>
				<td>
					<%
						if(p.getEmail()!=null) {
					%>
					<%=p.getEmail() %>
					<% }
						else {
					%>
					Not Available
					<% } %>
				</td>
			</tr>
			<tr>
				<td>Phone Number </td>
				<td>
					<%
						if(String.valueOf(p.getPhoneno())!=null) {
					%>
					<%=p.getPhoneno() %>
					<% }
						else {
					%>
					Not Available
					<% } %>
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<%
						if(p.getGender()!=null) {
					%>
					<%=p.getGender() %>
					<% }
						else {
					%>
					Not Available
					<% } %>
				</td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td>
					<%
						if(p.getDob()!=null) {
					%>
					<%=p.getDob() %>
					<% }
						else {
					%>
					Not Available
					<% } %>
				</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
					<%
						if(p.getAddress()!=null) {
					%>
					<%=p.getAddress() %>
					<% }
						else {
					%>
					Not Available
					<% } %>
				</td>
			</tr>
			<tr>
				<td>City</td>
				<td>
					<%
						if(p.getCity()!=null) {
					%>
					<%=p.getCity() %>
					<% }
						else {
					%>
					Not Available
					<% } %>
				</td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<%
						if(p.getState()!=null) {
					%>
					<%=p.getState() %>
					<% }
						else {
					%>
					Not Available
					<% } %>
				</td>
			</tr>
			<tr>
				<td>Company</td>
				<td>
					<%
						if(p.getCompany()!=null) {
					%>
					<%=p.getCompany() %>
					<% }
						else {
					%>
					Not Available
					<% } %>
				</td>
			</tr>
			<tr>
				<td>Username</td>
				<td>
					<%
						if(p.getUsername()!=null) {
					%>
					<%=p.getUsername() %>
					<% }
						else {
					%>
					Not Available
					<% } %>
				</td>
			</tr>
		</table>
	</div>
	</center>
	<div id="footer" class="fixed-bottom">
	  <small id="footer-text">&copy; 2021 CodeFury App Monsters</small>
	</div>
</body>
</html>