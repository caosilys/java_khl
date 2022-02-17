<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	
	<form action="<%=request.getContextPath()%>/test" method="post" class="container body" enctype="multipart/form-data">
		
		<input type=text name="num">	
	  <label><input type="checkbox" name="color" value="blue"> Blue</label>
    <label><input type="checkbox" name="color" value="red"> Red</label>
		<label><input type="checkbox" name="color" value="black"> Black</label>
    <label><input type="checkbox" name="color" value="white"> White</label>
				
		<button class="btn btn-outline-success col-12">등록</button>
	</form>
  
</body>
</html>