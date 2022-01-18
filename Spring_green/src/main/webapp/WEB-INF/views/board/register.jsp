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
	  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">  
	  <div class="form-group">
	  	<c:if test="${bd_ori_num == null }">
		  	<h2>게시글 등록</h2>
		  </c:if>
		  <c:if test="${bd_ori_num != null }">
		  	<h2>답글 등록</h2>
		  </c:if>
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
			<input type="file" name="files2" class="form-control">
			<input type="file" name="files2" class="form-control">
			<input type="file" name="files2" class="form-control">		
		</div>
   	<div class="form-group">
 			<button type="submit" class=" form-control btn btn-outline-primary">등록</button>
   	</div>
   	<c:if test="${bd_ori_num != null }">
   		<input type="hidden" name="bd_ori_num" value="${bd_ori_num}">
 		</c:if>
 		<c:if test="${bd_type == null }">
   		<input type="hidden" name="bd_type" value="일반">
 		</c:if>
 		<c:if test="${bd_type != null }">
   		<input type="hidden" name="bd_type" value="${bd_type}">
 		</c:if>
 	</form>
 	<script>
      $('[name=bd_content]').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 100
      });
    </script>
</body>
</html>