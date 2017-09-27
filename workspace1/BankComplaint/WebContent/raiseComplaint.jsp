<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Raise complaint</h1>

<%
Object obj=request.getAttribute("compId");
if(obj!=null && obj instanceof Integer)
{
	 int cmpId =(Integer)obj;
	 out.println("Complaint SucessFully raised"+cmpId);
}

%>
	<form action ="ComplaintController?action=addcomplaint" method="post">
	Customer name:<input type="text" name="customername"/><br/><br/>
	Account id:<input type="text" name="accountId"/><br> <br>
	category: <select name="categary">
					<option value="Internet Banking"> Internetbanking </option>
					<option value="Basic Banking"> basic banking </option>
					<option value="Others"> Others </option>
				</select><br/>
				<br/>
	Description:<input type="text" name="desc"></input>
	<input type= "submit" value="proceed">
	</form>
</body>
</html>