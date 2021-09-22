<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<script type = "text/javascript" 
src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
</script>
<link rel="stylesheet" type="text/css" href="css/registrationStyles.css">  
</head>
<body>

<form id="userform" onsubmit="return validateform()" action="RegistrationServlet" method="post">
	<h1 style="text-align:center">Registration Form</h1>

	<table style="margin: 0 auto; " id="registrationTb" >
		<tr><td>Full Name</td><td><input type = "text" name="name" placeholder="Enter full name"  id="fullNameId" required  pattern=".{6,}" required title="6 characters minimum"></td></tr>
		<tr><td>Email</td><td><input type = "email" name="email" placeholder="Enter email"  id="emailId" required  ></td></tr>
		<tr><td>Phone Number</td><td><input type = "number" name="phoneno" placeholder="Enter contact number"  id="phoneNumberId"  required maxlength="10" pattern=".{10}"  title="10 digits only"></td></tr>
		<tr><td>Gender</td><td><input type = "text" name="gender" placeholder="Enter gender"  id="genderId" required></td></tr>
		<tr><td>Date of Birth</td><td><input type = "date" name="dob" placeholder="Enter date of birth"  id="dobId" required ></td></tr>
		<tr><td>Address</td><td><textarea  placeholder="Enter address" name="address"  id="addressId" required pattern=".{10,40}" title="Enter 10-40 characters"></textarea></td></tr>
		<tr><td>City</td><td><input type = "text" placeholder="City" name="city" id="cityId" required   pattern=".{3,}"  title="3 characters minimum" ></td></tr>
		<tr><td>State</td><td><input type = "text" placeholder="State" name="state" id="stateId" required pattern=".{3,}"  title="3 characters minimum"></td></tr>
		<tr><td>Country</td><td><input type = "text" placeholder="Country" name="country" id="countryId"required pattern=".{3,}"  title="3 characters minimum"></td></tr>
		<tr><td>Company</td><td><input type = "text" placeholder="Enter the company name" name="company" id="companyId"required  pattern=".{2,}"  title="2 characters minimum"></td></tr>
		<tr><td>Upload Profile Image</td><td><input type = "file" placeholder="Photo" name="profileimage"  id="profileImageId" class="custom-file-upload" ></td></tr>
		<tr><td>User Name</td><td><input type = "text" placeholder="Enter user name" name="username" id="usernameId" required pattern=".{6,}"  title="6 characters minimum" ></td></tr>
		<tr><td>Password</td><td><input type = "password" placeholder="Enter password" name="password"  id="passwordId" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Include one uppercase,lowercase and digit"></td></tr>
		<tr><td>Confirm Password</td><td><input type = "password" placeholder="Confirm password"  id="confirmPasswordId" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Include one uppercase, lowercase and digit"></td></tr>
		<tr><td style="display:table-cell;" ></td><td  ><input type="submit"  id="registerBtn" value="Register" class="blue-btn"></input></td></tr>
</table>
${ message }
</form>
 
<script src="js/registrationValidations.js"></script> 
</body>
</html> 