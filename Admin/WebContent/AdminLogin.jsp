<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Admin Login</title>

<link href="AdminLoginCss.css" rel="stylesheet" type="text/css" />
<script src="AdminLoginJs.js">
</script>

</head>

<body>


<div style="padding: 200px 0 0 350px;">


<div id="login-box">
<form name="myform" action = "LoginServlet" method = "post">
<H2 align="center">Admin Login</H2>

<br />
<br />
<div id="login-box-name" style="margin-top:20px ;font-size:15;">UserName:</div><div id="login-box-field" style="margin-top:20px;">
<input type="text" name="q" id="uname" class="form-login" title="Username" 
value="" size="30" maxlength="2048" /></div>
<div id="login-box-name" style="font-size:15;">Password:</div><div id="login-box-field">
<input type="password" name="q" id="password" class="form-login" title="Password" value="" size="30" maxlength="2048" /></div>
<br />
<span class="login-box-options" style="font-size:12;"><input type="checkbox" name="1" value="1"> Remember Me <a href="#" style="margin-left:30px; font-size:12;">Forgot password?</a></span>
<br />
<br />
<input type="submit" value="Login" class="btn" ></p>
</form>

</div>

</div>

</body>
</html>