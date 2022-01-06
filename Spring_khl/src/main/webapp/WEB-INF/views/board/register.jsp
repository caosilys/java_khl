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
	<h1>게시글 등록</h1>
		<form action="<%=request.getContextPath()%>/board/register" method="post">
			<div class="form-group">
			 	<input type="text" class="form-control" name="bd_title" placeholder="제목">
			</div>
			<div class="form-group">
				<textarea class="form-control" name="bd_content" placeholder="내용" rows="10"></textarea>
			</div>
			<button class="btn btn-outline-success col-12">등록</button>
		</form>
	</div>
</body>
</html>