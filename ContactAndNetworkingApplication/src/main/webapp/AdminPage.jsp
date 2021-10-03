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

<style>

.admin-card{
background-color:#46008b;
height:100px;
width:200px;
box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
border-radius: 10px;
color:white;
text-align: center;
padding: 18px 0;
font-style: italic;
font-size:1.5em;
height:120px;  width: 45%; margin-top: 20px;
margin-left:20px;
}

.admin-hello{
background-color:transparent
height:100px;
width:100%;
color:white;
text-align: center;
padding: 18px 0;
font-family:Vogue;
font-weight:bold;
}
body{
background-color: #a4508b;
background-image: linear-gradient(326deg, #a4508b 0%, #5f0a87 74%);
}


.disable-users-btn{
background-color:#46008b;
height:120px;  width: 45%; margin-top: 20px;
box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
border-radius: 10px;
color:white;
font-style: italic;
font-size:1.5em;
margin-left:20px;
}

</style>


</head>

<body>
	<ul>
	  <li><a class="active" href="AdminLoginServlet">Home</a></li>
	  <li style="float:right"><a href="AdminLogout.jsp">Logout</a></li>
	</ul>

	<div>
	 <div class="admin-hello" style="margin-right:40px;"><h1>Welcome <%= request.getAttribute("name")%> </h1>
	 </div>
	  <img src="images/admin_bg.jfif" style="float:right; width:50%;height:100%;margin-bottom:55px;margin-top:10px;margin-right:20px;border-radius:10px;"></img>
	
<div class="admin-card" >Your Details : <br>
	Email : <%= request.getAttribute("email") %> <br>
	Phone No : <%= request.getAttribute("phone") %> <br></div>
	
	
<div class="admin-card">
	 <br>	The Count of Active users are : <%= request.getAttribute("count") %>
	</div>
	
	  <form action="AdminServlet?option=disabled" method="post">
	<button  class="disable-users-btn" type="submit" >Click to Disable Users</button>
	  </form>
	  
	  <div class="admin-card"> <br><a style="color:white;padding-top:10px;" href="AdminDeletePage.jsp" >Click to see Inactive Users</a></div>
	 
	  </div>

	   <div class=" text-right fixed-bottom" style="background-color:#343a40;height:30px; color:white;padding-right:20px;" >
             <small>&copy; 2021 CodeFury App Monsters</small>
           </div>


</body>
</html>