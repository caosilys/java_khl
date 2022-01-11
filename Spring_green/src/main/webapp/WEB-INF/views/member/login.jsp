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
    <style>
    .row{margin-bottom: 10px }
    ._left{ float:left; }
    </style>
</head>
<body>
	<h1 style="text-align: center">로그인</h1>
	<form action="<%=request.getContextPath()%>/login" method="post">
	  <div class="_left">   
      <div class="row">
	      <label class="col-md-2">ID:</label>	
		    <input type="text" class="form-control col-md-6" name="me_id">
			</div>	
	    <div class=" row">
	    	<label class="col-md-2">PW:</label>
			  <input type="password" class="form-control col-md-6" name="me_pw">
	    </div>			    
    </div>
    <div class="_left">
    	<input type="submit" value="로그인" style="width: 100px; height: 86px">	
    </div>
	  
	</form>       
</body>
</html>