<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="loginform" action="LoginServlet" method="post">
	<h1 style="text-align:center">Login Page</h1>

	<table style="margin: 0 auto; " id="loginTb" >
		<tr><td>Email</td><td><input type = "email" name="email" placeholder="Enter email"  id="emailId" required  ></td></tr>
		<tr><td>Password</td><td><input type = "password" placeholder="Enter password" name="password"  id="passwordId" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Include one uppercase,lowercase and digit"></td></tr>
		<tr><td style="display:table-cell;" ></td><td  ><input type="submit"  id="loginBtn" value="Login" class="blue-btn"></input></td></tr>
	</table>
	</form>
	${ message }
</body>
</html>