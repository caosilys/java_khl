<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
	<title>스프링</title>
	<style>
		body>div{
			margin: 0; padding: 0; box-sizing: border-box; position: absolute;
		}
		
		.header{
			background-color: red; top: 0; left: 100px;
			width: calc(100vh - 100px); height: 100px; z-index: 2;
	  }
	  
		.menu{
			background-color: blue; top: 0; left: 0;
			width: 100px; height: 100vh;
		}
		
		.content{
			background-color: yellow; left: 100px;
			width: calc(100vh - 100px); height: 100vh; z-index: 1;
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