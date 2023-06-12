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
	<h1>result5.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" />
	<br>
	<h3>session scope 에서 bean1 객체를 가져옴</h3>
	<h3>data1 : ${sessionScope.bean1.data1 }</h3>
	<h3>data2 : ${sessionScope.bean1.data2 }</h3>
</body>
</html>