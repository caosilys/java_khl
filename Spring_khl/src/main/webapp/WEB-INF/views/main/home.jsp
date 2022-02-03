<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
	<body>
		<div class="body">
			<input type="text" id="input">
			<button id="btn">버튼</button>
		</div>
		<script>
			var idRegx = /^[A-z]\w{4,7}$/gm;
			
			$('#btn').click(function(){
				var id = $('#input').val();
				console.log(id);
				if(idRegx.test(id))	alert("맞음");
				else alert("틀렸음");				
			});
		</script>
	</body>
</html>