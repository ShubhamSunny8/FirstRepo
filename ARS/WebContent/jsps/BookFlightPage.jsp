<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer Interface Page</title>
	</head>
	<body bgcolor="cyan">
			<center>
			<marquee scrolldelay="10"><font face="arial"><h1>Book your ticket!!!</h1></font></marquee>
			<form method="post" action="getFlightListForBooking.do">
				<table>
					<tr>
						<td><font face="verdana">Source City: </font></td>		<!--//will display lexicographically later  -->
						<td>
							<select name="source" id="source" required>
			   				 	<c:forEach var="depCity" items="${depCityList}">
			   				 	<option value="${depCity}">${depCity}</option>   
			   				 	</c:forEach>				 	
		       				</select><br/>
						</td>
					</tr>
					
					<tr>
						<td><font face="verdana">Destination City: </font></td>		<!--//will display lexicographically later  -->
						<td>
							<select name="destination" id="destination" required>
			   				 	<c:forEach var="arrCity" items="${arrCityList}">
			   				 	<option value="${arrCity}">${arrCity}</option>   
			   				 	</c:forEach>  				 	
		       				</select><br/>
						</td>
					</tr>
					
					<tr>
						<td><font face="verdana">Date Of Journey</font></td>
						<td><input type="date" min="${today}" name="doj" required></td>		<!-- //to be changed -->
					</tr>
					
				</table><br/>
				
						<center>
							<td><input type="submit" value="Choose Seats" ></td>
						</center>
			</form>
			<h1>${message}</h1>
			</center>
			
			</body>
			</html>
			