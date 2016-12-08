<html>
<link href = "style/JoinATeam.css" type = "text/css" rel = "stylesheet">
<head>
</head>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
  
  <c:forEach items="${teams}" var="i">

					<tr>
						<td name="team"><c:out value="${i.getName()}" /></td>
						<td><c:out value="${i.getNumPlayers()}" /></td>
						<td align='center'><form> <input class = "join" type=submit value="Join"></form></td>
					</tr>
				</c:forEach>
				</tbody>
</table>
</body>

</html>