<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="style/theme.css">

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>MIE350 Sample DB Web App</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>.
	<center>
		<h1>Search A User</h1>
	</center>
	<div class="container">
		<center>
			<form method="POST" action='SearchController' name="frmAddUser">
				Keyword: <input type="text" name="keyword"
					value="<c:out value="${user.searchword}" />"><input
					type="submit" value="Submit" />
			</form>
		</center>
	</div>
</body>
</html>