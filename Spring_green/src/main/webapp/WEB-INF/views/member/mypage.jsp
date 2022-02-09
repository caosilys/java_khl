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
	<h1 style="text-align: center">회원정보수정</h1>
	<form action="<%=request.getContextPath()%>/member/modify" method="post">
	  <div class="form-group">
	    <label class="col-md-2">ID:</label>
	    <input type="text" class="form-control col-md-4" name="me_id" value="${user.me_id}" readonly>
	  </div>
	  <div class="form-group">
	    <label class="col-md-2">PW:</label>
	    <input type="password" class="form-control col-md-4" name="me_pw">
	    <label class="col-md-2">PW check:</label>
	    <input type="password" class="form-control col-md-4" name="pw2">
	  </div>
	  <div class="form-group">
	    <label class="col-md-2">이름:</label>
	    <input type="text" class="form-control col-md-4" name="me_name" value="${user.me_name}">
	    <label class="col-md-2">남성:</label>
	    <input type="radio" name="me_gender" value="남성" <c:if test="${user.me_gender == '남성'}">checked</c:if>>
	    <label class="col-md-2">여성:</label>
	    <input type="radio" name="me_gender" value="여성" <c:if test="${user.me_gender == '여성'}">checked</c:if>>
	  </div>
	  <div class="form-group">
	    <label class="col-md-2">생일:</label>
	    <input type="text" class="form-control col-md-4" name="me_birth" value="${user.me_birth_str}">
	    <label class="col-md-2">전화번호:</label>
	    <input type="text" class="form-control col-md-4" name="me_phone" value="${user.me_phone}">
	  </div>
	  <div class="form-group">
	    <label class="col-md-2">주소:</label>
	    <input type="text" class="form-control col-md-10" name="me_address" value="${user.me_address}">
	  </div>
	  <div class="form-group">
	  	<input type="submit" class="form-control" value="수정하기">
	  </div>
	</form>
	<script>					
	// pw 확인
		$('form').submit(function () {
			var me_pw = $('[name=me_pw]').val();
			var me_pw2 = $('[name=pw2]').val();
			
			if(me_pw != pw2){
				alert('비밀번호가 일치하지 않습니다');
				return;
			}
			
			if(me_pw = ''){
				return confirm('비밀번호는 변경되지 않습니다. 계속하시겠습니까?');
			}
		})
	
	</script>       
</body>
</html>