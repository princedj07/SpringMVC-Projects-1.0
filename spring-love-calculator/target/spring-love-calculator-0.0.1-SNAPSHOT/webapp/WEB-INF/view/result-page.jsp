<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Page</title>
</head>
<body>
	<h1 align="center" style="color: red;">Love Calculator</h1>
	<hr>

	<h2>The Love Calculator Predicts :</h2>
	${userInfo.userName} and ${userInfo.crushName} are ${result}

	<br /><br />		
	
	<a href="/spring-love-calculator/sendEmail">Send Result to Your Email Id</a>
	
</body>
</html>