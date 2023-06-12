<%@ page language="java" contentType="text/html; charset=UTF-8;"
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
	<h2>result.jsp</h2>
	<h3>${num1 }</h3>
	<h3>${num2 }</h3>
	<c:if test="${!empty numbers }">
		<c:forEach var="num" items="${numbers }">
			<h3>${num }</h3>
		</c:forEach>
	</c:if>
	<h3>${num3 }</h3>
	<h3>${num4 }</h3>
	<h3>${num3+num4 }</h3>
	<h2></h2>
</body>
</html>