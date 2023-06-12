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
	<h2>requestScope.testBeanByType.data1 : ${requestScope.testBeanByType.data1 }</h2>
	<h2>requestScope.testBeanByType.data2 : ${requestScope.testBeanByType.data2 }</h2>
	<h2>sessionScope.testBeanByName.data3 : ${sessionScope.testBeanByName.data3 }</h2>
	<h2>sessionScope.testBeanByName.data4 : ${sessionScope.testBeanByName.data4 }</h2>
</body>
</html>