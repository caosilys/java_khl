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
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/commant.js"></script>
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
    // 기본 경로 지정
    
   console.log(commantService);
    
   commantService.setContextPath("<%=request.getContextPath()%>");
		
		$(function(){

       // 게시글 디테일 들어왔을 떄
			var co_bd_num = '${board.bd_num}';		
			readCommant(co_bd_num, 1);
			
    //이벤트  
    //document에 이벤트를 등록하여 나중에 추가된 아이템에도 이벤트가 적용됨
		// 댓글 등록 했을 때 이벤트 (ajax 사용)
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

        var url = "/commant/insert"

				function response_funcion(res){
          if(res == true){
    					$('.text-commant').val('');
    					alert("댓글 등록이 완료되었습니다");
    					var co_bd_num = '${board.bd_num}';
    					readCommant(co_bd_num, 1);
		    		}
		    		else{
		    			alert("댓글 등록 실패");
		    		}
        };
        commantService.parseAjax('POST', commant, url, response_funcion);
        // submitAjax(false, 'POST', commant, url, response_funcion);

			});
			
			// 댓글페이지 전환 이벤트
			$(document).on('click', '.comment-pagenation .page-link', function(){
				var page =$(this).data('page');
				readCommant(co_bd_num, page);
			})
			
      //댓글 삭제버튼 이벤트 (ajax 사용)
			$(document).on('click', '.comment-List .btn_del-commant', function(){
				var co_num = $(this).data('num');
				if(co_num != null){

          var url = "/commant/delete?co_num="+co_num;

          function response_funcion(res){
            if(res == true)	alert("댓글 삭제됨");
				    	else alert("댓글 삭제 실패");
				    	
		 					var co_bd_num = '${board.bd_num}';
		 					
              var page = $('.comment-pagenation .active').text();
              readCommant(co_bd_num, page);
          }
          commantService.parseAjax('get', null, url, response_funcion);
          // submitAjax(false, 'get', null, url, response_funcion);
				}
			})
      
			// 댓글 '수정' 버튼 누를 때 이벤트
			$(document).on('click', '.comment-List .btn_mod-commant', function(){
        checkAddCommantForm();
        var content = $(this).siblings('.co_content').text();
        $(this).siblings('.co_content').hide();
        $(this).parent().children('.btn').hide();
        var str = ''+
          '<div class="add_commant_form">' +    
            '<textarea class="form-control co_mod_content" cols="3">'+content+'</textarea>' +
            '<button class="btn btn-mod_commant_ok btn-outline-info mt-2">댓글수정</button>' +
            '<button class="btn btn-commant_cancel btn-outline-danger ml-2 mt-2">취소</button>' +
          '</div>';
        $(this).siblings('.co_reg_date').after(str);   
			});

      // 댓글 '댓글수정' 버튼 누를 때 이벤트 (ajax 호출)
			$(document).on('click', '.comment-List .btn-mod_commant_ok', function(){

        var co_content = $('.add_commant_form .co_mod_content').val();      
        var co_num = $(this).parent().siblings('[name=co_num]').val();
        
        var commant = {
						co_content : co_content,
						co_num : co_num
				};

        var url = "/commant/modify";
        
        commantService.parseAjax('POST', commant, url, null);

        // submitAjax(false, 'POST', commant, url, null);

        var co_bd_num = '${board.bd_num}';
        var page = $('.comment-pagenation .active').text();
        readCommant(co_bd_num, page);
			});
      
      // 댓글 수정 및 답글등록중 '취소' 버튼 누를 때 이벤트
      $(document).on('click', '.comment-List .btn-commant_cancel', function(){
        checkAddCommantForm();
			});

      // 답글 버튼 클릭이벤트
      $(document).on('click', '.btn-reply_commant', function(){
        checkAddCommantForm();

        var co_num = $(this).data('num');
        
        var id = '${user.me_id}';
        if(id == ''){
          alert('로그인이 필요합니다');
          return;
        }
        //이전 답글창 제거 및 새 답글창 추가
        $(this).parent().children('.btn').hide();
        var str = ''+
          '<div class="add_commant_form">' + 
            '<textarea class="form-control co_reply_content" cols="3"></textarea>' +
            '<button class="btn btn-reply_commant_ok btn-outline-info mt-2">답글 등록</button>' +
            '<button class="btn btn-commant_cancel btn-outline-danger ml-2 mt-2">취소</button>' +
          '</div>';      
        $(this).siblings('.co_content').after(str);
			});

      // '답글등록' 버튼 클릭이벤트
      $(document).on('click', '.btn-reply_commant_ok', function(){
        //답글에 보내야 할것
        // CommantVO commant
        // 원글 번호, 원 댓글 번호, 대댓글 내용
        var co_content = $('.co_reply_content').val();

        var commant = {
          co_bd_num : '${board.bd_num}',
          co_ori_num : $(this).parent().siblings('[name=co_num]').val(),
          co_content : $('.co_reply_content').val()
        };

        var url = "/commant/insert";

        function response_funcion(res){
          console.log(res);

          if(res == true){
            var co_bd_num = '${board.bd_num}';
            var page = $('.comment-pagenation .active').text();
            console.log(co_bd_num + " / " + page);
            readCommant(co_bd_num, page);
          }

        }

        commantService.parseAjax('POST', commant, url, response_funcion);
        // submitAjax(false, 'POST', commant, url, response_funcion);        
      });

      // 함수
      //댓글 불러오기 (ajax 사용)
      function readCommant(co_bd_num, page) {
				if(co_bd_num != null){

          var url = "/commant/list?co_bd_num="+co_bd_num + '&page='+page;
          function response_funcion(res){
            var str='';						    
	 					for(tmp of res.list){					    	
				    	var date = new Date(tmp.co_reg_date);					    	 	
					   	str += createCommantStr(tmp, getDateStr(date));		    		   		
		   		 }
	 					$('.comment-List').html(str);	
	 					var pageNationStr = createCommantPagenation(res.pm);
	 					$('.comment-pagenation').html(pageNationStr);
          }

          commantService.parseAjax('get', null, url, response_funcion);
          // submitAjax(false, 'get', null, url, response_funcion);
				}
			}
			// commant 객체를 html태그용 str로 변환
			function createCommantStr(commant, co_reg_date){				
				var str = '' +
				'<div class="comment-box">' +
          '<input type="hidden" name="co_num" value="'+commant.co_num+'">';

          if(commant.co_num != commant.co_ori_num){
            str += '<span>ㄴ답글 / </span>';
          }
          str += ''+
					'<span class="co_me_id">' + commant.co_me_id + " / " +  '</span>' +
					'<span class="co_reg_date">' + co_reg_date  + '</span>'+
					'<div class="co_content">'+ commant.co_content + '</div>';
          
          if(commant.co_ori_num == commant.co_num){
            str += '<button class="btn btn-reply_commant btn-outline-info" data-num="'+commant.co_num+'">답글</button>';   
          };				
										
					if('${user.me_id}' == commant.co_me_id){
						str += '<button class="btn btn_mod-commant btn-outline-warning ml-2" data-num="'+ commant.co_num +'">수정</button>' +
										'<button class="btn btn_del-commant btn-outline-danger ml-2" data-num="'+ commant.co_num +'">삭제</button>';
					};					
					str += '<hr>' +	
				'</div>';
				
				return str
			}
			//date 타입을 string으로 변환
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
			// 페이지네이션 부분 생성
			function createCommantPagenation(pm) {
				str = '';
				str += '' +
				 '<ul class="pagination justify-content-center">' ;
				 var startDisabled = pm.prev ? '' : 'disabled';
				 
				 var endDisabled = pm.next ? '' : 'disabled';	
				 
				 str += '<li class="page-item '+startDisabled+'" ><a class="page-link" href="javascript:void(0);" data-page='+(pm.page-1)+'>이전</a></li>';
				 for(i = pm.startPage; i <=pm.endPage ; i++){
					 var currentActive = pm.page == i ? 'active' : '';
				 	str+= '<li class="page-item ' +currentActive+ '"><a class="page-link" href="javascript:void(0);" data-page="' +i+'">'+ i + '</a></li>';					 
				 }
				 str += '<li class="page-item '+endDisabled+'" ><a class="page-link" href="javascript:void(0);"  data-page='+(pm.page+1)+'>다음</a></li>';
			   str += '</ul>';
			   
			   return str;
			}
      // 추가된 댓글폼삭제(수정, 답댓글 폼이 여러개 나오지 않게)
      function checkAddCommantForm(){
        var commantForm = $('.add_commant_form');
        var oldContent = commantForm.siblings('.co_content');
        if(commantForm != null) {
          commantForm.siblings('.btn').show();
          if(oldContent != null) commantForm.siblings('.co_content').show();
          commantForm.remove();
        }
      }
      // ajax 간략화
      function submitAjax(_async, _type, _data, _url, _funcion){
        $.ajax({
						async : _async,
						type : _type,
            data : JSON.stringify(_data),
						url : "<%=request.getContextPath()%>"+_url ,
						dataType:"json",
            contentType:"application/json; charset=UTF-8",
				    success : function(res){
              if(_funcion != null) _funcion(res);
						}
				});
		  }	
	  });
		
  </script>
</body>
</html>