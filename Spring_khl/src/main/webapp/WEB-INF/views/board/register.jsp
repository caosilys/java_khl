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
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	
	<form action="<%=request.getContextPath()%>/board/register" method="post" class="container body" enctype="multipart/form-data">

		<c:if test="${bd_ori_num == null && (type == null || type == '일반')}">
			<h1>게시글 등록</h1>
			<input type="hidden" name="bd_type" value="일반">
		</c:if>
		<c:if test="${bd_ori_num == null && type == '공지'}">
			<h1>공지 등록</h1>
			<input type="hidden" name="bd_type" value="공지">
		</c:if>
		<c:if test="${bd_ori_num != null}">
			<h1>답글 등록</h1>
			<input type="hidden" name="bd_ori_num" value="${bd_ori_num}">
			<input type="hidden" name="bd_type" value="일반">
		</c:if>
		
		<div class="form-group">
		 	<input type="text" class="form-control" name="bd_title" placeholder="제목">
		</div>
		<div class="form-group">
			<textarea class="form-control" name="bd_content"  id="summernote"></textarea>
		</div>
		<input type="file" class="btn btn-outline-success col-12" name="file">
		<input type="file" class="btn btn-outline-success col-12" name="file">
		<input type="file" class="btn btn-outline-success col-12" name="file">
		<button class="btn btn-outline-success col-12">등록</button>
	</form>
  <script>
    $('#summernote').summernote({
      placeholder: '내용',
      tabsize: 2,
      height: 300
    });
  </script>
</body>
</html>