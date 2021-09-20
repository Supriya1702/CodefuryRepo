<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Contacts Page</title>
</head>

<body>
        <h1>Add Contact</h1>
        <form action="ContactServlet" method="post">
            <table style="with: 50%">
                <tr>
                    <td>FullName</td>
                    <td><input type="text" name="fullName" /></td>
                </tr>
                <tr>
                    <td>Email id:</td>
                    <td><input type="email" name="email" /></td>
                </tr>
                <tr>
                    <td>Phone No.</td>
                    <td><input type="tel" name="phone_no" /></td>
                </tr>
                 <tr>
                    <td>Gender</td>
                    <td><select name="gender">
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                    </select></td>
                </tr>
                <tr>
                    <td>Date of birth</td>
                    <td><input type="date" name="dateOfBirth" /></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" /></td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><input type="text" name="city" /></td>
                </tr>
                <tr>
                    <td>State</td>
                    <td><input type="text" name="state" /></td>
                </tr>
                <tr>
                    <td>Country</td>
                    <td><input type="text" name="country" /></td>
                </tr>
                <tr>
                    <td>Company</td>
                    <td><input type="text" name="company" /></td>
                </tr>
                 <tr>
                    <td>Contact Image</td>
                    <td><input type="file" name="contactImage" /></td>
                </tr>
                
                
            </table>
            <input type="submit" value="Submit" /></form>
            <input type="submit" value="GetResults"/>
            
    </body>

</html>