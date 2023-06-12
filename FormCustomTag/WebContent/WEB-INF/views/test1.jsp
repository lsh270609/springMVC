<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1.jsp</h1>
	<form action="result" method="post">
		<c:if test="${empty strList }">
			<h2>strList가 비어있습니다.</h2>
		</c:if>
		이름 : <input type="text" name="userName" placeholder="${requestScope.userInfo.userName }">
		id : <input type="text" name="userId" placeholder="${requestScope.userInfo.userId }">
		pw : <input type="password" name="userPw" placeholder="${requestScope.userInfo.userPw }">
		addr1 : <input type="text" name="userAddr1" placeholder="${requestScope.userInfo.userAddr1 }">
		addr2 : <input type="text" name="userAddr2" placeholder="${requestScope.userInfo.userAddr2 }">
		postCode : <input type="text" name="userPostCode" placeholder="${requestScope.userInfo.userPostCode }">
		<input type="submit" value="제출">
	</form> 
</body>
</html>