<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시글</title>
</head>
<body>
	<div class="container body">

		<h1 class="" >${content.bd_title} </h1>
		<div class="row">
			<div class="col" >작성자 : ${content.bd_me_id}</div>
		 	<div class="col" > ${content.bd_reg_date}</div>
		</div>
		<textarea class="col"  rows="10" disabled Style="resize:none; border: none">${content.bd_content}</textarea>
		
	</div>
</body>
</html>