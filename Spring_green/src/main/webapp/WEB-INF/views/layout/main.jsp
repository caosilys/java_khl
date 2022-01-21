<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<title>스프링</title>
	<style>
		body>div{
			margin: 0; padding: 0; box-sizing: border-box; position: absolute;
		}
		
		.header{
			background-color: red; top: 0; left: 0px; position : fixed;
			min-width:120vh; height: 40px; z-index: 2; opacity: 0.5;
	  }
	  
		.menu{
		  top: 40px; left: 0; position : fixed;
			width: 70px; height: 120vh;
		}
		
		.content{
			left: 70px; top:40px;
			width: calc(120vh - 70px);
		}
		._content{
			position: absolute; top:100px;
		}
	</style>
</head>
<body style="margin : 0;">
	<div class="header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div class="menu">
		<tiles:insertAttribute name="menu" />
	</div>
  <div class="content">
  	<tiles:insertAttribute name="content" />
  </div>
</body>
</html>