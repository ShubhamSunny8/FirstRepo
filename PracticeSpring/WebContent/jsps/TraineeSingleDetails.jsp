<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Trainee Info</h1>
<h3>${pageHead}</h3>

	<table border="1">
		<tr>
			<th>Trainee Id</th>
			<th>Trainee Name</th>
			<th>Trainee Location</th>
			<th>Trainee Details</th>
		</tr>
		
		<tr>
			<td>${trainee.traineeId}</td>
			<td>${trainee.traineeName}</td>
			<td>${trainee.traineeLocation}</td>
			<td>${trainee.traineedomain}</td>
		</tr>
		
	</table>
</body>
</html>