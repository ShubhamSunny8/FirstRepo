<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entry Page</title>
</head>
<body>
<div align="right"><a href="getLoginPage.do">Logout</a></div>
<div align="left"><a href="getCustomerHomePage.do">Back</a></div>
<center>
<br/><br/><br/>
		<form action="showBookingDetailsPage.do" method = "post">
			<b>Enter Booking ID :  </b>
			<input type = "text" name="bookingId" maxlength="15" pattern="[1-9][0-9]{3}" title="Example : 7845" required><br/><br/>
			
			<input type="submit" value="View Details">
		</form>
		
		<br><br>
		
		<c:if test="${bookingBean ne null}">
			
			<h2>Trip Details</h2>

			<table>
			
				<tr>
					<td><b> Booking ID : </b></td>
					<td> ${bookingBean.bookingId}</td>
				</tr>
				
				<tr>
					<td><b> Flight No :  </b></td>
					<td> ${bookingBean.flightNo}</td>
				</tr>
				
				<tr>
					<td><b> Departure Date : </b></td>
					<td> ${bookingBean.depDate}</td>
				</tr>
				
				<tr>
					<td><b> Departure Time : </b></td>
					<td> ${bookingBean.depTime}</td>
				</tr>
				
				<tr>
					<td><b> Departure City : </b></td>
					<td> ${bookingBean.srcCity}</td>
				</tr>
	
				<tr>
					<td><b> Arrival Date : </b></td>
					<td> ${bookingBean.arrDate}</td>
				</tr>
				
				<tr>
					<td><b> Arrival Time : </b></td>
					<td> ${bookingBean.arrTime}</td>
				</tr>
				
				<tr>
					<td><b> Arrival City : </b></td>
					<td> ${bookingBean.destCity}</td>
				</tr>
				
			</table>
			

			<h2>Traveler Details</h2>

			<table>
				<tr>
					<td><b> UserName : </b></td>
					<td> ${bookingBean.userName}</td>
				</tr>
				
				<tr>
					<td><b> E-Mail : </b></td>
					<td> ${bookingBean.custEmail}</td>
				</tr>	
			</table>

			<h2>Fare Details</h2>

			<table>
				<tr>
					<td><b> Class Type : </b></td>
					<td> ${bookingBean.classType}</td>
				</tr>
				
				<tr>
					<td><b> Number of Passengers : </b></td>
					<td> ${bookingBean.noOfPassengers}</td>
				</tr>
				
				<tr>
					<td><b> Total Fare : </b></td>
					<td> ${bookingBean.totalFare}</td>
				</tr>
			</table>
		
		</c:if>
		
		<h1>${message}</h1>
		
		
	</center>
</body>
</html>