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
	<form action="<%=request.getContextPath()%>/board/modify" method="post" calss="container body" enctype="multipart/form-data">
		<h1>게시글 수정</h1>
		<div class="form-group">
		 	<input type="text" class="form-control" name="bd_title" value="${board.bd_title}">  
		</div>
		<div class="form-group">
			<textarea class="form-control" name="bd_content"  rows="10" style="resize:none">${board.bd_content}</textarea>
		</div>
		<input type="hidden" name="bd_num" value="${board.bd_num}">
		<input type="file" class="btn btn-outline-success col-12" name="file" value="">${file.fi_name}</input>
		<button class="btn btn-outline-success col-12">수정</button>
	</form>
</body>
</html>