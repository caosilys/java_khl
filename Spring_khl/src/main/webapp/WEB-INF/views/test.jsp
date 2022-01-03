<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<style>
			h1{
				font-size: 50px; color: blue;	
			}
		</style>				
	</head>
<body>
	<h1>
		Hello world!  
	</h1>
	<!--  ${serverTime}는 서버에서 화면으로 보낸 데이터, 화면으로 보낸 데이터 -->
	<P>  The time on the server is ${serverTime}. </P>
	<a href="/khl/test?num=1&name=콩">데이터 전송</a>

	<form action="/khl/test/form" method="post">
		<button type="submit" value="전송">전송</button>
		<input type="radio" name="num" id="" value="1">1
		<input type="radio" name="num" id="" value="2">2
		<input type="radio" name="num" id="" value="3">3
		<input type="text" name="name" placeholder="이름">
	</form>
</body>

</html>
