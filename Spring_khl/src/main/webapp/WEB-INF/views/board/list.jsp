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
    <div class="container body">
      <table class="table table-dark table-hover">
        <h1>게시글</h1>
        <thead>
          <tr>
          	<th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성시간</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${boardList}">
	        <tr>
	       		 <td>${list.bd_num}</td>
		         <td><a href="<%=request.getContextPath()%>/board/list/${list.bd_num}">${list.bd_title}</a></td>
		         <td>${list.bd_me_id}</td>
		         <td>${list.bd_reg_date}</td>
		  		</tr>
        </c:forEach>
      </table>
      	  	<c:if test="${user != null}">
	  		<a href="<%=request.getContextPath()%>/board/register" style="float: right">
	  			<button class="btn btn-outline-success">글쓰기</button>
	  		</a>	  		
	  	</c:if>
    </div>
  </body>
</html>