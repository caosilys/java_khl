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
	<!-- 글쓰기 기능으로 들어올 때 -->
	<c:if test="${board.bd_num == null}">
		<h1>게시글 등록</h1>
		<form action="<%=request.getContextPath()%>/board/register" method="post">
			<div class="form-group">
			 	<input type="text" class="form-control" name="bd_title" placeholder="제목">
			</div>
			<div class="form-group">
				<textarea class="form-control" name="bd_content" placeholder="내용" rows="10" style="resize:none"></textarea>
			</div>
			<button class="btn btn-outline-success col-12">등록</button>
		</form>
	</c:if>
	<!-- 수정 기능으로 들어올 때 -->
	<c:if test="${board.bd_num != null}">
		<h1>게시글 수정</h1>
		<form action="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}" method="post">
			<div class="form-group">
			 	<input type="text" class="form-control" name="bd_title" value="${board.bd_title}">  
			</div>
			<div class="form-group">
				<textarea class="form-control" name="bd_content"  rows="10" style="resize:none">${board.bd_content}</textarea>
			</div>
			<button class="btn btn-outline-success col-12">수정</button>
		</form>
	</c:if>
	
	</div>
</body>
</html>