<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<title>해더</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/board/list">
<!--  
		<a href="#" style="margin: 8px">
			<img alt="햄버거" src="${pageContext.request.contextPath}/resources/img/Hamburger_icon.png" style="width: 50px; height: 50px">
		</a>
-->
		<div class="input-group mb-3">
	  	<input type="text" class="form-control" name="search" placeholder="Search" value="${pm.criteria.search }">
		  <div class="input-group-append">
		    <button class="btn btn-success" type="submit">검색</button>
		  </div>
		</div>
		<c:if test="${pm.criteria.type != null}">
			<input type="hidden" name="type" value="${pm.criteria.type}">
		</c:if>
		<c:if test="${pm.criteria.type == null}">
			<input type="hidden" name="type" value="일반">
		</c:if>
		
	</form>
</body>
</html>