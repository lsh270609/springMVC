<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.error {color:red; font-size:80%;}
</style>
<body>
	<h1>inputData.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" /><hr>
	<form:form modelAttribute="testBean1" action="inputProcedure" method="post">
		data1 : <form:input path="data1" type="text" />&nbsp;&nbsp;&nbsp;
				<form:errors path="data1" class="error"/><br>
		data2 : <form:input path="data2" type="text" />&nbsp;&nbsp;&nbsp;
				<form:errors path="data2" class="error"/><br>
		data3 : <form:input path="data3" type="number" />&nbsp;&nbsp;&nbsp;
				<form:errors path="data3" class="error"/><br>
		data4 : <form:input path="data4" type="number" />&nbsp;&nbsp;&nbsp;
				<form:errors path="data4" class="error"/><br>
		data5 : <form:input path="data5" type="number" />&nbsp;&nbsp;&nbsp;
				<form:errors path="data5" class="error"/><br>
		data6 : <form:input path="data6" type="number" />&nbsp;&nbsp;&nbsp;
				<form:errors path="data6" class="error"/><br>
		data7 : <form:input path="data7" type="text" />&nbsp;&nbsp;&nbsp;
				<form:errors path="data7" class="error"/><br>		
		<form:button type="submit">전송</form:button>
	</form:form>
</body>
</html>