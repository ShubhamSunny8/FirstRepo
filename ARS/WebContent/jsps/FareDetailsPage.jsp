<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Fare Details</title>
		</head>
	<body>
		<center>
		<h2>Transaction Details</h2>
		<form action="getSuccessBookingPage.do" method="post">
			<table>
				<tr>
					<td><b>Total Fare : </b></td>
					<td><input type="text" value="${sessionScope.totalFare}" readonly></td>
				</tr>
				<tr>
					<td><b>Enter your E-Mail ID : </b></td>
					<td><input type="email" name="custEmail" ></td>
				</tr>
				<tr>
					<td><b>Enter Credit Card Number : </b></td>
					<td><input type="text" name="creditCardInfo" pattern="[1-9][0-9]{15}" title="Enter 16 digit number"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Pay Now"></td>
				</tr>
			</table>
		</form> 
		</center>
	</body>
</html>