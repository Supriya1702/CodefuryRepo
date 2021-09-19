function validateUserName()
{
var name=window.document.getElementById("uname").value;
			if(name=="" || name==null)
			alert("Username Cannot be empty");
			else if(name.length <6)
			alert("username should be atleast 6 characters long");
			else
			return true;
}

function validatePassword()
{
var pwd=window.document.getElementById("password").value;
			if(pwd=="" || pwd==null)
			alert("Password Cannot be empty");
			else
			return true;
}

function validate()
			{
			if(validateUserName() && validatePassword())
			{
			 return true;
			}
			else
			alert("Some error!!! Please check the fields again")
			return false;
			}