<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All availaible films</title>
</head>
<body>
<table width="700" align="center" border="1" bgcolor="#CCCCCC">
	<tr>
		<th>movieId</th>
		<th>Movie Name</th>
		<th>theatreLocation</th>
		<th>Click for Booking</th>
	</tr>
	<c:forEach var="custList" items="${sessionScope.n1}">
		<tr>
			<td>${custList.movie_id}</td>
			<td>${custList.movie_name}</td>
			<td>${custList.theatre_name}</td>
			<td>${custList.status}</td>
			<td><a href="book.obj?movieId=${custList.movie_id }">Book Here</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>