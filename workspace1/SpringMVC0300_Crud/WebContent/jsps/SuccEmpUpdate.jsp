<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>updated page</title>
<script src="scripts/jquery-1.12.3.js" type="text/javascript"></script>
<script src="scripts/MyJsLib.js" type="text/javascript"></script>
</head>
<body>
<h1>Capgemini India Pvt.Ltd. Mumbai</h1>
<h3>${pageHead}</h3>

	<table>
		<tr>
			<th>Employee Number</th>
			<th>Employee Name</th>
			<th>View Details</th>
		</tr>
		
		<tr>
			<td>${emp.empNo}</td>
			<td>${emp.empNm}</td>
			
		<td>${emp.empSal}</td>
			
			<td>${emp.hireDate}</td>
			
		</tr>
		
	</table>
	<a href="getUpdateNamePage.do">EmpList</a>
	<a href="getHomePage.do">HomePage</a>
</body>
</html>