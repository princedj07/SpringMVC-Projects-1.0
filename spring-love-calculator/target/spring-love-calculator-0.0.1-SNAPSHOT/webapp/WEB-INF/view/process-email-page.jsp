<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email Result Page</title>
</head>
<body>
<%-- 	<h2>Hello ${userName}</h2> --%>
	<h2>Hello ${userInfo.userName}</h2>
	<label>Email Successfully sent to ${emailDTO.userEmail}</label>
</body>
</html>