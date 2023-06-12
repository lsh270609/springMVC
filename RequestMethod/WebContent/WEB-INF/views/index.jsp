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
	<h1>index.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" /><br>
	<a href="test1">test1 - get</a><br>
	<form action="test1" method="post">
		<input type="submit" value="제출">
	</form><hr><br>
	<a href="test4">test4</a>
	<form action="test4" method="post">
		<input type="submit" value="postTest4">
	</form>
	<hr><br>
	<a href="test5">test5</a>
	<form action="test5" method="post">
		<input type="submit" value="postTest5">
	</form>
	<hr><br>
	<a href="test6">test6</a>
	<form action="test6" method="post">
		<input type="submit" value="Test6">
	</form>
</body>
</html>