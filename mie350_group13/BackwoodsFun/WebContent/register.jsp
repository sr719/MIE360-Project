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
    	
    <form method="POST" action='UserController' name="frmAddUser" >
    	<fieldset>
        	<h2 class="fs-title">Registration</h2>
        	<input type="text" name="fname" placeholder="First Name" pattern="^[a-zA-Z]{2,}$" title="Minimum two letters" required/>
	       	<input type="text" name="lname" placeholder="Last Name" pattern="^[a-zA-Z]{2,}$" title="Minimum two letters" required />
    	    <input type="text" name="dob" placeholder="Date Of Birth(MM/DD/YYYY)" pattern="^((((0[13578])|([13578])|(1[02]))[\/](([1-9])|([0-2][0-9])|(3[01])))|(((0[469])|([469])|(11))[\/](([1-9])|([0-2][0-9])|(30)))|((2|02)[\/](([1-9])|([0-2][0-9]))))[\/]\d{4}$|^\d{4}$" title="MM/DD/YYYY" required/>
        	<select name="gender" required>
                     <option value="Gender" disabled selected hidden >Gender</option>
                     <option value="Male">Male</option>
                     <option value="Female">Female</option>
            </select>
            <select name="pos">
                     <option value="Position" disabled selected>Position</option>
                     <option value="Defense" required>Defense</option>
                     <option value="Forward" required>Forward</option>
                     <option value="Goalie"required >Goalie</option>
            </select>
        	<input type="text" name="email" placeholder="Email"/>
        	<input type="password" id="pass" name="pass" placeholder="Password" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$" title="4-8 Characters, upper/lowercase and one number"required/>
        	<input type="password" id="cpass" name="cpass" placeholder="Confirm Password" required/>
        	<input type="submit" name="submit" class="submit action-button" value="Submit" onclick="return validatePassword()" >       	
        	<script>
        	<!--Javascript code to make sure asswords are the same -->
        	

        	function validatePassword(){
        	  var pass1 = document.getElementById("pass").value;
          	  var pass2 = document.getElementById("cpass".value);
        	  if(pass1 != pass2) {
        	    document.getElementById("pass").style.borderColor = "#E34234";
        	    document.getElementById("cpass").style.borderColor = "#E34234";	  
        	    alert("Passwords Do Not Match");
        	    return false;
        	  } else {
        		 
        	    return true;
        	  }
        	}

        	
        	</script>
    	</fieldset>
    </form>
</div>

</body>
</html>