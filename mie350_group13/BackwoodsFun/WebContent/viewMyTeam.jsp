<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href = "style/LeagueSchedule.css" type = "text/css" rel = "stylesheet">
<head>
  <!-- <div img src = "BFC.png" style = "width:200px; height:150px;"></div> -->
</head>

<body>
  <br>
    <center><a href = "homepage.jsp"><img src = "style/BFC.png" style = "width:200px; height:150px;"></a></center>
  <br>
	<table border=1>
			<caption>"${name}"</caption>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Gender</th>
					<th>Position</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td align="center"><c:out value="${user.getFirstName()}" /></td>
						<td align="center"><c:out value="${user.getLastName()}" /></td>
						<td align="center"><c:out value="${user.getGender()}" /></td>
						<td align="center"><c:out value="${user.getPosition()}" /></td>
						<td align="center"><c:out value="${user.getEmail()}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>

</html>