
 $(document).ready(function(){
    

;
    $("#registerBtn").click(function () {
   
        // validateName();
        // validateGender();
        // validateEmail();
        // validatePhoneNum();
    });


  });

 function validateName(){
  
        var regexName = /^[a-zA-Z\s]+$/;
        var uname = $("#fullNameId").val();
      
        if( uname == "" || uname == null)
            alert("Name cannot be empty") ;  
        else if( uname.length < 6)
            alert("Name should be at least 6 characters");
        else if(!regexName.test(uname))
           alert("Name can only have alphabets!");
    
    }




     function validateGender(){
        var gender = $('#genderId').val();
        if(gender == "" || gender == null)
          { 
             alert("Gender can't be empty!");
            return false;
        }
        else
         return true;
        }
    
    function validateEmail(){
     var emailRegex  = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
     if(!emailRegex.test($('#emailId').val()))
       {
        alert("Invalid email!");
        return false;
       } 
       else
         return true;

    }

    function validatePhoneNum(){
         phoneRegex = /^\d+$/;
        if(!$('#phoneNumberId').val().length == 10){
            alert("Phone Number must be 10 digits!");
            return false;
        }
           
        else if(!phoneRegex.test($('#phoneNumberId').val())){
            alert("Phone num must only have digits!"); 
            return false;
        }
        else
        return true;
           
    }

    function checkPass(){

        if( ! ($('#passwordId').val() == $('#confirmPasswordId').val())) {  
            alert("Passwords don't match!")  ;   
            return false;
          }
         else
           return true;  
          
    }

    function validateAddress(){

        if($('#addressId').val().length == 0 ){
            alert("Address can't be empty");
            return false;
        }
          
        else if( $('#addressId').val().length <= 5) 
        {
            alert("Address should be minimum 5 characters!");
            return false;
        }
        else
        return true;
    }

    function validateform(){

       if( checkPass() &&  validateAddress())
           return true;

        // if(validateName() && validateGender() && validateEmail() && validatePhoneNum())
        //    return true;
        // else
        //    return false;

      

    }