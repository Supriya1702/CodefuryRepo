<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.contactandnetworkingapplication.dao.ContactDAOImpl"%>
<%@page import="com.contactandnetworkingapplication.model.Contacts"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="com.contactandnetworkingapplication.controller.AddContact"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Details</title>
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
<link href="css/background.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css">
<link rel="stylesheet" type="text/css" href="css/footerstyles.css">

<style>
table {
	opacity: 0.85;
}

td,th {
	text-align: center;
	color: white;
}

.aligned {
	margin-left: 37%;
	display: flex;
	align-items: center;
}

h1 {
	padding: 10px;
}

td,th {
	text-align: center;
}

th {
	color: #0066A2;
	font-weight: bold;
	font-size: 20px;
}
	</style>

</head>

<body>


	<%
		if (session.getAttribute("id") == null) {
			response.sendRedirect("Login.jsp");
			return;
		}
	%>
	<ul>
		<li><a class="active" href="LoginServlet">Home</a></li>
		<li style="float: right"><a href="Logout.jsp">Logout</a></li>
		<li style="float: right"><a href="ViewProfile.jsp">Profile</a></li>
	</ul>
	<jsp:useBean id="contact"
		class="com.contactandnetworkingapplication.model.Contacts" />
	<%
		int id = (int) session.getAttribute("id");

		ContactDAOImpl contactdaoImpl = new ContactDAOImpl();
		List<Contacts> contactList = new ArrayList<>();
		contactList = contactdaoImpl.getContacts(id);
	%>

	<c:url var="delContacts" value="AddContact">
		<c:param name="option" value="delete"></c:param>
		<c:param name="listContact2"></c:param>
	</c:url>
 <div  class="aligned" align="center" ><img src="images/contact_list_2.jfif" style="width:100px;"><h1 style="color:#0066A2; font-weight:bold;">My Contacts List</h1></div>
	
	<div class="allContacts">




		<table class="table table-dark table-bordered table-hover" style="width: 80%; margin: auto;">
			<tr>

				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Select</th>
				<th scope="col">View</th>
			</tr>

			<%
				for (Contacts c : contactList) {
					String butId = "buttonId" + c.getContact_id();
			%>
			<tr>
				<td><%=c.getFullName()%></td>
				<td><%=c.getEmail()%></td>
				<td><input type="checkbox" id="chbox" class="selectedContact" onclick="deleteContact()" value=<%=c.getContact_id()%>></td>
				<td><button class="btn btn-primary" id="<%=butId%>"	onclick="showDetails(<%=c.getContact_id()%>)">View Details</button></td>
			</tr>

			<tr  style="display:none" id=<%= c.getContact_id() %>>

			<td colspan="4">

 	       <ul style = "Background:White; class="list-group">
 	        <li  class = "listItem list-group-item list-group-item-action list-group-item-dark"><B><u>DETAILS</u> </B></li>
			<li class = "listItem list-group-item list-group-item-action list-group-item-dark"><B>Phone No : </B><%= (c.getPhone_no().equals("")) ? "Not Available" :  c.getPhone_no() %></li>
	  		<li class = "listItem list-group-item list-group-item-action list-group-item-dark"><B>Gender : </B><%= (c.getGender().equals("")) ? "Not Available" :c.getGender() %></li>
	  		<li class = "listItem list-group-item list-group-item-action list-group-item-dark"><B>Date Of Birth : </B><%= (c.getDateOfBirth()==null) ? "Not Available" :c.getDateOfBirth()%></li>
	  		<li class = "listItem list-group-item list-group-item-action list-group-item-dark"><B>Address : </B><%= (c.getAddress().equals("")) ? "Not Available" :c.getAddress()%></li>
	  		<li class = "listItem list-group-item list-group-item-action list-group-item-dark"><B>City : </B><%= (c.getCity().equals("")) ? "Not Available" :c.getCity()%></li>
	  		<li class = "listItem list-group-item list-group-item-action list-group-item-dark"><B>State : </B><%= (c.getState().equals("")) ? "Not Available" :c.getState()%></li>
	  		<li class = "listItem list-group-item list-group-item-action list-group-item-dark"><B>Country : </B><%= (c.getCountry().equals("")) ? "Not Available" :c.getCountry()%></li>
	  		<li class = "listItem list-group-item list-group-item-action list-group-item-dark"><B>Company : </B><%= (c.getCompany().equals("")) ? "Not Available" :c.getCompany()%></li>
	  		</ul>

	  		</td>

	  	</tr>
			<%
				}
			%>


			</table>

	     <div style="margin-left:43%;margin-top:10px;margin-bottom:40px;">
	     <form action="DeleteContact" method="post" style="float:left;">
			<input type="text" style="display: none" name="labelcon" id="labelcon" value="0">
			<button class="btn btn-primary" type="submit">Delete Selected</button></form>&nbsp;&nbsp;
			<button class="btn btn-primary" type="button" onclick="uncheckAll()">Uncheck Selected</button>

			</div>
			</div>



	     <div class=" text-right fixed-bottom" style="background-color:#0066A2;height:30px; color:white;padding-right:20px;" >
             <small>&copy; 2021 CodeFury App Monsters</small>
           </div>


		<jsp:setProperty property="*" name="contact" />


<script> function showDetails(contact_id){
	console.log("in showDetails");
	if(document.getElementById(contact_id).style.display=="none"){
		document.getElementById(contact_id).style.display="block";
		document.getElementById("buttonId"+contact_id).innerText="Hide Details";
	}
	else if(document.getElementById(contact_id).style.display=="block"){
		document.getElementById(contact_id).style.display="none";
		document.getElementById("buttonId"+contact_id).innerText="View Details";
	}
}


 function deleteContact(){
	var list = document.getElementsByClassName("selectedContact");
	var deleteContacts = [];
	var delCon = "";
	for (var i =0; i<list.length; i++){
		if(list[i].checked==true){
			delCon = delCon + list[i].value + "," ;
			deleteContacts.push(list[i].value)
			console.log(list[i].value)
		}
	}
	if(deleteContacts != null){
		console.log(deleteContacts);
	var lab=document.getElementById("labelcon");
	lab.value = delCon;
	return true;
	}
	else{return false;}
	console.log(delCon);
	
 }


 function uncheckAll(){
     console.log("inside");
	 $('.selectedContact').prop('checked', false);

	 }
</script>
</body>
</html>
