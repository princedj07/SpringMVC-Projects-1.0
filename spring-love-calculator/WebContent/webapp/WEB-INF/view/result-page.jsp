<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<b>${userInfo.userName}</b> and
	<b>${userInfo.crushName}</b> ${userInfo.result}

	<br />
	<br />

<!-- 	<a href="/spring-love-calculator/sendEmail">Send Result to Your Email Id</a> -->
<!-- This is URL Encoding -->
	<a href="<c:url value = "/sendEmail" />">Send Result to Your Email Id</a>

</body>
</html>