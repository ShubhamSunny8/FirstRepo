<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sf:form method="post" modelAttribute="trainee" action="submitTraineeDetails.do">

<%-- <label for="TraineeId">TraineeId:</label>
  <sf:input path="traineeId" type="text"/><br/> --%>
  
  <label for="TraineeName">Trainee Name:</label>
	<sf:input path="traineeName" id="traineeName" type="text"/><br/>
  
  <label for="traineeLocation">Trainee Location:</label>
  <sf:radiobutton path="traineeLocation" value="Chennai" label="chennai"/>
  <sf:radiobutton path="traineeLocation" value="Banglore" label="Banglore"/>
  <sf:radiobutton path="traineeLocation" value="Pune" label="Pune"/>
  <sf:radiobutton path="traineeLocation" value="Mumbai" label="Mumbai"/><br>


  <sf:select path="traineedomain">
  <sf:option value="JEE">JEE</sf:option>
  <sf:option value="DOT-NET">DOT NET</sf:option>
   <sf:option value="SAP">SAP</sf:option>
   </sf:select></br>
   <%-- <sf:select path="traineedomain" value="DOT-NET"></sf:select>
    <sf:select path="traineedomain" value="SAP"></sf:select> --%>
  <input type="submit" value="Submit Details"/>
  </sf:form>

</body>
</html>