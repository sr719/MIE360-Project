<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style/login.css" type="text/css" rel="stylesheet">
<body>
<!-- multistep form -->
 <form id="msform" method="POST" action='LoginController' name="frmLogin">
    <!-- progressbar -->
    <!-- fieldsets -->
    <fieldset>
        <h2 class="fs-title">Login</h2>
        <input type="text" name="email" placeholder="Email" required />
        <input type="password" name="pass" placeholder="Password" required />
        <input type="submit" name="submit" class="submit action-button" value="Submit" />
    </fieldset>
</form>

</body>
</html>