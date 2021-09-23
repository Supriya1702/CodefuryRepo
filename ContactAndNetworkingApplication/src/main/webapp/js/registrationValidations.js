
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
    

    function underAgeValidate(dateString) {
        var dateString = $('#dobId').val();
        var dates = dateString.split("-");
        var d = new Date();

        var userday = dates[2];
        var usermonth = dates[1];
        var useryear = dates[0];

        var curday = d.getDate();
        var curmonth = d.getMonth()+1;
        var curyear = d.getFullYear();

        var age = curyear - useryear;

        if((curmonth < usermonth) || ( (curmonth == usermonth) && curday < userday   )){

            age--;

        }
        
        if(age < 18) {
   		 alert("Age must be at least 18 years!");
        	    return false;
           }
        else{
   	    return true;
   	}
    }

    function validateform(){

       if( checkPass() && validateAddress() && underAgeValidate())
           return true;

       else
          return false;

    }