<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href = "style/homepage.css" type = "text/css" rel = "stylesheet">
<head>

</head>

<body>
	<!-- <div class="content"> -->
		<a href = "createTeam.jsp" class="createteam" style="text-decoration: none"><span>Create a team</span> </a>
		<a href = "/BackwoodsFun/TeamController?action=listAllTeams" class = "jointeam" style = "text-decoration: none"><span> Join a team</span> </a>
		<a href = "/BackwoodsFun/ScheduleController?action=listSchedule" class = "schedule" style = "text-decoration: none"><span> League schedule</span> </a>
		<a href = "Standings.html" class = "standing" style = "text-decoration: none"><span> Standings</span> </a>
		<a href = "/BackwoodsFun/TeamController?action=listTeam" class = "team" style = "text-decoration: none"><span> View my team</span> </a>
		<a href = "RequestsPage.html" class = "reqpage" style = "text-decoration: none"><span> Requests </span> </a>
	<!-- </div> -->
	
	<div class = "schedule1">
	
	</div>


	<a href = "/BackwoodsFun/RequestController?action=newRequest"><span> New Game Request</span> </a>
	<a href = "/BackwoodsFun/RequestController?action=listRequest"><span> View My Requests</span> </a>
	
</body>

</html>