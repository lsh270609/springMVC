<%@ page language="java" contentType="text/html; charset=UTF-8;"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="beanData" action="result">
		<form:radiobuttons path="data12" items="${requestScope.dataList2 }" itemLabel="key" itemValue="value"/>
	</form:form>
</body>
</html>