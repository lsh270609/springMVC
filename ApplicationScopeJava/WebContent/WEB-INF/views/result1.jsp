<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>result1.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" />
	<br>
	<h3>applicationBean1.data1 : ${requestScope.applicationBean1.data1 }</h3>
	<h3>applicationBean1.data2 : ${requestScope.applicationBean1.data2 }</h3>
	<h3>applicationBean2.data3 : ${requestScope.applicationBean2.data3 }</h3>
	<h3>applicationBean2.data4 : ${requestScope.applicationBean2.data4 }</h3>
</body>
</html>