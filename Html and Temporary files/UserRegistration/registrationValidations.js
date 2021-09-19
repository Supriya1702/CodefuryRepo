
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

       if( checkPass() && validateAddress())
           return true;

       else
          return false;

    }