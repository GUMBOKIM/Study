<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href='test1?data1=100&data2=200&data3=300&data3=400&data3=500'>test1
		get</a>
	</h1>
	<hr />
	<form action='test2' method='post'>
		data1 : <input type='text' name='data1' /><br /> data2 : <input
			type='text' name='data2' /><br /> data3 : <input type='checkbox'
			name='data3' value='100' />data3 100 <input type='checkbox'
			name='data3' value='200' />data3 200 <input type='checkbox'
			name='data3' value='300' />data3 300 <br />
		<button type='submit'>test2 post</button>
	</form>

	<hr />
	<a href='test3?data1=100&data2=200&data3=300&data3=400&data3=500'>test3</a>
	</h1>

	<hr />
	<a href='test4/100/200/300'>test4</a>
	</h1>

	<hr />
	<a href='test5?data1=100&data2=200&data3=300&data3=400&data3=500'>test5</a>
	</h1>
	
	<hr />
	<a href='test6?data1=100&data2=200&data3=300&data3=400&data3=500'>test6</a>
	</h1>
	
	<hr />
	<a href='test7?data1=100'>test7</a>
	</h1>

</body>
</html>