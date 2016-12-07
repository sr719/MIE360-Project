<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href = "style/homepage.css" type = "text/css" rel = "stylesheet">
<head>

</head>

<body>
	<!-- <div class="content"> -->
  		<ul>
  			<li><a href = "createTeam.jsp" class="createteam" style="text-decoration: none"><span>Create a team</span> </a></li>
			<li><a href = "JoinATeam.html" class = "jointeam" style = "text-decoration: none"><span> Join a team</span> </a></li>
			<li><a href = "/BackwoodsFun/ScheduleController?action=listSchedule" class = "schedule" style = "text-decoration: none"><span> League schedule</span> </a></li>
			<li><a href = "Standings.html" class = "standing" style = "text-decoration: none"><span> Standings</span> </a></li>
			<li><a href = "/BackwoodsFun/TeamController?action=listTeam" class = "team" style = "text-decoration: none"><span> View my team</span> </a></li>
		</ul>
	<!-- </div> -->
	
	<div class = "schedule1">
	<table>
		<caption> MY SCHEDULE</caption>
		<tr>
			<th>Home</th>
			<th>Away</th>
			<th>Location</th>
			<th>Game Date</th>
			<th>Game Time</th>
		</tr>
		<tr>
			<td>Montreal Canadiens</td>
			<td>Maple Leafs</td>
			<td>Air Canada Centre</td>
			<td>11/02/2016</td>
			<td>10:00 pm</td>
		</tr>	
		</table>
	</div>


	<a href = "/BackwoodsFun/RequestController?action=newRequest"><span> New Game Request</span> </a>
	<a href = "/BackwoodsFun/RequestController?action=listRequest"><span> View My Requests</span> </a>
	
</body>

</html>