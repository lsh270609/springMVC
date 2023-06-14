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
<style>
	.error {color:red; font-size: 85%;}
</style>
</head>
<body>
	<h1>inputData.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" /><hr>
	<form:form modelAttribute="testBean1" action="inputProcedure" method="post">
		data1 : <form:radiobutton path="data1" value="true"/>true&nbsp;&nbsp;&nbsp;
				<form:radiobutton path="data1" value="false"/>false&nbsp;&nbsp;&nbsp;
				<form:errors path="data1" class="error"/><br>
		data2 : <form:radiobutton path="data2" value="true"/>true&nbsp;&nbsp;&nbsp;
				<form:radiobutton path="data2" value="false"/>false&nbsp;&nbsp;&nbsp;
				<form:errors path="data2" class="error"/><br>
		data3 : <form:input path="data3" type="text"/>&nbsp;&nbsp;&nbsp;
				<form:errors path="data3" class="error"/><br>
		data4 : <form:input path="data4" type="text"/>&nbsp;&nbsp;&nbsp;
				<form:errors path="data4" class="error"/><br>	
		data5 : <form:checkbox path="data5" value="check1" />checkbox1&nbsp;&nbsp;&nbsp;
				<form:errors path="data5" class="error"/><br>
		data6 : <form:checkbox path="data6" value="check2" />checkbox2&nbsp;&nbsp;&nbsp;
				<form:errors path="data6" class="error"/><br>
		data7 : <form:input path="data7" type="text"/>&nbsp;&nbsp;&nbsp;
				<form:errors path="data7" class="error"/><br>
		data8 : <form:input path="data8" type="text"/>&nbsp;&nbsp;&nbsp;
				<form:errors path="data8" class="error"/><br>
		data9 : <form:input path="data9" type="text"/>&nbsp;&nbsp;&nbsp;
				<form:errors path="data9" class="error"/><br>
		<form:button type="submit">전송</form:button>
	</form:form>
</body>
</html>