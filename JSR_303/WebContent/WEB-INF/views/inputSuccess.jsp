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
</head>
<body>
	<h1>inputSuccess.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" /><hr>
	<h3>data1 : ${requestScope.bean1.data1 }</h3>
	<h3>data2 : ${requestScope.bean1.data2 }</h3>
	<h3>data3 : ${requestScope.bean1.data3 }</h3>
	<h3>data4 : ${requestScope.bean1.data4 }</h3>
	<h3>data5 : ${requestScope.bean1.data5 }</h3>
	<h3>data6 : ${requestScope.bean1.data6 }</h3>
	<h3>data7 : ${requestScope.bean1.data7 }</h3>
	<h3>data8 : ${requestScope.bean1.data8 }</h3>
	<h3>data9 : ${requestScope.bean1.data9 }</h3>
</body>
</html>