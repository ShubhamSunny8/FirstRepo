<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<form action="details.obj">
	<center>
	<b>Welcome to BookYourShow's Online Movie Ticket Booking</b>
	<br><br>
	<table>
	<tr>
		<td>Enter city name</td>
		<td><input type="text" name="city" title="Enter in the format Abcd" pattern="[A-Z][a-z]{2,19}" required></td>
	</tr>
	<tr>
		<td>Enter movie name</td>
		<td><input type="text" name="movie" title="Enter in the format Abcd" pattern="[A-Z][a-z\\s]{1,19}" required></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Proceed"></td>
	</tr>
	</table>
	</center>
	</form>
</body>
</html>