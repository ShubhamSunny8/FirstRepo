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
<table width="700" align="center" border="1" bgcolor="#CCCCCC">
	<tr>
		<th>Number</th>
		<th>Customer Name</th>
		<th>Address</th>
	</tr>
	<c:forEach var="custList" items="${sessionScope.custList}">
		<tr>
			<td>${custList.number}</td>
			<td>${custList.name}</td>
			<td>${custList.address}</td>
			
		</tr>
	</c:forEach>
</table>
</body>
</html>