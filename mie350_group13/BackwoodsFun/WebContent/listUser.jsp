<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="style/theme.css">

<title>Backwoods Fun Club</title>
</head>
<body>

	<%@ include file="navbar.jsp"%>
	<center>
		<h1>List All Players</h1>
	</center>
	<div class="container-noborder">

		<%
			String name = request.getParameter("firstName");
			session.setAttribute("session_name", name);
		%>

		Hello
		<%out.print(session.getAttribute("session_name"));%>!<br>
		<br> The time is now <b><%=new java.util.Date()%></b>.<br> <br>
		The following people are members of the Backwoods Fun Club: <br> <br> <a
			href="UserController?action=insert">Add A New User</a> <br> <br>
		<table border=1>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>DOB</th>
					<th>Gender</th>
					<th>Position</th>
					<th>Team</th>
					<th>Administrator</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td align="center"><c:out value="${user.getFirstName()}" /></td>
						<td align="center"><c:out value="${user.getLastName()}" /></td>
						<td align="center"><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.getDob()}" /></td>
						<td align="center"><c:out value="${user.getGender()}" /></td>
						<td align="center"><c:out value="${user.getPosition()}" /></td>
						<td align="center"><c:out value="${user.getTeam()}" /></td>
						<td align="center"><c:out value="${user.getAdminString()}" /></td>
						<td align="center"><c:out value="${user.getEmail()}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>