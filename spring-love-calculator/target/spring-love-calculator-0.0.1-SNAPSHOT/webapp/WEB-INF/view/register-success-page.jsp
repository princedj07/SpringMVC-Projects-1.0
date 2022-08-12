<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Success</title>
</head>
<body>
<h1>Your Registration is Successful</h1>
<h2>The details entered by you are : </h2> 

User : ${userReg.name} <br/>

UserName : ${userReg.userName} <br/>

Password : ${userReg.password} <br/>

Country : ${userReg.countryName} <br/>

Hobbies : 

<c:forEach var="temp" items="${userReg.hobbies}">
	${temp} 
</c:forEach>

<br/>

Gender : ${userReg.gender} <br/>

Age : ${userReg.age} <br/>

Email : ${userReg.communicationDTO.email} <br/>

Phone : ${userReg.communicationDTO.phone} <br/>


</body>
</html>