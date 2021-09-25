<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Disabled List</title>
</head>
<body>
		<% 
			HashMap <Integer , String> hp = (HashMap <Integer , String>)request.getAttribute("info");
			String message = (String)request.getAttribute("message");
			if(hp.size() != 0){
				%>
				<center>
				<table border="5px">
		<%			for(HashMap.Entry<Integer, String> entry : hp.entrySet()) {
					Integer id = entry.getKey();
					out.println("Id1 : " + id);
					String location = entry.getValue();
		%>
					<c:url var="accept" value="AdminDisabledFunctionality">
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
</body>
</html>