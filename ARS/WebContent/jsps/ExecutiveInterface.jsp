<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Executive functionality</title>
		<meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div align="right"><a href="getLoginPage.do">Logout</a></div>
		<center>
		<div class="container">
  		<div class="page-header">
		<h2>Executive</h2>                         <!-- both the options for executive -->
		<b><h3>Choose an option</h3></b></br>
		<table>
			<tr><td></td><td>
				<div class="list-group">
			    <a href="getFlightNoForOccupancy.do" class="list-group-item active">
			      <h4 class="list-group-item-heading">Flight Occupancy on Flight ID</h4>
			      
			    </a>
			    <a href="getDateForOccupancy.do" class="list-group-item">
			      <h4 class="list-group-item-heading">Flight Occupancy between two Dates</h4>
			    </a>
  			</div>
			<!-- <a href="getFlightNoForOccupancy.do">Flight Occupancy on Flight ID</a></br>
			</td></tr>
			<tr><td>2.</td><td>
			<a href="getDateForOccupancy.do">Flight Occupancy between two Dates</a><br>
			</td></tr> -->
			</table>
		</center>
		</div>
		</div>
	</body>
</html>