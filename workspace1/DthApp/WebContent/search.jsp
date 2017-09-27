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

	<c:forEach var="a" items="${sessionScope.a}">
		Subscriber id:${a.num} <br/>
		mobile number:${a.mobno} <br/>
		pid:${a.pid} <br/>
		Account balance:${a.balance} <br/>
		Recharge due date:${a.date} <br/>
	</c:forEach>
</table>
Click here for recharge<a href="recharge.jsp">recharge amount</a><br>
</body>
</html>