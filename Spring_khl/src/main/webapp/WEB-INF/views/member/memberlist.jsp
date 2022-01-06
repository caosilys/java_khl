<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <form class="body" action="<%=request.getContextPath()%>" method="post">
    <div class="container">
      <table class="table table-dark table-hover">
        <h1>회원 정보 확인</h1>
        <thead>
          <tr>
            <th>ID</th>
            <th>이름</th>
            <th>성별</th>
            <th>주소</th>
            <th>생일</th>
            <th>전화번호</th>
            <th>관리</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="list" items="${member}">
            <tr>
              <td>${list.me_id}</td>
              <td>${list.me_name}</td>
              <td>${list.me_gender}</td>
              <td>${list.me_address}</td>
              <td>${list.me_birth}</td>
              <td>${list.me_phone}</td>
              <td>
                <input type="submit" name=${list.me_id} value="삭제">
              </td>
            </tr>
          </c:forEach>
      </table>
    </div>
  </form>
  </body>
</html>