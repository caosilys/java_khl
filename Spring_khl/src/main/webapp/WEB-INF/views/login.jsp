<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>로그인창</title>
</head>
<body>

  <form action="/khl/login"  method="post">
    <input type="text" name="id" id="" placeholder="ID" value="${id}">	<br>
    <input type="password" name="pw" id="" placeholder="password" value="${pw}"> <br>
    <button type="submit">가입</button>
  </form>

</body>
</html>