<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 40px;
}
</style>

</head>
<body>
	<h1 align="center">Please Register Here</h1>

	<form:form action="registration-success" method="get"
		modelAttribute="userReg">

		<div align="center">

			<label>Name : </label>
			<form:input path="name" />
			<form:errors path="name" cssClass="error"/>
			<br /><br />  
			
			<label>UserName : </label>
			<form:input path="userName" />
			<form:errors path="userName" cssClass="error"/>
			<br /><br />  
			
			<label>Password : </label>
			<form:input path="password" />
			<br /><br />  
			
			<label>Country : </label>
			<form:select path="countryName">
				<form:option value="IND" label="India"></form:option>
				<form:option value="USA" label="United States"></form:option>
				<form:option value="SL" label="ShriLunka"></form:option>
				<form:option value="ENG" label="England"></form:option>
			</form:select>
			<br /><br />  
			
			<label>Hobbies : </label> 
			Cricket :
			<form:checkbox path="hobbies" value="cricket" />
			Reading :
			<form:checkbox path="hobbies" value="reading" />
			Travel :
			<form:checkbox path="hobbies" value="travel" />
			Programming :
			<form:checkbox path="hobbies" value="programming" />
			<br /><br />  
			
			<label>Gender : </label> 
			Male
			<form:radiobutton path="gender" value="male" />
			Female
			<form:radiobutton path="gender" value="female" />
			<br /><br />  
			
			<label>Age : </label>
			<form:input path="age" />
			<form:errors path="age" cssClass="error"/>
			<br /><br />  
			 
		</div>

		<div align="center">
			<h3>Communication</h3>
			
			<label>Email</label>
			<form:input path="communicationDTO.email" />
			<form:errors path="communicationDTO.email" cssClass="error"/>
			<br />
			<br />
			
			<label>Phone</label>
			<form:input path="communicationDTO.phone" />
		</div>
		
		<br />

		<div align="center">
			<input type="submit" style="color: blue;" value="Register">
		</div>

	</form:form>
</body>
</html>