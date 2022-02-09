<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>홈</title>

</head>
<body>
	<div>
		<h1>홈</h1>
	</div>
	
	<!--  

	<script>
	$(function() {
		$.ajax({
						 async:true,
	           type:'POST',
	           data: JSON.stringify({id: "아이디", pw : "비번", test : "test 문자"}),
	           url:"<%=request.getContextPath()%>/ajax/test1",
	           dataType:"json",
	           contentType:"application/json; charset=UTF-8",
	           success : function(res){        	  
				    	console.log(res);
				    	console.log("주소 : " + res.address);
				    	console.log("주소 : " + res['address']);
	           }		
		});	
	})
	
	</script>
	-->
</body>
</html>