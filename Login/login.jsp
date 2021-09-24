<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
    <div style="padding: 200px 0 0 350px;">
        <div id="login-box">
        <form name="myform">
        <H2 align="center" style="color:black">User Login</H2>
        <br />
        <br />
        <div id="login-box-name" style="margin-top:20px ;font-size:20;">UserName:</div><div id="login-box-field" style="margin-top:20px;">
        <input type="text" name="q" id="uname" class="form-login" title="Username"
        value="" size="30" maxlength="2048" /></div>
        <div id="login-box-name" style="font-size:15;">Password:</div><div id="login-box-field">
        <input type="password" name="q" id="password" class="form-login" title="Password" value="" size="30" maxlength="2048" /></div>
        <br />
        <br />
        <input type="submit" value="Login" class="btn" onclick='validate(); return false'></p>
        </form>
        </div>
        </div>
</body>
</html>