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
	<h1>result7.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" />
	<br>
	<h3>session scope 에서 sessionBean2 객체를 가져옴</h3>
	<h3>sessionBean2.data3 : ${sessionScope.sessionBean2.data3 }</h3>
	<h3>sessionBean2.data4 : ${sessionScope.sessionBean2.data4 }</h3>
</body>
</html>