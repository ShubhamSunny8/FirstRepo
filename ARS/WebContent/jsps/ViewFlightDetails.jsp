<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Flight Details</title>
	</head>
	<body>
		<center>
			<h2>Flight Details</h2>
			<form action="getFarePage.do" method = "post">
				<table>
					<tr>
						<td><b>Flight No :  </b></td>
						<td><input type="text" name="flightNo" value="${flightBean.flightNo}"  readonly></td>
					</tr>
					
					<tr>
						<td><b>Source City : </b></td>
						<td><input type="text" name="depCity" value="${flightBean.depCity}" readonly></td>
					</tr>
					
					<tr>
						<td><b>Destination City : </b></td>
						<td><input type="text" name="arrCity" value="${flightBean.arrCity}" readonly></td>
					</tr>
					
					<tr>
						<td><b>Airline : </b></td>
						<td><input type="text" name="airline" value="${flightBean.airline}" readonly></td>
					</tr>
					
					<tr>
						<td><b>Departure Date : </b></td>
						<td><input type="text" name="depDate" value="${flightBean.depDate}" readonly></td>
					</tr>
					
					<tr>
						<td><b>Arrival Date : </b></td>
						<td><input type="text" name="arrDate" value="${flightBean.arrDate}" readonly></td>
					</tr>
					
					<tr>
						<td><b>Departure Time : </b></td>
						<td><input type="text" name="depTime" value="${flightBean.depTime}" readonly></td>
					</tr>
					
					<tr>
						<td><b>Arrival Time : </b></td>
						<td><input type="text" name="arrTime" value="${flightBean.arrTime}" readonly></td>
					</tr>
					
					<tr>
						<td><b>First Class Fare : </b></td>
						<td><input type="text" name="firstSeatFare" value="${flightBean.firstSeatFare}" readonly></td>
					</tr>
					
					<tr>
						<td><b>Business Class Fare : </b></td>
						<td><input type="text" name="bussSeatFare" value="${flightBean.bussSeatFare}" readonly></td>
					</tr>
					
					<tr>
						<td><b>Select Class Type : </b></td>
						<td><select name = "class" required>
							<option value = "FIRST"> First Class</option>
							<option value = "BUSINESS"> Business Class</option>
							</select></td>
					</tr>
					
					<tr>
						<td><b>Enter number of Passengers : </b></td>
						<td><input type="text" name="noOfPassengers" pattern = "[1-9][0-9]{0,1}" title = "Please enter numbers only" required></td>
					</tr>
					
					<tr>
						<td><input type="submit" value = "Submit"></td>
					</tr>
				</table>	
			</form>
		</center>
						${message}
	</body>
</html>