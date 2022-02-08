<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
	<body>
		<div class="body container">
			<select class="main-category">
				<option>대분류</option>
			</select>
			<select class="middle-category">
				<option>중분류</option>
			</select>
			<select class="sub-category">
				<option>소분류</option>
			</select>
		</div>
		<script>
		
		setMainCategory();
		
		$('.main-category').change(function () {
			var ma_num = $(this).val()
			setMiddleCategory(ma_num);			
		})
		
		$('.middle-category').change(function () {
			var mi_num = $(this).val()
			setSubCategory(mi_num);			
		})
		
		
		function setMainCategory() {
			var str= '<option value="0">대분류</option>';	
			
			function res_function(res) {
				var list = res.list;		
				for(main of list){
					str += '<option value="'+main.ma_num+'">'+main.ma_name+'</option>'					
				}
				$('.main-category').html(str);
			}			
			
			submitAjax('get', null, '/maincategory', res_function);			
		}
		
		function setMiddleCategory(ma_num) {
			$('.middle-category').children().remove();			
			var str= '<option value="0">중분류</option>';
			
			if(ma_num == 0){
				$('.middle-category').html(str);
				return;
			}
			
			function res_function(res) {
				var list = res.list;		
				for(middle of list){
					str += '<option value="'+middle.mi_num+'">'+middle.mi_name+'</option>'					
				}
				
				$('.middle-category').html(str);
			}
			
			submitAjax('get', null, '/middlecategory?ma_num='+ma_num, res_function);
		}
		
		function setSubCategory(mi_num) {
			$('.sub-category').children().remove();			
			var str= '<option value="0">소분류</option>';
			
			if(mi_num == 0){
				$('.sub-category').html(str);
				return;
			}
			
			function res_function(res) {
				var list = res.list;		
				for(sub of list){
					str += '<option value="'+sub.su_num+'">'+sub.su_name+'</option>'					
				}
				
				$('.sub-category').html(str);
			}
			
			submitAjax('get', null, '/subcategory?mi_num='+mi_num, res_function);
		}
		
		
		
		function submitAjax(_type, _data, _url, _funcion){
			
			$.ajax({
		        async : false,
		        type : _type,
		        data : JSON.stringify(_data),
		        url : '<%=request.getContextPath()%>' +_url,
		        contentType:"application/json; charset=UTF-8",
		        success : function(res){
		          if(_funcion != null) _funcion(res);
		        }
		    });
		  };
		  
		</script>
	</body>
</html>