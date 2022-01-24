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
	  <div class="comment-box mt-3">
			<div class="comment-List mt-3" ></div>
			<div class="comment-pagenation mt-3"></div>
		  <textarea class="form-control text-commant" placeholder="댓글입력" name="commant"> </textarea>
		  <div class="input-group-append mt-3">
		    <button class="btn btn-success btn-commant" >댓글달기</button>
		  </div>  
		</div>		
		
	</div>

	<script>
		$(function(){
						
			// 댓글 등록 했을 때 이벤트
			$('.btn-commant').click(function(){
				var user = '${user}';
				if(user == ''){
					alert('로그인 후 댓글을 등록하세요')
					return
				}
				// 댓글내용 가져오기
				var co_content = $('.text-commant').val();
				var co_bd_num = '${board.bd_num}';
				// 댓글 원본 번호도 필요 -> list 가져온 후
				if(co_content == ''){
					alert("댓글을 입력하세요");
					return;
				}
				
				var commant = {
						co_content : co_content,
						co_bd_num : co_bd_num
				};
				
				$.ajax({
					async : false,
					type : 'POST',
					data : JSON.stringify(commant),
					url : "<%=request.getContextPath()%>/commant/insert" ,
					dataType:"json" ,
					contentType:"application/json; charset=UTF-8",
			    success : function(res){        	  
		    		console.log(res);
		    		
		    		if(res == true){
    					$('.text-commant').val('');
    					alert("댓글 등록이 완료되었습니다");
    					var co_bd_num = '${board.bd_num}';
    					readCommant(co_bd_num, 1);
		    		}
		    		else{
		    			alert("댓글 등록 실패");
		    		}
   				}		
				});
			});
			
			//document에 이벤트를 등록하여 나중에 추가된 아이템에도 이벤트가 적용됨
			$(document).on('click', '.comment-pagenation .page-link', function(){
				var page =$(this).data('page');
				readCommant(co_bd_num, page);
			})
			
				$(document).on('click', '.comment-List .btn_del-commant', function(){
				var co_num = $(this).data('num');
				if(co_num != null){
					$.ajax({
						async : false,
						type : 'get',
						url : "<%=request.getContextPath()%>/commant/delete?co_num="+co_num ,
						dataType:"json" ,
				    success : function(res){
				    	
				    	if(res == true)	alert("댓글 삭제됨");
				    	else alert("댓글 삭제 실패");
				    	
		 					var co_bd_num = '${board.bd_num}';
		 					readCommant(co_bd_num, 1);
						}
					});
				}
			})
					
			var co_bd_num = '${board.bd_num}';
			// 게시글 디테일 들어왔을 떄
			readCommant(co_bd_num, 1);
			
			function readCommant(co_bd_num, page) {
				if(co_bd_num != null){
					$.ajax({
						async : false,
						type : 'get',
						url : "<%=request.getContextPath()%>/commant/list?co_bd_num="+co_bd_num + '&page='+page ,
						dataType:"json" ,
				    success : function(res){
				    	var str='';						    
		 					for(tmp of res.list){					    	
					    	var date = new Date(tmp.co_reg_date);					    	 	
						   	str += createCommantStr(tmp.co_me_id, tmp.co_content, getDateStr(date), tmp.co_num);		    		   		
			   		 }
		 					$('.comment-List').html(str);	
		 					console.log(res.pm);
		 					var pageNationStr = createCommantPagenation(res.pm);
		 					$('.comment-pagenation').html(pageNationStr);	
						}
					});
				}
			}
			
			function createCommantStr(co_me_id, co_content, co_reg_date, co_num){
				
				var str = '' +
				'<div class="comment-box">' +
					'<span class="co_me_id">' + co_me_id + " / " +  '</span>' +
					'<span class="co_reg_date">' + co_reg_date  + '</span>' +
					'<div class="co_content">'+ co_content + '</div>' +					
					'<button class="btn btn_reply-commant btn-outline-info">답글</button>';
					
					if('${user.me_id}' == co_me_id){
						str += '<button class="btn btn_mod-commant btn-outline-warning ml-2" data-num="'+ co_num +'">수정</button>' +
										'<button class="btn btn_del-commant btn-outline-danger ml-2" data-num="'+ co_num +'">삭제</button>';
					}
					
					str += '<hr>' +	
				'</div>';
				
				return str
			}
			
			function getDateStr(date) {
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				var day = date.getDate();
				var hour = date.getHours();
				var minute = date.getMinutes();
				
				return year + "-" +
								month + "-" +
								day + "-" +
								hour + ":" +
								minute;
			}
			
			function createCommantPagenation(pm) {
				str = '';
				str += '' +
				 '<ul class="pagination justify-content-center">' ;
				 var startDisabled = pm.prev ? '' : 'disabled';
				 
				 var endDisabled = pm.next ? '' : 'disabled';	
				 
				 str += '<li class="page-item '+startDisabled+'" ><a class="page-link" href="javascript:void(0);" data-page='+(pm.page-1)+'>이전</a></li>';
				 for(i = pm.startPage; i <=pm.endPage ; i++){
					 var currentActive = pm.page == i ? 'active' : '';
				 	str+= '<li class="page-item ' +currentActive+ ' "><a class="page-link" href="javascript:void(0);" data-page="' +i+'">'+ i + '</a></li>';					 
				 }
				 str += '<li class="page-item '+endDisabled+'" ><a class="page-link" href="javascript:void(0);"  data-page='+(pm.page+1)+'>다음</a></li>';
			   str += '</ul>';
			   
			   return str;
			}
			
		});
		
  </script>
</body>
</html>