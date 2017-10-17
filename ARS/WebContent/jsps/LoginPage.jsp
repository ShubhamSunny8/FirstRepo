<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Page</title>
	</head>
	<body bgcolor="AliceBlue">
	<center><h1><font face="georgia">Welcome to Airline Reservation System</font></h1></center>
		<center>
		
		<form method="post" action="submitLoginDetails.do">
		<table border="0">
			
				<tr>
					<td><font face="georgia">Enter Username:</font></td>
			  		<td><input name="userName" type="text" required/></td>
			  	</tr>
			  			  
			  	<tr>
			  		<td><font face="georgia">Enter Password:</font></td>
					<td><input name="password" id="password" type="text" required/></td>
				</tr>
			  	
			  	<tr>
			  		<td><font face="georgia">Role:</font></td>
			  		<td>
			  			<input type="radio" name="role" value="customer" required/><font face="georgia">Customer</font>
			  			<input type="radio" name="role" value="executive"/><font face="georgia">Executive</font>
			  			<input type="radio" name="role" value="admin"/><font face="georgia">Admin</font>
			  		</td>
			  	</tr>
			  	
			  
			
		</table>
		 	<input type="submit" value="Sign In"/><br/><br>
			  <font face="georgia">Don't have an account? </font><a href="getSignUpPage.do">SignUp</a>
		</form>
		
		<br><br>
		<h2>${message}</h2>
		</center>
	</body>
</html>