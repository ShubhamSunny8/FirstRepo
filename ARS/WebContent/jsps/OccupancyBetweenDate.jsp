<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="right"><a href="getLoginPage.do">Logout</a></div>
	<center>
		<br><br>
		<form action="getOccupancyOnDate.do" method="post">
				<b>Start Date :  </b>
				<input type="date" name="start" min="${today}" required> &nbsp&nbsp
				<b>End Date :  </b>
				<input type="date" name="end" min="${today}" required> &nbsp&nbsp
				<input type="submit" value="View Occupancy">
			</form>
			<br>
			
			<c:if test="${flightList ne null}">
				
				Start Date : ${startDate} &nbsp&nbsp End date : ${endDate}
				
				<table border="1">
				   <tr>
						<th>Flight Id</th>
						<th>Airline</th>
						<th>Departure City</th>
						<th>Arrival City</th>
						<th>Departure Date</th>
						<th>Arrival Date</th>
						<th>Departure Time</th>
						<th>Arrival Time</th>
						<th>First class seats</th>
						<th>First class seats available</th>
						<th>Business class seats</th>
						<th>Business class seats available</th>
					</tr>
	
	
				   <c:forEach items="${flightList}" var="flight">
				   <tr>
					   <td>${flight.flightNo}</td>
					   <td>${flight.airline}</td>
					   <td>${flight.depCity}</td>
					   <td>${flight.arrCity}</td>
					   <td>${flight.depDate}</td>
					   <td>${flight.arrDate}</td>
					   <td>${flight.depTime}</td>
					   <td>${flight.arrTime}</td>
					   <td>${flight.firstSeats}</td>
					   <td>${flight.firstSeatsAvailable}</td>
					   <td>${flight.bussSeats}</td>
					   <td>${flight.bussSeatsAvailable}</td>
				   </tr>
				   </c:forEach>
   
   				</table>
			
			</c:if>
			
			<br>
			<h2>${message}</h2>
			
			<a href="getExecutiveHomePage.do">Home</a>
	</center>
</body>
</html>