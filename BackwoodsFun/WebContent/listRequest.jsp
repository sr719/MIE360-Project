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
		<h1>List All Requests</h1>
	</center>
	<div class="container-noborder">

		<%
			String name = request.getParameter("firstName");
			session.setAttribute("session_name", name);
		%>

		Hello
		<%out.print(session.getAttribute("session_name"));%>!<br>
		<br> The time is now <b><%=new java.util.Date()%></b>.<br> <br>
		The following people are the requests specific to your team: <br> <br>
		<table border=1>
			<thead>
				<tr>
					<th>Team</th>
					<th>Location</th>
					<th>Date</th>
					<th>Time</th>
					<th>Email</th>
					<th>Accept</th>
					<th>Decline</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requests}" var="request">
					<tr>
						<td align="center"><c:out value="${request.getHome()}" /></td>
						<td align="center"><c:out value="${request.getLocation()}" /></td>
						<td align="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${request.getDate()}" /></td>
						<td align="center"><c:out value="${request.getTime()}" /></td>
						<td align="center"><c:out value="${request.getReqAdmin()}" /></td>
						<td <a href="RequestController?action=accept&req=${request.getKey()}">Accept</a> /></td>
						<td <a href="RequestController?action=decline">Decline</a> /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>