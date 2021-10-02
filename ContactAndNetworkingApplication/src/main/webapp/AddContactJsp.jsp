<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Contacts Page</title>
<link href="css/background.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/navbarstyles.css">
<link rel="stylesheet" type="text/css" href="css/footerstyles.css">

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
	  		<li style="float:right"><a href="ViewProfile.jsp">Profile</a></li>
		</ul>
       <div  class="aligned" align="center" ><img src="images/add_contact_img.png" style="width:70px;"><h1 style="color:#0066A2; font-weight:bold;float:left">Add Contact</h1></div> 
        <form action="ContactServlet" method="post">
        
            <table class="table table-dark table-bordered table-hover"
			style="width: 45%; margin: auto;">
                <tr>
                    <td>Full Name</td>
                    <td><input type="text" name="fullName" placeholder="Mandatory" required pattern="^[A-Za-z]* [A-Za-z]*$"/></td>
                </tr>
                <tr>
                    <td>Email Id:</td>
                    <td><input type="email" name="email" placeholder="Mandatory " required /></td>
                </tr>
                <tr>
                    <td>Phone No.</td>
                    <td><input type="tel" name="phone_no" placeholder="Optional"/></td>
                </tr>
                 <tr>
                    <td>Gender</td>
                    <td><select name="gender" style="height:40%;">
                    <option value="select">Select</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                    </select></td>
                </tr>
                <tr>
                    <td>Date Of Birth</td>
                    <td><input type="date" name="dateOfBirth" /></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address"  placeholder="Optional"/></td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><input type="text" name="city"  placeholder="Optional"/></td>
                </tr>
                <tr>
                    <td>State</td>
                    <td><input type="text" name="state"  placeholder="Optional"/></td>
                </tr>
                <tr>
                    <td>Country</td>
                    <td><input type="text" name="country"  placeholder="Optional"/></td>
                </tr>
                <tr>
                    <td>Company</td>
                    <td><input type="text" name="company"  placeholder="Optional"/></td>
                </tr>
<!--                  <tr>
                    <td>Contact Image</td>
                    <td><input type="file" name="contactImage" /></td>
                </tr> -->
                
                <tr><td colspan="2"><input class="btn btn-primary" type="submit" value="ADD CONTACT" /></td></tr>
            </table>
           
           
            
             <div style="color:green ;margin-left:45%; display:none;"><h4> ${ message }</h4></div>
           </form>
         <div class=" text-right fixed-bottom" style="background-color:#0066A2;height:30px; color:white;padding-right:20px;" >
             <small>&copy; 2021 CodeFury App Monsters</small> 
           </div> 

    </body>

</html>
