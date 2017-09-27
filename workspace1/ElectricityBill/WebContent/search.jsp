<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User Search sucessfull</h1>
<table width="700" align="center" border="1" bgcolor="#CCCCCC">
	<tr>
		<th>Subscriber id</th>
		<th>mobile number</th>
		<th>pid</th>
		<th>Account balance</th>
		<th> Recharge due date</th>
	</tr>
	<c:forEach var="a" items="${sessionScope.a}">
		<tr>
			<td>${a.num}</td>
			<td>${a.mobmum}</td>
			<td>${a.pid}</td>
			<td>${a.balance}</td>
			<td>${a.date}</td>	
		</tr>
	</c:forEach>
</table>
</body>
</html>