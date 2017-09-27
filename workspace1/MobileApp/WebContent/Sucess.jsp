<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="700" align="center" border="1" bgcolor="#CCCCCC">
	<tr>
		<th>Recharge ID</th>
		<th>Name</th>
		<th>amunt</th>
		<th>validity</th>
		<th>Proceed</th>
	</tr>
	<c:forEach var="donor" items="${sessionScope.RechargeList}">
		<tr>
			<td>${donor.rid}</td>
			<td>${donor.rechargename}</td>
			<td>${donor.amount}</td>
			<td>${donor.validity}</td>
			<td><a href="UserDetails.jsp">Click Here</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>