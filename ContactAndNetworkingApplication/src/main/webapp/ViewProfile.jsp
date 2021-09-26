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
	<h1>Profile</h1>
	<center>
	<div>
		<table>
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
					<%=p.getDob() %>
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
	<footer id="footer">
	  <small id="footer-text">&copy; CodeFury App Monsters</small>
	</footer>
</body>
</html>