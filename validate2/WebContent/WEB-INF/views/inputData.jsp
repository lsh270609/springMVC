<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<!-- Spring Form Custom Tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<form:form modelAttribute="testBean1" action="inputResult" method="post">
		data1 : <form:input type="text" path="data1"/>
				<form:errors path="data1" /><br>
		data2 : <form:input type="number" path="data2"/>
				<form:errors path="data2" /><br>
		<form:button type="submit">전송</form:button>
	</form:form>
</body>
</html>
<%-- 	<form action="inputResult" method="post">
		data1 : <input type="text" name="data1" />
		<spring:hasBindErrors name="testBean1">
			<c:if test="${errors.hasFieldErrors('data1') }">
				<br>
				<spring:message code="Size.testBean1.data1" />
			</c:if>
		</spring:hasBindErrors>
		<br>
		data2 : <input type="number" name="data2" />
		<spring:hasBindErrors name="testBean1">
			<c:if test="${errors.hasFieldErrors('data2') }">
				<br>
				<spring:message code="Max.testBean1.data2" />
			</c:if>
		</spring:hasBindErrors>
		<br>
		<input type="submit" value="전송" />
	</form> --%>