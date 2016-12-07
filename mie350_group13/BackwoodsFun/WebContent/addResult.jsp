<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="style/register.css" type="text/css" rel="stylesheet">

<head>
<script type="text/javascript">
function CheckLoc(val){
 var element1=document.getElementById('opponentAway');
 var element2=document.getElementById('opponentHome');

 if(val=='Home'){
   element1.style.display='block';
   document.getElementsByName('Home Score')[0].placeholder= 'Your Team Score';
 }
 else  if (val=="Away"){
   element2.style.display='block';
 document.getElementsByName('Away Score')[0].placeholder= 'Your Team Score';}

}

</script> 

<body>
<div id="msform">
    <form method="POST" action='UserController' name="frmAddUser" >
    	<fieldset>
        	<h2 class="fs-title">Add Result</h2>
        	<select name="pos" onchange='CheckLoc(this.value);'>
                     <option value="Home or Away?" disabled selected>Home or Away?</option>
                     <option value="Home" required>Home</option>
                     <option value="Away" required>Away</option>
                     
            </select>
            <input type="text" name="opponentHome" id="opponentHome" placeholder="Home" style='display:none;'/>
            <input type="text" name="opponentAway" id="opponentAway"  placeholder="Away" style='display:none;'/>
        	<input type="text" name="Location" placeholder="Location" pattern="^[a-zA-Z]{2,}$" title="Minimum two letters" required/>
	    	<input type="date" name="game_Date" placeholder="Game Date" required/>
	       	<input type="text" name="time" placeholder="Time ex. 11:30am" pattern="^(((0?[1-9]|1[012])(:[0-5][0-9])?am)|((0?[0-9]|1[012])(:[0-5][0-9])?pm))\b" title="Enter time followed by am or pm, no spaces"required/>
	       	<input type="text" name="Home Score" placeholder="Home Score"  required/>
	       	<input type="text" name="Away Score" placeholder="Away Score"  required/>
        	<input type="submit" name="submit" class="submit action-button" value="Submit" >       	
        	
    	</fieldset>
    </form>
    </div>
</body>
</html>