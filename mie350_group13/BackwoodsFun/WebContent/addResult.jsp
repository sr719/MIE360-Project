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
    <form method="POST" action='ScheduleController' name="frmAddResult" >
    	<fieldset>
        	<h2 class="fs-title">Add Result</h2>
        	<select name="Loc" onchange='CheckLoc(this.value);'>
                     <option value="Home or Away?" disabled selected>Home or Away?</option>
                     <option value="Home" required>Home</option>
                     <option value="Away" required>Away</option>
                     
            </select>
           <select name="opponent">
            <option value="Choose" disabled selected hidden>Opponent</option>
        	
        	<c:forEach items="${otherTeams}" var="i">
                     <option value="${i.getName()}"> ${i.getName()}</option> <!-- have to somehow get the value of the think in the middle show up on the page -->
                     
			</c:forEach>
            </select>
        	<input type="text" name="Location" placeholder="Location" pattern="^[a-zA-Z]{2,}$" title="Minimum two letters" required/>
	    	<input type="text" name="game_Date" placeholder="Game Date" pattern="^((((0[13578])|([13578])|(1[02]))[\/](([1-9])|([0-2][0-9])|(3[01])))|(((0[469])|([469])|(11))[\/](([1-9])|([0-2][0-9])|(30)))|((2|02)[\/](([1-9])|([0-2][0-9]))))[\/]\d{4}$|^\d{4}$" title="MM/DD/YYYY" required/>
	       	<input type="text" name="time" placeholder="Time ex. 11:30am" pattern="^(((0?[1-9]|1[012])(:[0-5][0-9])?am)|((0?[0-9]|1[012])(:[0-5][0-9])?pm))\b" title="Enter time followed by am or pm, no spaces"required/>
	       	<input type="text" name="HomeScore" placeholder="Home Score"  required/>
	       	<input type="text" name="AwayScore" placeholder="Away Score"  required/>
        	<input type="submit" name="submit" class="submit action-button" value="Submit" >       	
        	
    	</fieldset>
    </form>
    </div>
</body>
</html>