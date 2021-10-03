<%@page import="java.util.HashMap"%>
<%@page import="com.contactandnetworkingapplication.dao.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inactive Users</title>
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css">
<link rel="stylesheet" type="text/css" href="css/footerstyles.css">
<link href="css/background.css" rel="stylesheet" type="text/css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
table {
	opacity: 0.8;
}

.aligned {
	margin-left: 40%;
	display: flex;
	align-items: center;
}

h1 {
	padding: 10px;
}

input,select {
	width: 100%;
	color: black;
}

td,th {
	text-align: center;
}
body{
background-color: #a4508b;
background-image: linear-gradient(326deg, #a4508b 0%, #5f0a87 74%);
}

</style>
</head>
<body>
	<ul>
	  <li><a class="active" href="AdminLoginServlet">Home</a></li>
	  <li style="float:right"><a href="AdminLogout.jsp">Logout</a></li>
	</ul>
<center>

		<%	AdminDAO adao = new AdminDAO();
			HashMap <Integer , String> hp = adao.getDeleteUser();
			String message = (String)request.getAttribute("message");
			if(hp != null){
				%>
		<table class="table table-dark table-bordered table-hover" style="width: 45%; margin: auto;">
  	<tr>

  		<th>Id</th>
  		<th>Name</th>
  		<th>Select</th>
  	</tr>

		<%			for(HashMap.Entry<Integer, String> entry : hp.entrySet()) {
					Integer id = entry.getKey();
					String name = entry.getValue();
					System.out.println(id+":"+name);
		%>
				  <tr>
	  		<td><%= id %></td>
	  		<td><%= name %></td>
	  		<td><input type="checkbox" id ="chbox" class ="selectedContact" onclick="deleteContact()" value=<%=  id %>></td>
	  		   	</tr>
				<br>
	<% 		} %>


 </table>
 			<form action="AdminServlet?option=delete" method="post">
    		<label><input type="text" style="display:none" name="labelcon" id="labelcon" value="0" ></label>
			<br> <br>	<button class="btn btn-primary"  style="border-color:white;" type="submit" >Delete Selected</button>
  			</form>
	<%
				}
				else {
		%>
		<h4><%= message  %></h4>
	<% }
	%>
</center>
<script type="text/javascript">
function deleteContact(){
	var list = document.getElementsByClassName("selectedContact");
	var deleteUsers = [];
	var delUse = "";
	for (var i =0; i<list.length; i++){
		if(list[i].checked==true){
			delUse = delUse + list[i].value + "," ;
			deleteUsers.push(list[i].value)
			console.log(list[i].value)
		}
	}
	if(deleteUsers != null){
		console.log(deleteUsers);
	var lab=document.getElementById("labelcon");
	lab.value = delUse;
	return true;
	}
	else{return false;}
	console.log(delUse);
 }
</script>
	   <div class=" text-right fixed-bottom" style="background-color:#343a40;height:30px; color:white;padding-right:20px;" >
             <small>&copy; 2021 CodeFury App Monsters</small> 
           </div> 

</body>
</html>