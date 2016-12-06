<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href = "style/createteam.css" type = "text/css" rel = "stylesheet">
<head>
</head>

<body>
	<div id="msform">
    <!-- progressbar -->
    <!-- fieldsets -->
    <form method="POST" action='TeamController' name="frmAddTeam">
    <fieldset>
        <h2 class="fs-title">Team Info</h2>
        <input type="text" name="tname" placeholder="Team Name" required />
        <input type="submit" name="submit" class="submit action-button" value="Submit"/>
 
    </fieldset>
    </form>
</div>
</body>

</html>