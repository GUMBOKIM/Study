<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>result1</h1><br/>
<h3>applicationBean1.data1 : ${requestBean.applicaionBean1.data1}</h3>
<h3>applicationBean1.data2 : ${applicationScope.applicaionBean1.data2}</h3>

<h3>applicationBean2.data3 : ${applicationScope.applicaionBean2.data3}</h3>
<h3>applicationBean2.data4 : ${applicationScope.applicaionBean2.data4}</h3>
</body>
</html>