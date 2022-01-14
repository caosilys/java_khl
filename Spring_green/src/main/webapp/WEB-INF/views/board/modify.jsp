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
	<form action="<%=request.getContextPath()%>/board/modify" method="post">  
	  <div class="form-group">
		  <h2>게시글 수정</h2>
		</div>
		<div class="form-group">
		  <label>제목</label>
			<input type="text" class="form-control" name="bd_title" value="${board.bd_title}">
		</div>   
    <div class="form-group">
    		<label>내용</label>
		   <textarea class="form-control" rows="10" style="resize: none;" name ="bd_content" >${board.bd_content}</textarea>
		</div>
   	<div class="form-group">
 			<button type="submit" class=" form-control btn btn-outline-primary">수정</button>
   	</div>
   	<input type="hidden" name="bd_me_id" value="${board.bd_me_id}">
   	<input type="hidden" name="bd_num" value="${board.bd_num}">
 	</form>   
</body>
</html>