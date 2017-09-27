<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="login.do" method="GET">
			<table>
				<tr>
					<td>Enter Registered Mobile Number:</td>
					<td><input type="text" name="mobileNumber" pattern="[7-9][0-9]{9}" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
					<td></td>
				</tr>
			</table>
		</form>
	</body>
</html>