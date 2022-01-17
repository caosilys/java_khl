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
	<form action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">  
	  <div class="form-group">
		  <h2>게시글 등록</h2>
		</div>
		<div class="form-group">
		  <label>제목</label>
			<input type="text" class="form-control" name="bd_title">
		</div>   
    <div class="form-group">
    		<label>내용</label>
		   <textarea class="form-control" rows="10" style="resize: none;" name ="bd_content" ></textarea>
		</div>.
		<div class="form-group">
			<label>첨부 파일</label>
			<input type="file" name="files" class="form-control">
			<input type="file" name="files" class="form-control">
			<input type="file" name="files" class="form-control">		
		</div>
   	<div class="form-group">
 			<button type="submit" class=" form-control btn btn-outline-primary">등록</button>
   	</div>
 	</form>   
</body>
</html>