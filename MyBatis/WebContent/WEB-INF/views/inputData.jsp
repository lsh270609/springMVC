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
	<h1>inputData.jsp</h1>
	<form action="inputProcedure" method="post">
		data1 : <input type="text" id="data1" name="data1" />
		data2 : <input type="text" id="data2" name="data2" />
		data3 : <input type="text" id="data3" name="data3" />
		<input type="submit" value="전송" />
	</form>
</body>
</html>