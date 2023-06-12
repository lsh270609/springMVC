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
	<h2>result.jsp</h2>
	<h3>testBean1.data1 : ${requestScope.testBean1.data1 }</h3>
	<h3>testBean1.data2 : ${requestScope.testBean1.data2 }</h3>
	<br>
	<h3>testBean2.data3 : ${requestScope.testBean2.data3 }</h3>
	<h3>testBean2.data4 : ${requestScope.testBean2.data4 }</h3>
	<br>
	<h3>testBean3.data5 : ${requestScope.testBean3.data5 }</h3>
	<h3>testBean3.data6 : ${requestScope.testBean3.data6 }</h3>
	<br>
	<h3>testBean4.data7 : ${requestScope.testBean4.data7 }</h3>
	<h3>testBean4.data8 : ${requestScope.testBean4.data8 }</h3>
</body>
</html>