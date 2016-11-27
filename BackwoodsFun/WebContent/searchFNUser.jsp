<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="style/theme.css">

<title>MIE350 Sample DB Web App</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<center>
		<h1>Search Results</h1>
	</center>
	<div class="container-noborder">

		Hello! The time is now <b><%=new java.util.Date()%></b>.<br> <br>
		The following users match your search keyword "<b><font color=red><%=request.getAttribute("keyword")%></font></b>":<br>
		<br>
		<center>
			<table border=1>
				<thead>
					<tr>
						<th>User Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>DOB</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td align="center"><c:out value="${user.getUserid()}" /></td>
							<td align="center"><c:out value="${user.getFirstName()}" /></td>
							<td align="center"><c:out value="${user.getLastName()}" /></td>
							<td align="center"><fmt:formatDate pattern="yyyy-MMM-dd"
									value="${user.getDob()}" /></td>
							<td align="center"><c:out value="${user.getEmail()}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</center>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>