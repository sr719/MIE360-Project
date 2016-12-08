<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href = "style/Standings.css" type = "text/css" rel = "stylesheet">
<head>
</head>

<body>
  <br>
    <center><a href = "homepage.html"><img src = "BFC.png" style = "width:200px; height:150px;"></a></center>
  </br>
  
  
  <table>
		<caption>Current Available Teams</caption>
  <tr>
    <th>Team Name</th>
    <th>Number of Players</th>
    <th>Join</th>
  </tr>
  	<tbody>
		<c:forEach items="${teams}" var="team">
			<tr>
				<td align="center"><c:out value="${team.getName()}" /></td>
				<td align="center"><c:out value="${team.getNumPlayers()}" /></td>
				<td <a href="TeamController?action=joinTeam&team=${team.getName()}">Accept</a> /></td>
			</tr>
		</c:forEach>
	</tbody>
  </table>
  
  
	<table>
		<caption>League Standings</caption>
  <tr>
    <th>Team Name</th>
    <th>Wins</th>
    <th>Losses</th>
    <th>Ties</th>
    <th>Points</th>
  </tr>
 <tbody>
		<c:forEach items="${standings}" var="standing">
			<tr>
				<td align="center"><c:out value="${standing.getTeam()}" /></td>
				<td align="center"><c:out value="${standing.getWins()}" /></td>
				<td align="center"><c:out value="${standing.getLosses()}" /></td>
				<td align="center"><c:out value="${standing.getTies()}" /></td>
				<td align="center"><c:out value="${standing.getPts()}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>

</html>