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
	<h1>test2</h1>
	<form:form modelAttribute="userDataBean" action='result'>
		이름 : <form:input path='user_name'></form:input><br/>
		아이디 : <form:input path='user_id'></form:input><br/>
		비밀번호 : <form:input path='user_pw'></form:input><br/>
		우편번호 : <form:input path='user_postcode'></form:input><br/>
		주소1 : <form:input path='user_address1'></form:input><br/>
		주소2 : <form:input path='user_address2'></form:input><br/>
	</form:form>
 
</body>
</html>