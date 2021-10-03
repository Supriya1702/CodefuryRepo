<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="css/registrationStyles.css">  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
body{
	background-image: url("images/admin.jpg");
    background-color: #cccccc;
   }
   label{
   color:#0066A2;
   }

   .panel-footer{
   background-color:color:#0066A2;
   }
</style>
</head>
<body>

<div class="container" style="width:100%; height:70% ;background-color: transparent;">
       <div class="row col-md-7 col-md-offset-3">

        <div class="panel panel-primary" style="margin-top:50px; margin-bottom:50px;">
           <div class="panel-heading text-center" style="margin-top:5px;">
               <h1>Registration Form</h1>
           </div>
           <div class="panel-body">
            <form id="userform" style="width:100%; margin:5px;" onsubmit="return validateform()" action="RegistrationServlet" method="post">
              

                <div class="form-group">
                    <label for="fullNameId">Full Name</label>
                    <input type = "text" name="name" placeholder="Enter full name"  id="fullNameId" class="form-control" required  pattern=".{6,}"  title="6 characters minimum">
                </div>
              
              <div class="row">
              
              <div class="col-md-6 mb-4" id="marginLeft" >
                <label for="emailId">Email</label>
                <input type = "email" name="email" placeholder="Enter email"  id="emailId" class="form-control" required title="someone@example.com" >
            </div>
            <div class="col-md-5 mb-4" style="width:45%;">
                <label for="phoneNumberId">Phone Number</label>
                <input type = "text" name="phoneno" placeholder="Enter contact number"  id="phoneNumberId" class="form-control" required maxlength="10" pattern=".{10}"  title="10 digits only">
            </div>
        </div>
          
            <div class="row">
                
                <div class="col-md-6 mb-4" id="marginLeft">
                <label for="genderId">Gender</label> <br>
                <select class="gender" required class="form-control" name="gender" style="width: 100%; height: 55%;">
                    <option value="">None</option>
                    <option value="Female">Female</option>
                    <option value="Male">Male</option>
                    <option value="Other">Other</option>
                  </select>
                </div>
               
                <div class="col-md-5 mb-4" style="width:45%;">
                    <label for="dobId">Date Of Birth</label>
                    <input type = "date" name="dob" placeholder="Enter date of birth"  id="dobId" class="form-control" required >
                </div>

            </div>
          
            <div class="form-group">
                <label for="addressId">Address</label>
                <textarea  placeholder="Enter address" name="address"  id="addressId" class="form-control" required pattern=".{10,40}" title="Enter 10-40 characters"></textarea>
            </div>
     
     
           <div class="row">
            <div class="col-md-6 mb-4" id="marginLeft">
                <label for="cityId">City</label>
                <input type = "text" placeholder="City" name="city" id="cityId" class="form-control" required   pattern=".{3,}"  title="3 characters minimum" >
            </div>

            <div class="col-md-5 mb-4" style="width:45%;" >
                <label for="stateId">State</label>
                <input type = "text" placeholder="State" name="state" id="stateId" class="form-control" required pattern=".{3,}"  title="3 characters minimum">
            </div>
           
        </div>
        
        
        <div class="row">
        <div class="col-md-6 mb-4" id="marginLeft">
            <label for="countryId">Country</label>
            <input type = "text" placeholder="Country" name="country" id="countryId" class="form-control" required pattern=".{3,}"  title="3 characters minimum">
        </div>
            <div class="col-md-5 mb-4" style="width:45%;">
                <label for="companyId">Company</label>
                <input type = "text" placeholder="Enter the company name" name="company" id="companyId" class="form-control" required  pattern=".{2,}"  title="2 characters minimum">
            </div>
        </div>
             
             
            <div class="form-group">
                <label for="usernameId">Username</label>
                <input type = "text" placeholder="Enter user name" name="username" id="usernameId" class="form-control" required pattern=".{6,}"  title="6 characters minimum" >
            </div>

        <div class="row">
            <div class="col-md-6 mb-4" id="marginLeft">
                <label for="passwordId">Password</label>
                <input type = "password" placeholder="Enter password" name="password"  id="passwordId" class="form-control" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Include one uppercase,lowercase and digit">
            </div>
            <div class="col-md-5 mb-4" style="width:45%;">
                <label for="confirmPasswordId">Confirm Password</label>
                <input type = "password" placeholder="Confirm password"  id="confirmPasswordId" class="form-control" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Include one uppercase, lowercase and digit">
            </div>
        </div>
        
        <div class="form-group">
            <input type="submit"  id="registerBtn" value="Register" class="btn btn-primary"></input>
            <div style="float: right;"> ${ message }</div>
        </div>
        
         </form>
         
           </div>
          

        </div>

       </div>

    </div>
    <div class=" text-right fixed-bottom" style="background-color:#343a40;height:30px; color:white;padding-right:20px;" >
             <small>&copy; 2021 CodeFury App Monsters</small> 
           </div> 

<script src="js/registrationValidations.js"></script> 
</body>
</html> 