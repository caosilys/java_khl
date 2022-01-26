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
  <script type="text/javascript" src="/spring/resources/js/parseAjax.js"></script>
</head>
<body>
  <div class="container">
	  <div class="form-group">
		  <h2>${board.bd_title}</h2>
		</div>
		<div class="form-group">
		  <label>작성자 : ${board.bd_me_id}</label>
		  <label>조회수 : ${board.bd_views}</label>
		  <c:if test="${board.bd_up == null}">
		  	<label>작성일 : ${board.bd_date}</label>
		  </c:if>
		  <c:if test="${board.bd_up != null}">
		  	<label>최종수정 : ${board.bd_up}</label>
		  </c:if>
		</div>   
    <div class="form-group">
		   <div class="form-control" style="min-height:300px; height:auto; width: auto; border: none" >${board.bd_content}</div>
		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<c:forEach items="${fileList}" var="file">
				<a class="form-control" href="<%=request.getContextPath()%>/board/download?fileName=${file.fi_name}">${file.fi_ori_name}</a>
			</c:forEach>		
		</div>
   	<div class="form-group">
   		<c:if test="${user.me_id == board.bd_me_id}">
   			<a href="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}"><button class="btn btn-outline-primary">수정</button></a>
   			<a href="<%=request.getContextPath()%>/board/delete?bd_num=${board.bd_num}"><button class="btn btn-outline-danger">삭제</button></a>
   			<c:if test="${board.bd_num == board.bd_ori_num && board.bd_type != '공지'}">
	   			<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_num}"><button class="btn btn-secondary">답변</button></a>   		
  			</c:if>
   		</c:if>
 		</div>
 		<div class="form-group commant-box">
 			
 		
 		
 		
 		</div> 		
  </div>
  <script>
	  ajaxService.setContextPath('/spring');
	   
	  $(function() {
		
  	// 댓글 리스트와 pm을 담을 전역변수
		  var com_list;
		  var co_pm;
		// 게시글 확인시 최초 실행		  
		  readCommant(); 
		   
		  console.log('보여줄 댓글 목록');
		  console.log(com_list);
		  console.log('댓글용 페이지메이커');
		  console.log(co_pm);
		  		  
		//이벤트
		
		
		//이벤트
		//함수  
			function readCommant() {			
				var bd_num = ${board.bd_num};			
				var url = '/commant/list?bd_num='+bd_num;				
				function res_function(res) {				
					com_list = res.list;
					co_pm = res.pm;
				}
				// bd_num으로 해당게시글의 commant를 가져옴
				// Controller에서 설정한 Criteria를 확인하여
				// Pagemaker와 commantList를 설정해줌
				ajaxService.parseAjax('get', null, url, res_function);	
			}
		
		//함수
		});
  </script>
</body>
</html>