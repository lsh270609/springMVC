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
	<img src="images/springIcon.png" alt="spring logo" />
	<form action="test1" method="post">
		number1 : <input type="text" id="number1" name="number1">
		<br>
		number2 : <input type="text" id="number2" name="number2">
		<br>
		<input type="submit" value="제출">
	</form>
	<hr>
	<form action="test2" method="post">
		number3 : <input type="text" id="number3" name="number3">
		<br>
		number4 : <input type="text" id="number4" name="number4">
		<br>
		<input type="submit" value="제출">
	</form>
		<hr>
	<form action="test3" method="post">
		number5 : <input type="text" id="number5" name="number5">
		<br>
		number6 : <input type="text" id="number6" name="number6">
		<br>
		<input type="submit" value="제출">
	</form>
</body>
</html>