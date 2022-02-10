<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>find</title>
<body>
<ul class="nav nav-pills mt-2 container">
  <li class="nav-item">
    <a class="nav-link active" data-toggle="tab" href="#findId">아이디찾기</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#findPw">비밀번호찾기</a>
  </li>
</ul>

<!-- Tab panes -->
<div class="tab-content container">
  <div class="tab-pane  active" id="findId">
  	<div class="input-group">
  		<div>
	  		<input class="row mt-2" type="text" placeholder="이름" name="me_name">
  			<input class="row mt-2" type="text" placeholder="E-mail" name="me_email">
  		</div>
  		<button class="btn btn-find btn-success input-group-append mt-2 ml-4" style="line-height: 55px" value="findId">ID찾기</button>			  		
  	</div>
  	
 	</div>
  <div class="tab-pane fade" id="findPw">
  	<div class="input-group">
  		<div>
	  		<input class="row mt-2" type="text" placeholder="아이디" name="me_id">
  			<input class="row mt-2" type="text" placeholder="E-mail" name="me_email">
  		</div>
  		<button class="btn btn-find btn-success input-group-append mt-2 ml-4" style="line-height: 55px" value="findPw">PW찾기</button>			  		
  	</div>
 	</div>
</div>
<div class="spinner-border ml-5" style="display: none;"></div>
<script>
	$('.btn-find').click(function () {
		
		
		var name = $(this).siblings().children('[name=me_name]').val();
		var id = $(this).siblings().children('[name=me_id]').val();
		var e_mail = $(this).siblings().children('[name=me_email]').val();
		var find = $(this).val();
			
		var data = {
				me_name : name,
				me_id : id,
				me_email : e_mail
		}
		var url = '/find/'+find;
		
		if(find == 'findId') parseAjax('post', data, url, res_findId);
		if(find == 'findPw') {
			$('.spinner-border').show();
			setTimeout(() => {
				parseAjax('post', data, url, res_findPw);	
			}, 300);
		}
		
	});
	
	function res_findId(res) {
		if(res == 'none') alert('해당하는 아이디가 없습니다');
		else if(res == 'fail') alert('아이디 찾기에 실패했습니다');
		else alert('ID는 [' +res+'] 입니다' );	
	};
	
	function res_findPw(res) {
		$('.spinner-border').hide();
		console.log('findPw 응답')
	};
	
	function parseAjax(_type, _data, _url, _funcion){
	    $.ajax({
	        async : false,
	        type : _type,
	        data : JSON.stringify(_data),
	        url : '<%=request.getContextPath()%>' + _url,
	        contentType:"application/json; charset=UTF-8",
	        success : function(res){
	        	console.log(res);
	          if(_funcion != null) _funcion(res);
	        }
	    });
	  };
</script>	  
</body>
</html>