<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Information List</title>
</head>
<body>

	<br/><br/><br/>
	<c:if test="${flightList ne null}">
	
<table align="center" border="1" bgcolor="#CCCCCC" cellspacing="0" cellpadding="2">
	<tr>
		<th>Flight Number</th>
		<th>Source City</th>
		<th>Destination City</th>
		<th>Airline</th>
		<th>Departure Date</th>
		<th>Arrival Date</th>
		<th>Departure Time</th>
		<th>Arrival Time</th>
		<th>Book</th>
	</tr>
	<c:forEach items="${flightList}" var="details">
		<tr>
			 <td>${details.flightNo}</td>
			 <td>${details.depCity}</td>
			 <td>${details.arrCity}</td>
			 <td>${details.airline}</td>
			 <td>${details.depDate}</td>
			 <td>${details.arrDate}</td>
			 <td>${details.depTime}</td>
			 <td>${details.arrTime}</td>
			 <td><a href ="ViewFlightDetailsForBooking.do?flightNo=${details.flightNo}"><b>Book Now</b></a></td>
		</tr>
	
	</c:forEach>
</table>
</c:if>
		

</body>
</html>