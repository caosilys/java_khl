<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>test2</title>
</head>
<body>
  <div>아무것도 없는 빈 화면</div>

  <form action="/khl/test2" method="post">
    <input type="text" name="num1" id="" placeholder="1번정수" value="${num1}">
    <input type="text" name="num2" id="" placeholder="2번정수" value="${num2}">
    <div>${sum}</div>
    <button type="submit">합계</button>
  </form>

</body>
</html>