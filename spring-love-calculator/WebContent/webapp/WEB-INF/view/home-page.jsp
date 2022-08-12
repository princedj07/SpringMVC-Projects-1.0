<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 40px;
}
</style>

<script type="text/javascript">
	function validateUserName() {
		var userName = document.getElementById('yn').value;
		if (userName.length < 2) {
// 			alert('your name should less than 2')
			return false;
		} else {
			return true
		}
	}
</script>

</head>
<body>
	<h1 align="center" style="color: red;">Love Calculator</h1><hr>
		
<%-- 	<form:form action="process-homepage" method="get" modelAttribute="userInfo" onsubmit="return validateUserName()"> --%>
	<form:form action="process-homepage" method="get" modelAttribute="userInfo">
		<div align="center">
			<p>
				<label for="yn">Your Name : </label> 
				<form:input id="yn" path="userName" />
				<form:errors  path="userName" cssClass="error"/>
			</p>
			<p>
				<label for="cn">Crush Name : </label> 
				<form:input id="cn" path="crushName" />
				<form:errors  path="crushName" cssClass="error"/>
			</p>
			<p>
				<form:checkbox path="termAndCondition" id = "check"/>
				<label> I am agreeing this form for fun game</label>
				<form:errors  path="termAndCondition" cssClass="error"/>
			</p>
			<input type="submit" value="Calculate">
		</div>
	</form:form>
</body>
</html>