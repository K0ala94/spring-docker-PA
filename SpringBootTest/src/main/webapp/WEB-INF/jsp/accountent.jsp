<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accountent page</title>
</head>
<body>
	<h1>Hello this is your personal accountant</h1>
	<c:forEach items="${months}" var = "month">
	
		
		<span name="date"><h3>${month.year} ${month.monthAsString}</h3></span>
		
		<h4>
			<label for=sum>Sum: </label>
			<span id="sum">${month.expenseSum} Ft</span>
		</h4>
		<br/>
		
		<c:forEach items="${month.expenses}" var="expense">
			
			<span id="amount">${expense.amount} ${expense.currency}</span>
			
			<span> ${expense.description} </span>
			<br/>
		</c:forEach>
	</c:forEach>
	
</body>
</html>