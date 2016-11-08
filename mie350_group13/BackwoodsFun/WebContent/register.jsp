<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style/register.css" type="text/css" rel="stylesheet">
<body>
<!-- multistep form -->
<div id="msform">
    <!-- progressbar -->
    <!-- fieldsets -->
    
    
    
    <script>
		$(function() {
			$('input[name=dob]').datepicker();
		});
	</script>
    
    <form method="POST" action='UserController' name="frmAddUser" onsubmit="return checkInput();">
    	<fieldset>
        	<h2 class="fs-title">Registration</h2>
        	<input type="text" name="fname" placeholder="First Name" pattern="^[a-zA-Z]{2,}$" title="Minimum two letters" />
	       	<input type="text" name="lname" placeholder="Last Name" pattern="^[a-zA-Z]{2,}$" title="Minimum two letters" />
    	    <input type="text" name="dob" placeholder="Date Of Birth(MM/DD/YYYY)" pattern="^((((0[13578])|([13578])|(1[02]))[\/](([1-9])|([0-2][0-9])|(3[01])))|(((0[469])|([469])|(11))[\/](([1-9])|([0-2][0-9])|(30)))|((2|02)[\/](([1-9])|([0-2][0-9]))))[\/]\d{4}$|^\d{4}$" title="MM/DD/YYYY" />
        	<select name="gender">
                     <option value="Choose" selected>Choose</option>
                     <option value="Male">Male</option>
                     <option value="Female">Female</option>
            </select>
            <select name="pos">
                     <option value="Choose" selected>Choose</option>
                     <option value="Defense">Defense</option>
                     <option value="Forward">Forward</option>
                     <option value="Goalie">Goalie</option>
            </select>
        	<input type="text" name="email" placeholder="Email"/>
        	<input type="password" name="pass" placeholder="Password" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$" title="4-8 Characters, upper/lowercase and one number"/>
        	<input type="password" name="cpass" placeholder="Confirm Password" />
        	<input type="submit" name="submit" class="submit action-button" value="Submit" />
    	</fieldset>
    </form>
    
    <script type="text/javascript">
      function checkInput()
      {
		boolean valid = true;
		string alertMessage = "";
         if(document.forms["frmAddUser"]["fname"].value == ""|| document.forms["frmAddUser"]["fname"].value == null){
            alertMessage = alertMessage + "-Please provide your first name!\n";
            valid = false;
         }
         if(document.forms.lname.value == ""|| document.forms.lname.value == null){
        	 alertMessage = alertMessage + "-Please provide your last name!\n";
             valid = false;
          }
         if(document.forms.gender.value == "Choose"){
        	 alertMessage = alertMessage + "-Please choose a gender!\n";
             valid = false;
          }
         if(document.forms.pos.value == "Choose"){
        	 alertMessage = alertMessage + "-Please choose a position!\n";
             valid = false;
          }
         if(document.forms.email.value == ""|| document.forms.email.value == null){
        	 alertMessage = alertMessage + "-Please provide your email!\n";
             valid = false;
          }
         if(document.forms.pass.value != document.forms.cpass.value){
        	 alertMessage = alertMessage + "-Make sure your password entries match!\n";
             valid = false;
          }
         if((document.forms.pass.value == ""|| document.forms.pass.value == null)
        		 || (document.forms.cpass.value == ""|| document.forms.cpass.value == null)){
        	 alertMessage = alertMessage + "-Make sure you enter a password AND a confirmation!\n";
             valid = false;
          }
         if(valid){
        	 return valid;
          }
         else{
        	 alert(alertMessage);
        	 return valid;
         }
      }

	</script>
    
</div>

</body>
</html>