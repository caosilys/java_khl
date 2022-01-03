<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>test3</title>
</head>
<body>
  <div>테스트 3 화면</div>

  <form action="/khl/test3" >
    <input type="text" name="id" id="" placeholder="ID" value="${id}">
    <input type="password" name="pw" id="" placeholder="password" value="${pw}">
    <button type="submit">가입</button>
  </form>

</body>
</html>