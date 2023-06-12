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
	<h1>result2.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" />
	<h3>Application Scope 에서 data 가져옴</h3>
	<h3>name : ${applicationScope.name }</h3>
</body>
</html>