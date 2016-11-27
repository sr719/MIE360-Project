<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MIE350 Sample Database Web App</title>
<link rel="stylesheet" type="text/css" href="style/theme.css">

</head>
<body>
	<%@ include file="navbar.jsp"%>
	<center>
		<h1>Sample HTML Tags</h1>
	</center>
	<div class="container">

		This page outlines basic HTML tags you can use to decorate your web
		app pages.<br>

		<blockquote>
			<b>This is bolded text.</b><br> &lt;b&gt;This is bolded
			text.&lt;/b&gt;
		</blockquote>

		<blockquote>
			<i>This is italicized text.</i><br> &lt;i&gt;This is italicized
			text.&lt;/i&gt;
		</blockquote>

		<blockquote>
			<u>This is underlined text.</u><br> &lt;u&gt;This is underlined
			text.&lt;/u&gt;
		</blockquote>

		<blockquote>
			This text contains<br>a line break.<br> This text
			contains&lt;br&gt;a line break.
		</blockquote>

		<table style="width: 100%">
			<tr>
				<td>Jill</td>
				<td>Smith</td>
				<td>50</td>
			</tr>
			<tr>
				<td>Eve</td>
				<td>Jackson</td>
				<td>94</td>
			</tr>
		</table>
		<div class="w3-code notranslate htmlHigh">
			&lt;table style=&quot;width:100%&quot;&gt;<br> &nbsp; &lt;tr&gt;<br>&nbsp;
			&nbsp; &lt;td&gt;Jill&lt;/td&gt;<br> &nbsp;&nbsp;&nbsp;
			&lt;td&gt;Smith&lt;/td&gt; <br>&nbsp;&nbsp;&nbsp;
			&lt;td&gt;50&lt;/td&gt;<br> &nbsp; &lt;/tr&gt;<br>&nbsp;
			&lt;tr&gt;<br>&nbsp;&nbsp;&nbsp; &lt;td&gt;Eve&lt;/td&gt;<br>
			&nbsp;&nbsp;&nbsp; &lt;td&gt;Jackson&lt;/td&gt; <br>&nbsp;&nbsp;&nbsp;
			&lt;td&gt;94&lt;/td&gt;<br> &nbsp; &lt;/tr&gt;<br>&lt;/table&gt;
		</div>


	</div>


	<%@ include file="footer.jsp"%>
</body>
</html>