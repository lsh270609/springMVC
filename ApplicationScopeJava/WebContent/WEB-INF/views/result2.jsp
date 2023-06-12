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
	<h1>result1.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" />
	<br>
	<h2>ByType 방식 - requestScope에서 객체 가져옴</h2>
	<h3>requestScope.applicationBean3.data5 : ${requestScope.applicationBean3.data5 }</h3>
	<h3>requestScope.applicationBean3.data6 : ${requestScope.applicationBean3.data6 }</h3>
	<h2>ByName 방식 - requestScope에서 객체 가져옴</h2>
	<h3>requestScope.applicationBean4.data7 : ${requestScope.applicationBean4.data7 }</h3>
	<h3>requestScope.applicationBean4.data8 : ${requestScope.applicationBean4.data8 }</h3>
</body>
</html>