<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/registrationStyles.css">  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
body{
	background-image: url("images/bg.jpg");
    background-color: #cccccc;
   }
</style>
</head>
<body>
	<div class="container" style="opacity:0.9;">
	  <div class="row col-md-7 col-md-offset-3">
	    <div class="panel panel-primary" style="margin-top:30%; margin-bottom:50px;">
           <div class="panel-heading text-center" style="margin-top:5px;">
               <h3>Login Page</</h3>
           </div>
           <div class="panel-body">
             <form id="loginform" action="LoginServlet" method="post">
             
             
        <div class="row">
        <div class="col-md-4 mb-4" style="margin-left:20%;" >
            <label for="emailId" style="font-size:18px;color:#0066A2;">Email :</label>  
        </div>
        <div class="col-md-4 mb-4" >
                <input type = "email" name="email" placeholder="Enter email"  id="emailId" required >
            </div>
        </div>
        <div class="row">
        <div class="col-md-4 mb-4" style="margin-left:20%;" >
             <label for="passwordId" style="font-size:18px;color:#0066A2;">Password:</label>
        </div>
        <div class="col-md-4 mb-4" >
                  <input type = "password" placeholder="Enter password" name="password"  id="passwordId" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Include one uppercase,lowercase and digit">
            </div>
        </div>
        
        <div class="row" style="justify-content:center;">
          <input type="submit"  id="loginBtn" value="Login" class="blue-btn" style="width:50%;"></input>
          
        </div>
    
     
          
       </div>
         <div >&nbsp;</div>
         
	     <div class="panel-footer text-right">
             <small>&copy; CodeFury App Monsters</small> 
           </div>
	  </div>

	</div>
	
	</div>
	 <div >${ message }</div>
	 <center><a href="HomePage.jsp" style="color: black">Go back to Home Page</a></center>
</body>
</html>