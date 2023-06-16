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
	<h1>updateData.jsp</h1>
	<c:forEach items="${list }" var="obj">
		data1 : <input type="radio" value="${obj.data1 }" onclick="func()"/>
	</c:forEach>
	<form action="updateProcedure" method="post">
		data1 : <input type="hidden" id="data1" name="data1" />
		data3 : <input type="text" id="data3" name="data3" />
		<input type="submit" value="전송" />
	</form>
	<script>
	</script>
</body>
</html>