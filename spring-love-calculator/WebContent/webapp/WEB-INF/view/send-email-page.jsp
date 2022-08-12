<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email Page</title>
</head>
<body>

<%-- <h1>Hi ${userName}</h1> --%>

<h1>Hey ${userInfo.userName}</h1>

<h2>Send Result To Your Email</h2>

<form:form action="process-email" method="GET" modelAttribute="emailDTO">
	
	<label>Enter Your Email</label>
	<form:input path="userEmail" />
	<input type="submit" value="send">
	
</form:form>

</body>
</html>