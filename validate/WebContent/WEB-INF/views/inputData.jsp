<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>inputData.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" />
	<hr>
	<form action="inputResult" method="post">
		data1 : <input type="text" name="data1" /><br>
		<spring:hasBindErrors name="testBean1">
			<c:if test="${errors.hasFieldErrors('data1') }">
				${errors.getFieldError('data1').defaultMessage }
			</c:if>
		</spring:hasBindErrors>
		<br>
		data2 : <input type="number" name="data2" /><br>
		<spring:hasBindErrors name="testBean1">
			<c:if test="${errors.hasFieldErrors('data2') }">
				${errors.getFieldError('data2').defaultMessage }
			</c:if>
		</spring:hasBindErrors>
		<br>
		<input type="submit" value="전송" />
	</form>
</body>
</html>