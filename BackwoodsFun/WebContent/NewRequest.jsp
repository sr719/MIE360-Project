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
			$('input[name=date]').datepicker();
		});
	</script>
    
    <form method="POST" action='RequestController' name="frmRequest">
    	<fieldset>
        	<h2 class="fs-title">New Game Request</h2>
        	<select name="away">
                     <option value="Choose" selected>Opponent</option>
                     <option value="team1">team1</option>
                     <option value="team2">team2</option>
            </select>
	       	<input type="text" name="location" placeholder="Location" pattern="^[a-zA-Z]{2,}$" title="Minimum two letters" />
    	    <input type="text" name="date" placeholder="Date (MM/DD/YYYY)" pattern="^((((0[13578])|([13578])|(1[02]))[\/](([1-9])|([0-2][0-9])|(3[01])))|(((0[469])|([469])|(11))[\/](([1-9])|([0-2][0-9])|(30)))|((2|02)[\/](([1-9])|([0-2][0-9]))))[\/]\d{4}$|^\d{4}$" title="MM/DD/YYYY" />
        	<input type="text" name="time" placeholder="Time ex. 11:30am" pattern="^(((0?[1-9]|1[012])(:[0-5][0-9])?am)|((0?[0-9]|1[012])(:[0-5][0-9])?pm))\b" title="Enter time followed by am or pm, no spaces"/>
        	<input type="submit" name="submit" class="submit action-button" value="Create" />
    	</fieldset>
    </form>
</div>
</body>
</html>