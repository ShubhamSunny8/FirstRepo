<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div align="right"><a href="getLoginPage.do">Logout</a></div>
		<center>
			<form action="getOccupancyOnFlight.do">
				
			<h3><span class="label label-default">Enter Flight No.</span></h3>
				<input type = "text" name="flightNo" maxlength="4" pattern="[1-9][0-9]{3}" title="Example : 7845" required>
				<button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-search"></span>View Occupancy</button>
				<!-- <input type="submit" value="View Occupancy"> -->
			</form>
			<br><br>
			
			<c:if test="${flightBean ne null}">
			<table >
   				<tr>
				<td><b>Flight Number : </b></td><td>${flightBean.flightNo}</td>
				</tr>
				<tr>
				<td><b>Airline : </b></td><td>${flightBean.airline}</td>
				</tr>
				<tr>
				<td><b>Departure City : </b></td><td>${flightBean.depCity}</td>
				</tr>
				<tr>
				<td><b>Arrival City : </b></td><td>${flightBean.arrCity}</td>
				</tr>
				<tr>
				<td><b>Departure Date : </b></td><td>${flightBean.depDate}</td>
				</tr>
				<tr>
				<td><b>Arrival Date : </b></td><td>${flightBean.arrDate}</td>
				</tr>
				<tr>
				<td><b>Departure Time : </b></td><td>${flightBean.depTime}</td>
				</tr>
				<tr>
				<td><b>Arrival Time : </b></td><td>${flightBean.arrTime}</td>
				</tr>
				<tr>
				<td><b>Number of First class seats : </b></td><td>${flightBean.firstSeats}</td>
				</tr>
				<tr>
				<td><b>Number of First class available : </b></td><td>${flightBean.firstSeatsAvailable}</td>
				</tr>
				<tr>
				<td><b>Number of Business class seats : </b></td><td>${flightBean.bussSeats}</td>
				</tr>
				<tr>
				<td><b>Number of Business class available : </b></td><td>${flightBean.bussSeatsAvailable}</td>
				</tr>
			</table>
			</c:if>
			
			<h2>${message}</h2>
			
			<a href="getExecutiveHomePage.do">Home</a>
			
		</center>
	</body>
</html>