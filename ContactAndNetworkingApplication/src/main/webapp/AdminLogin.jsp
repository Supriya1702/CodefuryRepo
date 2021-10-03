<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Admin Login</title>

<link href="css/AdminLoginCss.css" rel="stylesheet" type="text/css" />
<script src="js/AdminLoginJs.js">
</script>

<style>
#login-box{


}

</style>

</head>

<body>


<div style="padding: 200px 0 0 350px;">


<div id="login-box">
<form name="myform" action = "AdminLoginServlet" method = "post">
<H2 align="center">Admin Login</H2>

<br />
<br />

<div id="login-box-name" style="margin-top:20px ;font-size:18;">Username:</div>
<div id="login-box-field" style="margin-top:20px;">
<input type="text" name="username" id="uname" class="form-login" title="Username" value="" size="30" maxlength="2048" /></div>
<div id="login-box-name" style="font-size:18;">Password:</div><div id="login-box-field">
<input type="password" name="password" id="password" class="form-login" title="Password" value="" size="30" maxlength="2048" /></div>
<br />
<br />
<br />
<p><input type="submit" value="Login" onclick = "validate()" class="btn" ></p>
</form>
<center><a href="HomePage.jsp" style="color:white;font-weight:bold; font-size:15px; text-align:center;margin-left:40px;">Go back to Home Page</a></center>

</body>
</html>