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
		<form action="showCancelDetailsPage.do" method = "post">
			<b>Enter Booking ID :  </b>
			<input type = "text" name="bookingId" maxlength="15" pattern="[1-9][0-9]{3}" title="Example : 7845" required><br/><br/>
			
			<input type="submit" value="View Details">
		</form>
		
		<br><br>
		
		<c:if test="${bookingBean ne null}">

			<form action="CancelBooking.do" method = "post">
			<table>
			
				<tr>
					<td> Booking ID : </td>
					<td> <input type = "text" name="bookingId" value="${bookingBean.bookingId}" readonly="readonly"></td>
				</tr>
				
				<tr>
					<td> Flight No :  </td>
					<td> ${bookingBean.flightNo}</td>
				</tr>
				
				<tr>
					<td> Departure Date : </td>
					<td> ${bookingBean.depDate}</td>
				</tr>
				
				<tr>
					<td> Departure Time : </td>
					<td> ${bookingBean.depTime}</td>
				</tr>
				
				<tr>
					<td> Departure City : </td>
					<td> ${bookingBean.srcCity}</td>
				</tr>
	
				<tr>
					<td> Arrival Date : </td>
					<td> ${bookingBean.arrDate}</td>
				</tr>
				
				<tr>
					<td> Arrival Time : </td>
					<td> ${bookingBean.arrTime}</td>
				</tr>
				
				<tr>
					<td> Arrival City : </td>
					<td> ${bookingBean.destCity}</td>
				</tr>
				
				<tr>
					<td> UserName : </td>
					<td> ${bookingBean.userName}</td>
				</tr>
				
				<tr>
					<td> E-Mail : </td>
					<td> ${bookingBean.custEmail}</td>
				</tr>	

				<tr>
					<td> Class Type : </td>
					<td> ${bookingBean.classType}</td>
				</tr>
				
				<tr>
					<td> Number of Passengers : </td>
					<td> ${bookingBean.noOfPassengers}</td>
				</tr>
				
				<tr>
					<td> Total Fare : </td>
					<td> ${bookingBean.totalFare}</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Cancel Booking"></td>
				</tr>
				
			</table>
			</form>
			
			
		
		</c:if>
		
		<h1>${message}</h1>
		
		
	</center>
</body>
</html>