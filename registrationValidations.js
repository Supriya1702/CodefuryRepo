 function validateName(){
    
        var letters = /^[A-Za-z]+$/;
    
        var uname = $("#usernameId").value;
        if( uname == "" || uname == null){
            document.getElementById("nameError").innerHTML = "Name cannot be empty";
            return false;
        }
        
         else if( uname.length < 6){
            document.getElementById("nameError").innerHTML = "Name should be at least 6 characters long!";
             return false;
         }
        
         else if(!(letters.test(uname))){
            document.getElementById("nameError").innerHTML = "Name must contain only alphabets!";
             return false;
         }
        else
          return true;
    }




    function validateGender(){
        var gender = document.getElementById("gender").value;
        if(gender == "" || gender == null)
        {
            document.getElementById("genderError").innerHTML = "Gender can't be empty";
            return false;
        }
        else
          return true;
    }
    
    function validateAge(){
       
        var strage = document.getElementById("age").value;
        var age = parseInt(strage,10);
       
    
        if(strage == "" || strage == null)
        {
            document.getElementById("ageError").innerHTML="Age can't be empty";
            return false;
        }
       else if(!(age >= 18 && age <= 60))
        {
            document.getElementById("ageError").innerHTML="Enter age between 18 and 60";
            return false;
        }
        else
          return true;
    }