<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시글</title>
  <style>
	.float_right{float:right;}
	</style>
</head>

<body>
	<div class="container body">
		<c:if test="${board != null}">
			<h1 name="bd_title">${board.bd_title}</h1>
			<div class="row">
				<div class="col"  name="bd_me_id">작성자 : ${board.bd_me_id}</div>
				<div class="col"  name="bd_views">조회수 : ${board.bd_views}</div>
			 	<div class="col"  name="bd_reg_date" id="summernote"> ${board.bd_reg_date_str}</div>
			</div>
			<div style="min-height: 400px; height: auto; width: auto;">${board.bd_content}</div>
			<c:if test="${file != null}">
				<c:forEach items="${file}" var="getfile" >
					<a href="<%=request.getContextPath()%>/board/download?fileName=${getfile.fi_name}" class="form-control">${getfile.fi_ori_name}</a>					
				</c:forEach>
			</c:if>
			<c:if test="${file == null}">
				<label>첨부파일 없음</label>
			</c:if>
			<c:if test="${user != null && board.bd_ori_num == board.bd_num && board.bd_type != '공지' }">
				<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_ori_num}"><button class="btn btn-secondary addcon">답글쓰기</button></a>			
			</c:if>	
			<c:if test="${user.me_id == board.bd_me_id}">
				<a href="<%=request.getContextPath()%>/board/delete?bd_num=${board.bd_num}" >
					<button class="btn btn-secondary float_right">삭제</button>
				</a>
				<a href="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}" >
					<button class="btn btn-secondary float_right" style="margin-right:10px">수정</button>
				</a>			
			</c:if>
		</c:if>
		<c:if test="${board == null}">
			<h1>없거나 삭제된 게시물입니다</h1>	
		</c:if>
	</div>
	<script>
    $('#summernote').summernote({
      placeholder: '내용',
      tabsize: 2,
      height: 300
    });
  </script>
</body>
</html>