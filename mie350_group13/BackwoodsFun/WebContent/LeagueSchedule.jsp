<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href = "style/LeagueSchedule.css" type = "text/css" rel = "stylesheet">
<head>
  <!-- <div img src = "BFC.png" style = "width:200px; height:150px;"></div> -->

</head>


<body w3-include-html="/fullcalendar-3.0.1/demos/default.html">
  <br>
    <center><a href = "homepage.html"><img src = "BFC.png" style = "width:200px; height:150px;"></a></center>
    
  </br>

  <a rel="import" href="/BackwoodsFun/ScheduleController?action=fullSchedule"> Full Schedule<a/>


<table>
		<caption>Season Schedule</caption>
		<thead>
  <tr>
    <th>Game</th>
    <th>Game Date</th>
    <th>Game Time</th>
    <th>Result </th>
  </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${mySchedule}" var="i">

					<tr>
						<td><c:out value="${i.getHome()} - ${i.getAway()}" /></td>
						<td><c:out value="${i.getGame_Date()}" /></td>
						<td><c:out value="${i.getGame_time()}" /></td>
						<td><c:out value="${i.getResult()}" /></td>
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