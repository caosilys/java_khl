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
  	<c:if test="${pm.criteria.type == '일반' }">
  		<h2>게시판</h2>
  	</c:if>
  	<c:if test="${pm.criteria.type == '공지' }">
  		<h2>공지사항</h2>
  	</c:if>
    
    <table class="table table-dark table-striped">
      <thead>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>      
          <th>작성시간</th>
          <th>조회수</th>
          <th>좋아요/싫어요</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach items="${list}" var="board">     
          <tr>
            <td>${board.bd_num}</td>
            <c:if test="${board.bd_num == board.bd_ori_num }">
            	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
            </c:if>
            <c:if test="${board.bd_num != board.bd_ori_num }">
            	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">ㄴ 답변 : ${board.bd_title}</a></td>
            </c:if>
            <td>${board.bd_me_id}</td>
            <td>${board.bd_date}</td>
            <td>${board.bd_views}</td>
            <td>${board.bd_up}  / ${board.bd_down}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <ul class="pagination justify-content-center">
    	<c:if test="${pm.prev}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.criteria.page-1}&search=${pm.criteria.search}&type=${pm.criteria.type}">이전</a></li>
	    </c:if>
	    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
				<c:if test="${i != pm.criteria.page }">
	    		<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}&search=${pm.criteria.search}&type=${pm.criteria.type}">${i}</a></li>
				</c:if>
				<c:if test="${i == pm.criteria.page }">
	    		<li class="page-item active"><a class="page-link" href="">${i}</a></li>
				</c:if>
	    </c:forEach>
	    <c:if test="${pm.next}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.criteria.page+1}&search=${pm.criteria.search}&type=${pm.criteria.type}">다음</a></li>
	    </c:if>
  	</ul>    
    <div class="form-group">
    	<c:if test="${user != null }">
    		<a href="<%=request.getContextPath()%>/board/register?bd_type=${pm.criteria.type}"><button class="btn btn-outline-dark">글쓰기</button></a>
    	</c:if>   	
    </div>
  </div>
</body>
</html>