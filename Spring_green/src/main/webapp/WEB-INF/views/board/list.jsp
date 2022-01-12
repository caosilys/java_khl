<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
</head>
<body>
  <div class="container">
    <h2>게시판</h2>
    <table class="table table-dark table-striped">
      <thead>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성시간</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach items="${list}" var="board">     
          <tr>
            <td>${board.bd_num}</td>
            <td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
            <td>${board.bd_me_id}</td>
            <td>${board.bd_date}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>