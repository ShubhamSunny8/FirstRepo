<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.capgemini.rechargeapplication.bean.SubscriberBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<% SubscriberBean subscriberBean = (SubscriberBean)session.getAttribute("subscriberBean"); %>
		<b>Account Summary On</b>
		<div>
			<% 
				Date date = new Date();
				out.println(date);
			%><br>
			Subscriber Id: <%= subscriberBean.getSubscriberId() %>  <br>
			Account Balance: <%= subscriberBean.getAccountBalance() %> <br>
			Recharge Due Date: <%= subscriberBean.getRechargeDate() %>  <br>
			Recommended Recharge: <%= ((Float)session.getAttribute("packageAmount")) - subscriberBean.getAccountBalance()  %> <br> 
			Click Here to <a href="recharge.jsp">Recharge Amount</a>
		</div>
	</body>
</html>