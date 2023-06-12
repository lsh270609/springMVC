<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 
      beanData 객체의 멤버변수 data1 에 설정된 값과
      같은 값을 value 로 하는 항목이 선택된 상태로 태그가 생성됨
    -->
    <h2>test1.jsp</h2>
    <form:form modelAttribute="beanData" action="result">
        <form:select path="data1">
            <form:option value="좋은학원">좋은학원</form:option>
            <form:option value="더조은학원">더조은학원</form:option>
            <form:option value="보통학원">보통학원</form:option>
        </form:select>
        <hr>
        <form:select path="data2">
        	<form:options items='${requestScope.dataArr1 }' />
        </form:select>
        <hr>
        <form:select path="data3">
        	<form:options items='${requestScope.dataList1 }' />
        </form:select>
        <hr>
        <form:select path="data4">
        	<form:options items='${requestScope.dataList2 }' itemLabel="key" itemValue="value"/>
        </form:select>
        <hr>
        <form:checkbox path="data5" value="Spring과정"/>Spring과정
        <form:checkbox path="data5" value="포토샵"/>포토샵
        <form:checkbox path="data5" value="C언어"/>C언어
        <hr>
        <form:checkboxes path="data6" items="${requestScope.dataArr2 }"/>
    </form:form>
</body>
</html>