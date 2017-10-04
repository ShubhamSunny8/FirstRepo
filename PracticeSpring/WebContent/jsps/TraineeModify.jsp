<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Trainee Info</h1>
<form action="modifyNow.do">
Trainee ID:<input type="text" name="traineeId" value="${trainee.traineeId}" readonly="true"><br>
Trainee Name:<input type="text" name="traineeName" value="${trainee.traineeName}"><br>
Trainee Location:<input type="text" name="traineeLocation" value="${trainee.traineeLocation}"><br>
Trainee Domain:<input type="text" name="traineedomain" value="${trainee.traineedomain}"><br>
<input type="Submit" value="Update">
</form>
</center>
</body>
</html>