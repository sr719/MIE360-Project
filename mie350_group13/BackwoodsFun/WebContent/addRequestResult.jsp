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
        	<select name="Loc" >
                     <option value="${result.getHomeOrAway()}" disabled selected>${result.getHomeOrAway()}</option>
                    
                     
            </select>
           <select name="opponent">
            <option value="${opponent}" disabled selected hidden>${opponent}</option>                 
		     </select>
		     <input type="text" name="schId" placeholder="Id"  value="<c:out value="${ID}" />" readonly/>
        	<input type="text" name="Location" placeholder="Location"  value="<c:out value="${result.getLocation()}" />" readonly/>
	    	<input type="text" name="game_Date" placeholder="Game Date" value="<c:out value="${result.getGame_Date()}" />"title="MM/DD/YYYY" readonly/>
	       	<input type="text" name="time" placeholder="Time ex. 11:30am" value="<c:out value="${result.getGame_time()}" />"readonly/>
	       	<input type="text" name="HomeScore" placeholder="Home Score"  required/>
	       	<input type="text" name="AwayScore" placeholder="Away Score"  required/>
        	<input type="submit" name="submit" class="submit action-button" value="Submit" >       	
        	
    	</fieldset>
    </form>
    </div>
</body>
</html>