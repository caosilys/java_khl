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
</head>
<style>
	.float_right{float:right;}
</style>
<body>
	<div class="container body">
		<c:if test="${board != null}">
			<h1 name="bd_title">${board.bd_title}</h1>
			<div class="row">
				<div class="col"  name="bd_me_id">작성자 : ${board.bd_me_id}</div>
			 	<div class="col"  name="bd_reg_date"> ${board.bd_reg_date_str}</div>
			</div>
			<textarea class="col"  rows="10" disabled Style="resize:none; border: none">${board.bd_content}</textarea>
			<c:if test="${file != null}">
				<a href="<%=request.getContextPath()%>/board/download?fileName=${file.fi_name}" class="form-control">${file.fi_ori_name}</a>
			</c:if>
			<c:if test="${file == null}">
				<label>첨부파일 없음</label>
			</c:if>
			<c:if test="${user != null}">
				<a href="#"><button class="btn btn-secondary addcon">답글쓰기</button></a>			
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
</body>
</html>