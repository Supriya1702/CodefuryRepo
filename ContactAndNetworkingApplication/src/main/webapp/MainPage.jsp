<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@page import="com.contactandnetworkingapplication.model.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Main page</title>
<link href="css/background.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css"> 
<link rel="stylesheet" type="text/css" href="css/footerstyles.css"> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>

th,td{

border-radius: 10px;
 }

 .anchor-style {
     color: #000;
     text-transform: uppercase;
     font-weight: bold;
     font-style: italic;
     padding-bottom: 10px;
     padding-left:10px;
}

.polaroid{
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  margin-bottom: 25px;
}

.card_image{
 height:25%;
 width:25%;
}

.polaroid img{
background-color:white;
border-radius: 8px;
}

.polaroid:hover{
transform: scale(1.2);}

.polaroid a{
 color:white;
}
table.test td {
 background-color:#343a40;
  margin: 16px 16px 16px 16px;
  padding: 16px 16px 16px 16px;
}

table.test {
  border-collapse: separate;
  border-spacing: 35px;
  *border-collapse: expression('separate', cellSpacing='10px');
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
	  <li ><a class="active" href="LoginServlet">Home</a></li>
	  <li style="float:right"><a href="Logout.jsp">Logout</a></li>
	  <li style="float:right"><a href="ViewProfile.jsp">Profile</a></li>
	</ul>
	<%
		User res = (User)request.getAttribute("User");
	%>
	<div>
		<h1>Welcome <%= res.getName() %></h1><br>
	<%
            LocalDate dt = LocalDate.now();
            int day = dt.getDayOfMonth();
            int month = dt.getMonthValue();
            Month month_name = dt.getMonth();
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String s = formatter.format(res.getDob());
            LocalDate user_date = LocalDate.parse(s);
            int user_day = user_date.getDayOfMonth();
            int user_month = user_date.getMonthValue();
            
            if(day==user_day && month==user_month) {
                
        %>
                <h2>Hey it's <%=month_name %> <%=day %>.<br>  Wish you a very Happy Birthday <%= res.getName() %>!!</h2>
        <%  } %>
	<br/>
	</div>
	<br/><br/><br/>

	<table class="table-dark test" style="width: 70%; margin: auto; ">
	<tr>
		<td class="polaroid">

			<img src="https://cdn0.iconfinder.com/data/icons/business-dual-color-glyph-set-2/128/Address_book-512.png"  class="card_image">

				<a class="anchor-style" href="ContactDetailsJsp.jsp">View Contacts</a>


		</td>
		
		<td class="polaroid">

			<img src="https://cdn2.iconfinder.com/data/icons/bussiness-management-supersolid/24/add_add_contact_create_new_person_user_add_friend-512.png"  class="card_image">

				<a class="anchor-style" href="AddContactJsp.jsp">Add New Contact</a>


		</td>
		
		<td class="polaroid">

			<img src="https://library.kissclipart.com/20180829/ike/kissclipart-search-user-icon-clipart-computer-icons-user-761033d83b6b74f8.png"  class="card_image">

				<a class="anchor-style" href="SearchUser.jsp">Search Users</a>


		</td>
	</tr>
	
	<tr>
		
		<td class="polaroid">

			<img src="https://icon-library.com/images/connect-icon-png/connect-icon-png-18.jpg" class="card_image">

				<a  class="anchor-style" href="FriendServlet?option=view">View Friends</a>

		</td>
		
		<td class="polaroid">

			<img src="https://static.thenounproject.com/png/2714894-200.png"  class="card_image">

				<a class="anchor-style" href="FriendRequestsServlet?option=view">View Friend Requests</a>

		</td>
		
		<td class="polaroid">

			<img src="https://cdn.iconscout.com/icon/premium/png-512-thumb/block-person-1446662-1222337.png" class="card_image">

				<a class="anchor-style" href="FriendServlet?option=block">Blocked Users</a>

		</td>
		
	</tr>


	
	</table>
	  <div class=" text-right fixed-bottom" style="background-color:#0066A2;height:30px; color:white;padding-right:20px;" >
             <small>&copy; 2021 CodeFury App Monsters</small>
      </div>
</body>
</html>
