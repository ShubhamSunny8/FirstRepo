<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Thank You for Booking with Airline Reservation System<br></h1>
	Your Booking Id is : <h1>${sessionScope.bookingId}</h1>
	<br><br><br>
	<a href="getLoginPage.do">Log Out</a>
	<a href="getCustomerHomePage.do">Home</a>
	
</body>
</html>