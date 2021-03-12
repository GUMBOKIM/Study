<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='spring' uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
		<form action='input_pro' method='post'>
	data1 : <input type='text' name='data1'/><br/>
	<spring:hasBindErrors name="dataBean1">
		<c:if test="${errors.hasFieldErrors('data1') }">
			${errors.getFieldError('data1').defaultMessage }
		</c:if>		
	</spring:hasBindErrors>
	data2 : <input type='text' name='data2'/><br/>
	<spring:hasBindErrors name="dataBean1">
		<c:if test="${errors.hasFieldErrors('data2') }">
			${errors.getFieldError('data2').defaultMessage }
		</c:if>		
	</spring:hasBindErrors>
	<button type='sumit'>확인</button>
	</form>
</body>
</html>