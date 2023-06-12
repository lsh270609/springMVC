<%@ page language="java" contentType="text/html; charset=UTF-8;"
    pageEncoding="UTF-8"%><%-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>test2.jsp</h2>
	<h3>number3 : ${requestScope.db2.number3 }</h3>
	<h3>number4 : ${requestScope.db2.number4 }</h3>
	<h3>number3 : ${requestScope.dataBean2.number3 }</h3>
	<h3>number4 : ${requestScope.dataBean2.number4 }</h3>
</body>
</html>