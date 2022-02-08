<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand/logo -->
	  <a class="navbar-brand" href="<%=request.getContextPath() %>">HOME</a>
	  
	  <!-- Links -->
	  <ul class="navbar-nav">
	  <!-- 로그인 되어있지 않으면(세션에 유저가 없음) -->
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath() %>/board/list?type=공지">공지사항</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath() %>/board/list">게시글</a>
	    </li>
	    <c:if test="${user.me_authority == '슈퍼관리자'}">
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath() %>/memberlist">회원정보</a>
		    </li>
	    </c:if>
		<c:if test="${user == null}"> 		    
			<li class="nav-item">
		    	<a class="nav-link" href="<%=request.getContextPath() %>/signup">회원가입</a>
		    </li>
		    <li class="nav-item">
		    	<a class="nav-link" href="<%=request.getContextPath() %>/login">로그인</a>
		    </li>
	    </c:if>
	    <!-- 로그인 되어있음(세션에 유저가 있음) -->
	     <c:if test="${user != null}">
		     <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath() %>/mypage">${user.me_id}님의 MyPage</a>
			</li>
			<li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath() %>/logout">로그아웃</a>
		    </li>
	     </c:if>	    

	  </ul>
	</nav>
</body>
</html>