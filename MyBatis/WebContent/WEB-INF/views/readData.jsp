<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>readData.jsp</h1>
	<c:forEach items="${list }" var="obj" varStatus="status">
		<h3>data1 : ${obj.data1 }</h3>
		<h3>data2 : ${obj.data2 }</h3>
		<h3>data3 : ${obj.data3 }</h3>
		<h3>*************************</h3>
	</c:forEach>
	<c:if test="${empty list }">
		<h3>data 가 없습니다.</h3>
	</c:if>
</body>
</html>