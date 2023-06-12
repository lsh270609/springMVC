<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test3.jsp</h1>
	<form:form modelAttribute="beanData" action="result">
		data1 : <form:input path="data1" /><br>
		data2 : <form:input path="data2" /><br>
		password : <form:password path="data3" showPassword="true" /><br>
		textarea : <form:textarea path="data4" /><br>
		<form:button>전송</form:button>
	</form:form>
</body>
</html>