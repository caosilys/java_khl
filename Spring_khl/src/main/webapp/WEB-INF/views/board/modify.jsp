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
	<form action="<%=request.getContextPath()%>/board/modify" method="post" calss="container body" enctype="multipart/form-data">
		<h1>게시글 수정</h1>
		<div class="form-group">
		 	<input type="text" class="form-control" name="bd_title" value="${board.bd_title}">  
		</div>
		<div class="form-group">
			<textarea class="form-control" name="bd_content"  id="summernote">${board.bd_content} </textarea>>
		</div>
		<input type="hidden" name="bd_num" value="${board.bd_num}">
		<div class="add_div">	
			<c:forEach items="${file}" var="getfile">
				<div class="form-group">							
					<span>${getfile.fi_ori_name}</span>
					<a class="btn_del_file">X</a>
					<input type="hidden" name="fileNums" value="${getfile.fi_num}">
				</div>	
			</c:forEach>
		</div>
		<c:forEach begin="1" end="${3-file.size()}">
			<input type="file" class="btn btn-outline-success col-12" name="file">
		</c:forEach>
				
		<button class="btn btn-outline-success col-12">수정</button>
	</form>
	<script>
		$('.add_div .btn_del_file').click(function(e){
			e.preventDefault();
			$(this).parent().remove();
			var str = '<input type="file" class="btn btn-outline-success col-12" name="file">';
			$('.add_div').append(str);
		})
		
    $('#summernote').summernote({
      placeholder: '내용',
      tabsize: 2,
      height: 300
    });
  
	</script>
</body>
</html>