<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test3.jsp</h1>
	<form:form Attribute="userInfoBean" action="result">
		이름 : <form:input path="userName" /><br>	<!-- form custom tag에서 input tag의 path 속성은 일반 input tag의 id, name 속성 두가지 역할 수행 -->
		id : <form:input path="userId" /><br>
		pw : <form:password path="userPw" showPassword="true"/><br>
		addr1 : <form:input path="userAddr1" /><br>
		addr2 : <form:input path="userAddr2" /><br>
		postCode : <form:input path="userPostCode" /><br>
	</form:form>
</body>
</html>