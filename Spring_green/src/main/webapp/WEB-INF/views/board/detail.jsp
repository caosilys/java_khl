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
		  <c:if test="${board.bd_upd != null}">
		  	<label>최종수정 : ${board.bd_upd}</label>
		  </c:if>
		</div>   
    <div class="form-group">
		   <div class="form-control" style="min-height:300px; height:auto; width: auto; border: none" >${board.bd_content}</div>
		</div>
		<div class="form-group">
 			<c:if test="${board.bd_num == board.bd_ori_num && board.bd_type != '공지'}">
   			<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_num}"><button class="btn btn-secondary">답변</button></a>   		
 			</c:if>
   		<c:if test="${user.me_id == board.bd_me_id}">
   			<a href="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}"><button class="btn btn-outline-primary">수정</button></a>
   			<a href="<%=request.getContextPath()%>/board/delete?bd_num=${board.bd_num}"><button class="btn btn-outline-danger">삭제</button></a>
   		</c:if>
 		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<c:forEach items="${fileList}" var="file">
				<a class="form-control" href="<%=request.getContextPath()%>/board/download?fileName=${file.fi_name}">${file.fi_ori_name}</a>
			</c:forEach>				
		</div>
		<div class="form-group likes-form justify-content-center" style="display: flex;">
			<c:if test="${like == 0}">
				<button class="btn btn-primary" value="1">좋아요</button>	
				<button class="btn btn-danger ml-2" value="-1">싫어요</button>
			</c:if>
			<c:if test="${like == 1}">
				<button class="btn btn-secondary" value="0">좋아요취소</button>
			</c:if>
			<c:if test="${like == -1}">
				<button class="btn btn-secondary" value="0">싫어요취소</button>
			</c:if>
		</div>
		<hr>
		<c:if test="${user != null}">
	   	<div class="input-group main-commant-box" >
	   		<textarea name="co_content" col="2" style="resize : none; width : 80%;" calss="form-control" ></textarea>
	   		<div class="input-group-append">
	   			<input type="button" class="btn btn-success ml-4" value="댓글등록">	
	   		</div>	  		
	   	</div>
	   	<hr>
   	</c:if>
   	  	
 		<div class="form-group commant-box">
<!--  
			<div class="atc-commant-box">
 				<input type="hidden" name="co_num" value="co_num">
				<span name="co_me_id">작성자</span>
				<span class="ml-2">|</span>
				<span class="ml-2" name="co_date">작성일자</span> <br>
				<div name="co_content">내용</div>
				<div class="atc-commant-btn-box">
						<input type="button" class="btn btn-sm btn-info"  name="btn-com-reply" value="답변">
						<input type="button" class="btn btn-sm btn-warning"  name="btn-com-modify" value="수정">
						<input type="button" class="btn btn-sm btn-danger"  name="btn-com-modify" value="삭제">
				</div>			 								
			</div>			
	-->		
		</div>		
 		<div class="form-group commant-pagenation-box">
<!--   		
 			<ul class="pagination  justify-content-center">
			  <li class="page-item"><a class="page-link" href="#">이전</a></li>
			  <li class="page-item"><a class="page-link" href="#">page</a></li>
			  <li class="page-item"><a class="page-link" href="#">다음</a></li>
			</ul>
-->			
		</div>
  </div>
  <script>
	  ajaxService.setContextPath('/spring');
	   
	  $(function() {
		
  	// 댓글 리스트와 pm을 담을 변수
		  var com_list;
		  var co_pm;
		// 게시글 확인시 실행
		showCommantForm(1);
		    		  
		//이벤트
			// main-commant-box의 댓글 등록 이벤트
			$(document).on('click', '.main-commant-box .btn-success', function(){
				
				var commantStr = $('.main-commant-box [name=co_content]').val();

				if(commantStr.trim() == ''){
					alert('내용을 입력하세요');
					return;
				}

				var data = {
					co_bd_num : '${board.bd_num}' ,
					co_me_id : '${user.me_id}',
					co_content : commantStr
				};
				
				var url = '/commant/insert';

				function res_function(res){
					if(res){
						console.log('정상동작');
						$('.main-commant-box [name=co_content]').val('');
						showCommantForm(1);
					}
				};

				ajaxService.parseAjax('post', data, url, res_function);
			});
		
			// 댓글창의 페이지네이션버튼 클릭시 이벤트
			$(document).on('click', '.pagination .page-link', function(){
				var page = $(this).data('page');
				showCommantForm(page);
			});
			
			// 답변/수정/삭제버튼 이벤트
			$(document).on('click', '.atc-commant-btn-box .btn', function(){
				
				// 화면 변화
				var btn_name = $(this).val();						
				changeCommantForm($(this));
				console.log(btn_name);
				
				if(btn_name == '삭제'){
					
					var co_num = $(this).closest('.atc-commant-box').children('[name=co_num]').val();
					var url = '/commant/delete?co_num='+co_num ;
					function res_function(res) {
						if(res){
							alert("삭제되었습니다")
							showCommantForm(1);
						}
					}
					ajaxService.parseAjax('get', null, url, res_function);
				}
				
			});

			// 댓글수정 / 답변등록 / 취소 버튼 이벤트
			$(document).on('click', '.sub-commant-box .btn', function(){
				
				var this_name = $(this).val()
				console.log(this_name);

				if(this_name == '취소'){
					changeCommantForm($(this));
					return;
				}

				var commantStr = $('.sub-commant-box [name=co_content]').val();
				if(commantStr.trim() == ''){
					alert('내용을 입력하세요');
					return;
				}
				var co_num = $(this).closest('.atc-commant-box').children('[name=co_num]').val();

				var data = {
						co_bd_num : '${board.bd_num}' ,
						co_me_id : '${user.me_id}',
						co_content : commantStr,
						co_num : co_num
					};

				var url;
				
				if(this_name == '댓글수정')	url = '/commant/update';
				if(this_name == '답글등록')	url = '/commant/insert';

				function res_function(res){
					if(res){
						var page = $('.active .page-link').data('page');
						if(this_name == '댓글수정') showCommantForm(page);
						else showCommantForm(1);						
					}
				};

				 ajaxService.parseAjax('post', data, url, res_function);
			});
		
		// 좋아요/싫어요/좋아요취소/싫어요취소 버튼 이벤트
		$(document).on('click', '.likes-form .btn', function () {
						
			var data = {
				li_bd_num : '${board.bd_num}'  ,
				li_me_id : '${user.me_id}',
				li_state : $(this).val()
			}
			
			var url = '/board/likes';
			
			function res_function(res) {
				
				var changeStr = "";
	
				if(res == 0) changeStr += '<button class="btn btn-primary" value="1">좋아요</button> <button class="btn btn-danger ml-2" value="-1">싫어요</button>';
				if(res == 1) changeStr += '<button class="btn btn-secondary" value="0">좋아요취소</button>';
				if(res == -1) changeStr += '<button class="btn btn-secondary" value="0">싫어요취소</button>';
				
				$('.likes-form').html(changeStr);
			}			
			
			ajaxService.parseAjax('post', data, url, res_function);
			
		});
		
		//이벤트

 		//함수
			function showCommantForm(page) {
					readCommant(page); 	  
				// 읽어온 commant와 pm으로 화면구성
					var commantStr ='';
					for(tmp of com_list) commantStr = crateCommantHtml(tmp,commantStr);	
					$('.commant-box').html(commantStr);	
					if(com_list.length > 0) setPagnation();
										
			}
		
			function readCommant(page) {			
				var bd_num = ${board.bd_num};
				var url = '/commant/list?bd_num='+bd_num+'&page='+page;				
				function res_function(res) {				
					com_list = res.list;
					co_pm = res.pm;
				}
				// bd_num으로 해당게시글의 commant를 가져옴
				// Controller에서 설정한 Criteria를 확인하여
				// Pagemaker와 commantList를 설정해줌
				ajaxService.parseAjax('get', null, url, res_function);	
			}
		
			function crateCommantHtml(tmp, commantStr){
				
				tmp.co_num == tmp.co_ori_num ? reply = false : reply = true;
				reply ? re_msg = 'ㄴ답변 : 	' : re_msg = '';
				reply ? re_margin = 'ml-3' : re_margin='';
				
				commantStr+=	'<div class="atc-commant-box '+re_margin+'">';
				commantStr+=		'<input type="hidden" name="co_num" value='+tmp.co_num +'>';
				commantStr+=		'<span name="co_me_id">'+tmp.co_me_id+'</span>';
				commantStr+=		'<span class="ml-2">|</span>';
				commantStr+=		'<span class="ml-2" name="co_date">'+tmp.co_date+'</span> <br>';
				
				commantStr+=		'<div name="co_content">'+re_msg+tmp.co_content+'</div>';
				commantStr+=		'<div class="atc-commant-btn-box">';
				
				//로그인 한 사람만 버튼이 보임
				if('${user.me_id}' != ''){
					// 답글에 답글은 추가로 답글이 달리지 않음
					if(tmp.co_num == tmp.co_ori_num)
					{
						commantStr+=			'<input type="button" class="btn btn-sm btn-info"  name="btn-com-reply" value="답변">';	
					}
					// 로그인한 사람이 댓글 작성자일 경우에만 수정/삭베 버튼이 보임
					if('${user.me_id}' == tmp.co_me_id){
						commantStr+=			'<input type="button" class="btn btn-sm btn-warning ml-2"  name="btn-com-modify" value="수정">';				
						commantStr+=			'<input type="button" class="btn btn-sm btn-danger ml-2"  name="btn-com-modify" value="삭제">';	
					}	
				}	
				
				commantStr+=		'</div>';							
				commantStr+=	'</div>';	
				commantStr+=	'<hr>'; 
				
				return commantStr;
			}
			
			function setPagnation() {

				co_pm.prev ? prev = '' : prev = 'disabled';	
				co_pm.next ? next = '' : next = 'disabled';
				
				var pagenationStr = '';
				pagenationStr += '<ul class="pagination  justify-content-center">';					
				
				pagenationStr +=  '<li class="page-item '+prev+'"><a class="page-link" data-page="'+(co_pm.criteria.page-1)+'" href="javascript:void(0);">이전</a></li>';
				
				for(var i = co_pm.startPage ; i <= co_pm.endPage ; i++){
					co_pm.criteria.page == i ? act = 'active' : act ='';
					pagenationStr +=  '<li class="page-item '+act+'"><a class="page-link" data-page="'+i+'" href="javascript:void(0);">'+i+'</a></li>';
				}
								
				pagenationStr +=  '<li class="page-item '+next+'"><a class="page-link" data-page="'+(co_pm.criteria.page+1)+'" href="javascript:void(0);">다음</a></li>';
				
				pagenationStr +='</ul>';
				
				$('.commant-pagenation-box').html(pagenationStr)
				
			};
				
			function changeCommantForm(btn) {
				
				var this_name = btn.val()
				
				if(this_name == '삭제') return; 
				
				// 다른 답변/수정 창 제거
				$('.sub-commant-box').remove();
				// 다른 답변/수정 창에서 숨겨놨던 버튼 보이기 
				$('.atc-commant-btn-box').show();
				// 다른 수정 창에서 숨겨놨던 댓글 내용 보이기
				$('.atc-commant-box [name=co_content]').show();
				// 선택된 댓글그룹의 기존 버튼 숨기기
				btn.parent().hide();

				if(this_name == '취소') return; 
				
				var mainBtnVal = "";
				var content ="";
				var beforeObj;
				

				if(this_name == '수정'){
					mainBtnVal = "댓글수정";
					content = btn.parent().siblings('[name=co_content]').text();
					beforeObj = btn.parent().siblings('br');
										
					btn.parent().siblings('[name=co_content]').hide();
				}
				
				if(this_name == '답변'){
					mainBtnVal = "답글등록";
					content = "";
					beforeObj = btn.parent().siblings('[name=co_content]');
				}
								
				var changeHtmlStr = '';
				
				changeHtmlStr+= 	'<div class="input-group sub-commant-box" >';
				changeHtmlStr+=			'<textarea name="co_content" col="2" style="resize : none; width : 70%;" calss="form-control" >'+content+'</textarea>';
				changeHtmlStr+=			'<div class="input-group-append sub-commant-btn-box">';
				changeHtmlStr+=				'<input type="button" class="btn btn-primary ml-2" value="'+mainBtnVal+'">';
				changeHtmlStr+=				'<input type="button" class="btn btn-dark ml-2" value="취소">	';
				changeHtmlStr+=			'</div>';	  		
				changeHtmlStr+=		'</div>';
				
				beforeObj.after(changeHtmlStr);
				
			}
			
			
		//함수
		});
  </script>
</body>
</html>