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
      	<c:if test="${pm.type == '일반'}">
        	<h1>게시글</h1>
        </c:if>
        <c:if test="${pm.type == '공지'}">
        	<h1>공지사항</h1>
        </c:if>
        <form action="<%=request.getContextPath()%>/board/list">
	        <div class="input-group mb-3">
					  <input type="text" class="form-control" placeholder="검색어 입력" name="search">
					  <div class="input-group-append">
					    <button class="btn btn-success" type="submit">검색</button>
					  </div>
					</div>
				</form>
        <thead>
          <tr>
          	<th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>작성시간</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="board">
	        <tr>
	       		 <td>${board.bd_num}</td>
	       		 <c:if test="${board.bd_num == board.bd_ori_num}">
		         	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
		         </c:if>
		         <c:if test="${board.bd_num != board.bd_ori_num}">
		         	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">ㄴ답변 : ${board.bd_title}</a></td>
		         </c:if>
		         <td>${board.bd_me_id}</td>
		         <td>${board.bd_views}</td>
		         <td>${board.bd_reg_date_str}</td>
		  		</tr>
        </c:forEach>
      </table>
      <ul class="pagination justify-content-center">
      	<c:if test="${pm.prev}">
      		<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.page-1}&search=${pm.search}">이전</a></li>
      	</c:if>
      	<c:if test="${!pm.prev}">
      		<li class="page-item page-link" disabled="disabled">이전</li>
      	</c:if>
				<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
					<c:if test="${i != pm.page }">
						<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}&search=${pm.search}">${i}</a></li>
					</c:if>
					<c:if test="${i == pm.page }">
						<li class="page-item active"><a class="page-link">${i}</a></li>
					</c:if>				
				</c:forEach>
		    <c:if test="${pm.next}">
		    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.page+1}&search=${pm.search}">다음</a></li>
		    </c:if>
 		    <c:if test="${!pm.next}">
		    	<li class="page-item page-link">다음</li>
		    </c:if>
		    
  		</ul>
 	  	<c:if test="${user != null}">
 	  		<c:if test="${pm.type == '일반'}">
		  		<a href="<%=request.getContextPath()%>/board/register" style="float: right">
		  			<button class="btn btn-outline-success">글쓰기</button>
		  		</a>
	  		</c:if>
	  		<c:if test="${pm.type == '공지'}">
	  			<c:if test="${user.me_authority == '관리자' || user.me_authority == '슈퍼관리자' }">
		  		<a href="<%=request.getContextPath()%>/board/register?type=${pm.type}" style="float: right">
		  			<button class="btn btn-outline-success">글쓰기</button>
		  		</a>
		  		</c:if>
	  		</c:if>
	  	</c:if>
    </div>
  </body>
</html>