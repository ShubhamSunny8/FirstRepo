<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<center>
	<br/><br/>
	<h1>Enter your Details.</h1>
	
		<form method="post" action="submitSignUpDetails.do">
		<table>
			<tr>
				<td><b>Enter First Name: </b></td>
				<td><input type="text" name="firstName" maxlength="15" pattern="[A-Z][a-z]{1,15}" title="Example : Alex" required/></td>
			</tr>
			
			<tr>
				<td><b>Enter Last Name: </b></td>
				<td><input type="text" name="lastName" maxlength="15" pattern = "[A-Z][a-z]{1,15}" title="Example : Hunter" required/></td>
			</tr>
			
			<tr>
				<td><b>Enter UserName: </b></td>
				<td><input type="text" name="userName" maxlength="20" pattern = "[A-Za-z0-9]{5,20}" required title="Minimum 5 characters required"/></td>
			</tr>
			
			<tr>
				<td><b>Enter Password: </b></td>
				<td><input type="text" name="password" maxlength="15" pattern = "[A-Za-z0-9]{5,20}" required="true" title="Minimum 5 characters required and No punctuation marks allowed !!"/></td>
				</tr>
				
			<tr>
				<td><input type="submit" value = "Sign Up"/></td>
				<td><input type="reset" value = "Reset"/></td>
			</tr>
		</table>
		</form>
	
	<br/><br/><a href="getLoginPage.do">Go Back to Home Page</a>
	</center>
	

</body>
</html>