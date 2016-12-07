<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href = "style/JoinATeam.css" type = "text/css" rel = "stylesheet">
<head>
</head>

<body>
	<br>
    <center><a href = "homepage.html"><img src = "BFC.png" style = "width:200px; height:150px;"></a></center>
  <br>
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
</body>
</html>