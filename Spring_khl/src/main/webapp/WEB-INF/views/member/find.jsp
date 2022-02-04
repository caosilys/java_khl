<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>아이디/비밀번호찾기</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/commant.js"></script>		
		<style>
			.find ul{
				list-style: none; margin: 0; padding: 0;
			}
			.find .box-tabs li{
				border: 1px solid #dee2e6; border-top: none;
				min-height: 300px;
			}
		</style>
	</head>

<body>

	<div class="container body find">
		<ul class="nav nav-tabs">
	    <li class="nav-item" >
	      <a class="nav-link active" data-target="#idbox">아이디찾기</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" data-target="#pwbox">비밀번호 찾기</a>
	    </li>
    </ul>
    <ul class="box-tabs">
    	<li id="idbox">
	    	<h1>아이디찾기</h1>
    		<div class="form-group">	  
				  <input type="text" class="form-control"  placeholder="이름" name="me_name">
				</div>
    		<div class="form-group">	  
				  <input type="text" class="form-control" placeholder="이메일" name="me_email">
				</div>
				<button class="btn btn-outline-success col-12 btn-find_id">찾기</button>				
    	</li>
    	<li id="pwbox">
	    	<h1>비밀번호찾기</h1>
    		<div class="form-group">	  
				  <input type="text" class="form-control"  placeholder="아이디" name="me_id">
				</div>
    		<div class="form-group">	  
				  <input type="text" class="form-control" placeholder="이메일" name="me_email">
				</div>
				<button class="btn btn-outline-success col-12 btn-find_pw">찾기</button>			
    	</li>
    </ul>
	</div>
	<script>
		commantService.setContextPath("<%=request.getContextPath()%>");
		console.log(commantService);
		
		$('.find .nav-tabs a').click(function () {

			$('.find .nav-tabs a').removeClass('active');
			$(this).addClass('active');			
			var target = $(this).data('target');
			$('.find .box-tabs li').hide();
			$(target).show();
			
		});
		
		$('.find .nav-tabs .active').click();		
		
		$('.btn-find_id').click(function () {
			var name = $('[name=me_name]').val().trim();
			var email = $('[name=me_email]').val().trim();
			
			var member = {
					me_name : name ,
					me_email : email
			}
			
			function res_function(res) {
				console.log(res);
				
				if(!res) {
					alert("id는" + res + "입니다");
				}
				else {
					alert("실패했습니다");
				}
			}
			
			commantService.parseAjax('post', member, '/member/find/Id', res_function);
			
		});
		
		
	
	</script>
</body>
</html>