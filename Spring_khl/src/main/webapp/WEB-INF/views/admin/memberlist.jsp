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
</head>
<body>
  <form class="body" action="<%=request.getContextPath()%>" method="post">
    <div class="container">
      <table class="table table-dark table-hover">
        <h1>회원 정보 확인</h1>
        <thead>
          <tr>
            <th>ID</th>
            <th>이름</th>
            <th>성별</th>
            <th>생일</th>
            <th>권한</th>
            <th>전화번호</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="list" items="${member}">
            <tr>
              <td name="me_id">${list.me_id}</td>
              <td name="me_name">${list.me_name}</td>
              <td>${list.me_gender}</td>
              <td>${list.me_birth_str}</td>
              <td>
	              <select>
	              	<option <c:if test="${list.me_authority == '회원'}">selected</c:if>>회원</option>
	              	<option <c:if test="${list.me_authority == '관리자'}">selected</c:if>>관리자</option>
	              </select>

              </td>
              <td>${list.me_phone}</td>
            </tr>
          </c:forEach>
      </table>
    </div>
  </form>
  <script>
  	$('td select').change(function(){
				
  		var data = {
  				me_id : $(this).parents('tr').find('[name=me_id]').text(),
  				me_authority : $(this).val()
  		}
  		console.log(data);
  		
  		function res_function(res) {
				if(res){
					alert('권한 변경됨');
				}
				else	{
					alert('권한 변경실패');
				}
			}
  		
  		submitAjax(false, "post", data, '/admin/upAut', res_function);
				
  	});
  	
  	function submitAjax(_async, _type, _data, _url, _funcion){
        $.ajax({
						async : _async,
						type : _type,
            data : JSON.stringify(_data),
						url : "<%=request.getContextPath()%>"+_url ,
            contentType:"application/json; charset=UTF-8",
				    success : function(res){
              if(_funcion != null) _funcion(res);
						}
				});
		  };
  </script>
  </body>
</html>