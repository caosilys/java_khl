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
    <title>sighup</title>
    <script type="text/javascript" src="/spring/resources/js/parseAjax.js"></script>
    <style>
    .form-group>*{
    	display: inline;
    }
    </style>
</head>
<body>
	<h1 style="text-align: center">회 원 가 입</h1>
	<form action="<%=request.getContextPath()%>/signup" method="post">
	  <div class="form-group">
	    <label class="col-md-2">ID:</label>
	    <input type="text" class="form-control col-md-4" name="me_id">
	    <button type="button" class="btn btn-outline-success col-md-4" id="idCheck">아이디 중복검사</button>
	  </div>
	  <div class="form-group">
	    <label class="col-md-2">PW:</label>
	    <input type="password" class="form-control col-md-4" name="me_pw">
	    <label class="col-md-2">PW check:</label>
	    <input type="password" class="form-control col-md-4" name="pw2">
	  </div>
	  <div class="form-group">
	    <label class="col-md-2">이름:</label>
	    <input type="text" class="form-control col-md-4" name="me_name">
	    <label class="col-md-2">남성:</label>
	    <input type="radio" name="me_gender" value="남성">
	    <label class="col-md-2">여성:</label>
	    <input type="radio" name="me_gender" value="여성">
	  </div>
	  <div class="form-group">
	    <label class="col-md-2">생일:</label>
	    <input type="text" class="form-control col-md-4" name="me_birth" placeholder="9999-12-31">
	    <label class="col-md-2">전화번호:</label>
	    <input type="text" class="form-control col-md-4" name="me_phone" placeholder="010-0000-0000">
	  </div>
	  <div class="form-group">
	    <label class="col-md-2">주소:</label>
	    <input type="text" class="form-control col-md-10" name="me_address">
	  </div>
	  <div class="form-group">
	  	<input type="submit" class="form-control" value="가입하기">
	  </div>
	</form>
	<script>
	
		var idCheck = false;
		ajaxService.setContextPath('<%=request.getContextPath()%>');
		
		$('#idCheck').click(function() {
			var id = $('[name=me_id]').val();			
			var url = '/idcheck?id='+id;
			
			if(id == null || id == ''){
				alert('아이디를 입력하세요.')
				return false;
			}
			
			function res_function(res) {				
	      idCheck = res;
	      
	      if(idCheck) alert('사용가능한 아이디입니다.');
	      else alert('이미 사용중인 아이디입니다.');
			}
			
			ajaxService.parseAjax('get', null, url, res_function);
			
		});
		
		
		$('[name=me_id]').change(function () {
			idCheck = false;
		})
		
		$('form').submit(function () {		
			if(!idCheck){
				alert('아이디 중복검사를 하세요.');
				return false;
			}
			
		})
	
	</script>       
</body>
</html>