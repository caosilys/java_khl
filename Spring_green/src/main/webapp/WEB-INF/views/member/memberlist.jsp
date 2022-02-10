<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
</head>
<body>
  <div class="container">
  	<h2>회원관리</h2>    
    <table class="table table-dark table-striped">
      <thead>
        <tr>
          <th>ID</th>
          <th>이름</th>
          <th>성별</th>      
          <th>연락처</th>
          <th>권한</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach items="${list}" var="member">     
          <tr>
            <td name="id">${member.me_id}</td>
						<td>${member.me_name}</td>
            <td>${member.me_gender}</td>
            <td>${member.me_phone}</td>
            <td name="aut">
            	<select>
            		<option <c:if test="${member.me_authority == '회원'}">selected</c:if>>회원</option>
            		<option <c:if test="${member.me_authority == '관리자'}">selected</c:if>>관리자</option>
            	</select>          	
           	</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <ul class="pagination justify-content-center">
    	<c:if test="${pm.prev}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/admin/modify?page=${pm.criteria.page-1}">이전</a></li>
	    </c:if>
	    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
				<c:if test="${i != pm.criteria.page }">
	    		<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/admin/modify?page=${i}">${i}</a></li>
				</c:if>
				<c:if test="${i == pm.criteria.page }">
	    		<li class="page-item active"><a class="page-link" href="">${i}</a></li>
				</c:if>
	    </c:forEach>
	    <c:if test="${pm.next}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/admin/modify?page=${pm.criteria.page+1}">다음</a></li>
	    </c:if>
  	</ul>    
  </div>
  <script>
  	$('[name=aut] select').change(function () {
		
  		var data = {
  				me_id : $(this).parents().siblings('[name = id]').text(),
  				me_authority : $(this).val()
  		}
  		
  		function res_function(res) {
				if(res == 'fail') alert("권한변경에 실패하였습니다.");
				if(res == 'true') alert("권한이 변경되었습니다.")
		}
  		
  		parseAjax('post', data, '/admin/authority', res_function)	
		})
		
		function parseAjax(_type, _data, _url, _funcion){
	    $.ajax({
	        async : false,
	        type : _type,
	        data : JSON.stringify(_data),
	        url : '<%=request.getContextPath()%>' + _url,
	        contentType:"application/json; charset=UTF-8",
	        success : function(res){
	        	console.log(res);
	          if(_funcion != null) _funcion(res);
	        }
	    });
	  };
	
	
  </script>
</body>
</html>