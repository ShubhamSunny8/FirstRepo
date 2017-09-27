<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="scripts/jquery-1.12.3.js" type="text/javascript"></script>
<script src="scripts/MyJsLib.js" type="text/javascript"></script>
</head>
<body>
<sf:form method="post" modelAttribute="employee" action="submitEmpDetails.do">

<label for="empNm">Enter Name:</label>
  <sf:input path="empNm" type="text"/><br/>
  <sf:errors path="empNm" name="error"></sf:errors><br>
  
  <label for="sal">Enter Sal</label>
	<sf:input path="empSal" id="sal" type="text"/><br/>
  
  <label for="hireDate">Enter date</label>
	<sf:input path="hireDate" id="hireDate" type="text"/><br/>
  
  
  <label for="email">Email:</label>
  <sf:input path="email" type="text"/><br/>
  <sf:errors path="email" name="error" placeholder="something@mail.com"></sf:errors><br>
  
  
  <input type="submit" value="Submit Details"/>
</sf:form>
</body>
</html>