<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.contactandnetworkingapplication.dao.ContactDAOImpl" %>
<%@page import="com.contactandnetworkingapplication.model.Contacts" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.contactandnetworkingapplication.controller.AddContact"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Details</title>
<link href="css/background.css" rel="stylesheet" type="text/css" />
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
	  <li style="float:right"><a href="ViewProfile.jsp">Profile</a></li>
	</ul>
 <jsp:useBean id="contact" class="com.contactandnetworkingapplication.model.Contacts" />
  <%
	int id=(int) session.getAttribute("id");
	
  	ContactDAOImpl contactdaoImpl = new ContactDAOImpl();
    List<Contacts> contactList = new ArrayList<>();
    contactList= contactdaoImpl.getContacts(id);
  %>
  
  <c:url var="delContacts" value="AddContact">
  <c:param name="option" value="delete"></c:param>
  <c:param name="listContact2" ></c:param>
  </c:url>
	
<div class="allContacts">
  <H3>My Contact List</h3>
  
  <table>
  <tr>
  		
  		<th>Name</th>
  		<th>Email</th>
  		<th>Select</th>
  	</tr>
  	
  <%
  for (Contacts c :contactList){
	 String butId="buttonId"+c.getContact_id();
	  %>
	  <tr>
	  		<td><%= c.getFullName()%></td>
	  		<td><%= c.getEmail()%></td>
	  		<td><input type="checkbox" id ="chbox" class ="selectedContact" onclick="deleteContact()" value=<%=  c.getContact_id() %>></td>
	  		<td><button id="<%= butId %>" onclick="showDetails(<%= c.getContact_id() %>)">View Details</button></td>
	  	</tr>	
	  	<tr  colspan=4 style="display:none" id=<%= c.getContact_id() %>>
	  		<td></td>
			<td >
			<ul style = "Background:White;">
			<li class = "listItem"><B>Phone No: </B><%= (c.getPhone_no().equals("")) ? "Not Available" :  c.getPhone_no() %></li> </br>
	  		<li class = "listItem"><B>gender: </B><%= (c.getGender().equals("")) ? "Not Available" :c.getGender() %></li> </br>
	  		<li class = "listItem"><B>dateOfBirth: </B><%= (c.getDateOfBirth()==null) ? "Not Available" :c.getDateOfBirth()%></li> </br>
	  		<li class = "listItem"><B>Address: </B><%= (c.getAddress().equals("")) ? "Not Available" :c.getAddress()%></li> </br>
	  		<li class = "listItem"><B>city: </B><%= (c.getCity().equals("")) ? "Not Available" :c.getCity()%></li> </br>
	  		<li class = "listItem"><B>state: </B><%= (c.getState().equals("")) ? "Not Available" :c.getState()%></li> </br>
	  		<li class = "listItem"><B>country: </B><%= (c.getCountry().equals("")) ? "Not Available" :c.getCountry()%></li> </br>
	  		<li class = "listItem"><B>company: </B><%= (c.getCompany().equals("")) ? "Not Available" :c.getCompany()%></li> </br>
	  		</ul>
	  		</td>
	  	</tr>
	  <%
  }
  	%>
  	</div>
  </table>
  <form action="DeleteContact" method="post">
    <input type="text" style="display:none" name="labelcon" id="labelcon" value="0" ></label>
 <br> <br>	<button  type="submit" >Delete Selected</button>
  	</form>
	<footer id="footer">
	  <small id="footer-text">&copy; CodeFury App Monsters</small>
	</footer>
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
</script>

</body>
</html>
    