<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp</h1>
	<img src="images/springIcon.png" alt="spring logo" />
	<!-- get 방식으로 이동하면서 data 전달하기 -->
	<a href="result?num1=100&num2=80&numbers=300&numbers=500">result</a>
	<hr><br>
	<form action="result" method="post">
		number1 : <input type="number" id="number1" name="num1" >
		<br>
		number2 : <input type="number" id="number2" name="num2" >
		<br>
		numbers : <input type="checkbox" id="n1" name="numbers" value="30">30
				  <input type="checkbox" id="n2" name="numbers" value="60">60
		<input type="submit" value="제출">
	</form>
	<hr><br>
	<a href="test3?num1=100&num2=80&numbers=300&numbers=500">test3</a>
	<hr><br>
	<a href="test4/111/222/333">test4</a>
	<hr><br>
	<a href="test5/111/222/333/555">test5</a>
	<hr><br>
	<a href="test6?num1=100&num2=80&numbers=300&numbers=500">test6</a>
	<hr><br>
	<a href="test7?num1=100&num2=80&numbers=300&numbers=500">test7</a>
	<hr><br>
	<a href="test8?num1=100&num2=80&numbers=300&numbers=500">test8</a>
	<hr><br>
	<a href="test9?num1=100&num2=80&numbers=300&numbers=500">test9</a>
	<hr><br>
	<a href="test10?num1=100&num2=80&numbers=300&numbers=500">test10</a>
</body>
</html>