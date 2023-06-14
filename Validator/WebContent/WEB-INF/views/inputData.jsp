<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.error {color:red; font-size:80%;}
</style>
</head>
<body>
	<h1>inputData.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" /><hr>
	<form:form modelAttribute="testBean1" action="inputProcedure" method="post">
		data1 : <form:input path="data1" type="text" />
				<form:errors path="data1" class="error" /><br>
		data2 : <form:input path="data2" type="text" />
				<form:errors path="data2" class="error" /><br>
		data3 : <form:input path="data3" type="text" />
				<form:errors path="data3" class="error" /><br>
		<form:button type="submit">전송</form:button>
	</form:form>
</body>
</html>