<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="empModule">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
<script type="text/javascript" src="scripts/angular.js" ></script>
<script type="text/javascript" src="scripts/EmpApp.js" ></script>
</head>
<body>
{{3+5}}

<h3>{{pageHead}}</h3>
<div ng-controller="empController">
<h1>{{title}}</h1>
	<table  align ="center" id ="empList">
		<tr>
			<th>Employee Number</th>
			<th>Employee Name</th>
			<th>View Details</th>
			<th>Delete Employee</th>
		</tr>
		<tr ng-repeat="emp in empList">
			<td>{{emp.empNo}}</td>
			<td>{{emp.empNm}}</td>
			<td><button ng-click="empDetails(emp.empNo)">view</button>
			<td><button ng-click="empDelete(emp.empNo)">Delete</button>
		</tr>
	</table>
	<table  align ="center">
		<tr>
			<th>Employee Number</th>
			<th>Employee Name</th>
			
		</tr>
		<tr >
			<td>{{emp.empNo}}</td>
			<td>{{emp.empNm}}</td>
			
		</tr>
	</table>
	</div>
	
</body>
</html>