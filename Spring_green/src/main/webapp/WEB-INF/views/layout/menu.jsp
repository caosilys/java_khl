<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<title>메뉴</title>
</head>
<style>
	.list-group-item{
		height: 120px; text-align: center; 
		writing-mode: vertical-rl; text-orientation: upright;
		text-decoration: none;
	}
	a:hover{
		text-decoration: none; font-weight: bold;
	}
</style>
<body>
	<ul class="list-group">
	  <a href="<%=request.getContextPath()%>"><li class="list-group-item">HOME</li></a>
 	  <a href="<%=request.getContextPath()%>/board/list?type=공지"><li class="list-group-item">공지사항</li></a>
	  <a href="<%=request.getContextPath()%>/board/list"><li class="list-group-item">게시판</li></a>
	  <c:if test="${user == null}">
	  	<a href="<%=request.getContextPath()%>/login"><li class="list-group-item">로그인</li></a>
	  	<a href="<%=request.getContextPath()%>/signup"><li class="list-group-item">회원가입</li></a>
	  </c:if>
		<c:if test="${user != null}">
			<a href="<%=request.getContextPath()%>/logout"><li class="list-group-item">로그아웃</li></a>
		</c:if>
	</ul>
</body>
</html>