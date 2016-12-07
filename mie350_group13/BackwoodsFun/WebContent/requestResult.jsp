<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<link href = "style/LeagueSchedule.css" type = "text/css" rel = "stylesheet">

<table>
		<caption>Requests</caption>
		<thead>
  <tr>
    <th>Game</th>
    <th>Game Date</th>
    <th>Game Time</th>
    <th>Result</th>
    
  </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${noResults}" var="i">

					<tr>
						<td><c:out value="${i.getHome()} @ ${i.getAway()}" /></td>
						<td><c:out value="${i.getGame_Date()}" /></td>
						<td><c:out value="${i.getGame_time()}" /></td>
						<td align ="center"><a href="ScheduleController?action=result&reqID=<c:out value="${i.getId()}"/>">Result</a> </td>
						
					</tr>
				</c:forEach>
				</tbody>
 <!--  <tr>
    <td>Ottawa Valley</td>
    <td>1</td>
    <td align='center'><form><input type=submit value="join"></form></td>
  </tr> -->
</table>
</body>
</html>